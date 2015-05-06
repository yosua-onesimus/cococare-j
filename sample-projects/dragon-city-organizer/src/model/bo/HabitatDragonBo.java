package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.HabitatDragonDao;
import model.obj.Dragon;
//</editor-fold>

public class HabitatDragonBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HabitatDragonDao habitatDragonDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized List<Dragon> getDragonsUnlimited() {
        return habitatDragonDao.getDragonsUnlimited();
    }
//</editor-fold>
}