package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.DragonCityOrganizerDao;
import model.obj.HabitatType;
//</editor-fold>

public class HabitatTypeDao extends DragonCityOrganizerDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return HabitatType.class;
    }
//</editor-fold>
}