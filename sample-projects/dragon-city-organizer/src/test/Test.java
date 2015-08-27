package test;

import cococare.common.CCFormat;
import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import java.io.File;
import java.util.List;
import model.bo.DragonBo;
import model.bo.HabitatBo;
import model.dao.DragonDao;
import model.dao.HabitatDao;
import model.mdl.DragonCityOrganizerModule;
import model.obj.Dragon;
import model.obj.Habitat;
import model.obj.HabitatType;

public class Test {

    public static void main(String[] args) {
        CCHibernate hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(new File(CCFile.getFileSystConfPath(), "dtbs.conf"));
        DragonCityOrganizerModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();

        hibernate.executeUpdate("DELETE Dragon WHERE code IN ('D0105','D0501')", null);
        List<Dragon> dragons2 = new DragonDao().getListUnlimited();
        for (Dragon dragon : dragons2) {
            dragon.setHabitat(null);
            hibernate.saveOrUpdate(dragon);
        }
        new HabitatDao().deleteAll();
        for (Long L = 12L; L > 0L; L--) {
            HabitatType habitatType = hibernate.get(HabitatType.class, L);
            List<Dragon> dragons = new DragonDao().getListUnlimitedBy(habitatType, false);
            if (!dragons.isEmpty()) {
                double habitatCount = Math.ceil((double) dragons.size() / (double) (habitatType.getMaxDragons() - 1));
                for (int i = 0; i < habitatCount; i++) {
                    Habitat habitat = new Habitat();
                    habitat.setCode("H" + CCFormat.pack(habitatType.getId().toString(), "0", 2) + (i + 1));
                    habitat.setHabitatType(habitatType);
                    habitat.setNo(i + 1);
                    hibernate.saveOrUpdate(habitat);
                }
                for (Dragon dragon : dragons) {
                    dragon.setRevenuesTotal(new DragonBo().countRevenuesTotal(dragon.getRevenues(), dragon.getRevenuesPercent()));
                    Habitat habitat = new HabitatDao().getMinTotalRevenuesBy(habitatType);
                    dragon.setHabitat(habitat);
                    hibernate.saveOrUpdate(dragon);
                    new HabitatBo().saveOrUpdate(habitat);
                }
            }
        }
    }
}