package test;

import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import java.io.File;
import java.util.List;
import model.dao.DragonDao;
import model.mdl.DragonCityOrganizerModule;
import model.obj.Dragon;
import model.obj.HabitatType;

public class Test {

    public static void main(String[] args) {
        CCHibernate hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(new File(CCFile.getFileSystConfPath(), "dtbs.conf"));
        DragonCityOrganizerModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();
        HabitatType habitatType = hibernate.get(HabitatType.class, 1l);
        System.out.println(habitatType.getName());
        List<Dragon> dragons = new DragonDao().getListUnlimitedBy(habitatType);
        for (Dragon dragon : dragons) {
            System.out.println(dragon.getCustomName());
        }
    }
}