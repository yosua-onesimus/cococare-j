package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.DragonCityOrganizerDao;
import model.obj.Habitat;
//</editor-fold>

public class HabitatDao extends DragonCityOrganizerDao {

    @Override
    protected Class getEntity() {
        return Habitat.class;
    }
}