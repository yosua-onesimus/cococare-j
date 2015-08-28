package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.pack;
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.DragonDao;
import model.dao.HabitatDao;
import model.dao.HabitatTypeDao;
import model.obj.Dragon;
import model.obj.Habitat;
import model.obj.HabitatType;
//</editor-fold>

public class DragonHabitatOptimizationBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HabitatTypeDao habitatTypeDao;
    private HabitatDao habitatDao;
    private DragonDao dragonDao;
    //
    private HabitatBo habitatBo = new HabitatBo();
    private DragonBo dragonBo = new DragonBo();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized void execute() {
        //1. delete unused dragon
        dragonDao.deleteUnusedDragon();
        //2. update habitat to null
        dragonDao.updateHabitatToNull();
        //3. delete all habitat
        habitatDao.deleteAll();
        //4. optimization begin
        List<HabitatType> habitatTypes = habitatTypeDao.getListUnlimited();
        for (int index = habitatTypes.size() - 1; index >= 0; index--) {
            HabitatType habitatType = habitatTypes.get(index);
            List<Dragon> dragons = dragonDao.getListUnlimitedBy(habitatType, false);
            if (!dragons.isEmpty()) {
                //4.1. create habitat
                double habitatCount = Math.ceil((double) dragons.size() / (double) (habitatType.getMaxDragons() - 1));
                for (int i = 0; i < habitatCount; i++) {
                    Habitat habitat = new Habitat();
                    habitat.setCode("H" + pack(habitatType.getId().toString(), "0", 2) + (i + 1));
                    habitat.setHabitatType(habitatType);
                    habitat.setNo(i + 1);
                    habitatDao.saveOrUpdate(habitat);
                }
                //4.2. distribute dragon
                for (Dragon dragon : dragons) {
                    dragon.setRevenuesTotal(dragonBo.countRevenuesTotal(dragon.getRevenues(), dragon.getRevenuesPercent()));
                    Habitat habitat = habitatDao.getMinTotalRevenuesBy(habitatType);
                    dragon.setHabitat(habitat);
                    dragonDao.saveOrUpdate(dragon);
                    habitatBo.saveOrUpdate(habitat);
                }
            }
        }
    }
//</editor-fold>
}