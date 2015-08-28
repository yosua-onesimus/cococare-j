package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.DragonCityOrganizerDao;
import model.obj.Habitat;
import model.obj.HabitatType;
//</editor-fold>

public class HabitatDao extends DragonCityOrganizerDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return Habitat.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public Habitat getMinTotalRevenuesBy(HabitatType habitatType) {
        hql.start().
                where("totalDragon < :totalDragon").
                where("habitatType = :habitatType").
                orderBy("totalRevenues ASC").
                orderBy("code DESC");
        parameters.start().
                set("totalDragon", habitatType.getMaxDragons()).
                set("habitatType", habitatType);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}