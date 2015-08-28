package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import cococare.database.CCHibernateBo;
//</editor-fold>

public class DragonBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized int countRevenuesTotal(double revenues, double revenuesPercent) {
        return parseInt(Math.ceil(revenues * (100 + revenuesPercent) / 100));
    }
//</editor-fold>
}