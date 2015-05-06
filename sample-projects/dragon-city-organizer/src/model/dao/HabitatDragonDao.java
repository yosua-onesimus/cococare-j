package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.List;
import model.mdl.DragonCityOrganizerDao;
import model.obj.Dragon;
import model.obj.HabitatDragon;
//</editor-fold>

public class HabitatDragonDao extends DragonCityOrganizerDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return HabitatDragon.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public List<Dragon> getDragonsUnlimited() {
        hql.start().
                select("dragon");
        parameters.start();
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}