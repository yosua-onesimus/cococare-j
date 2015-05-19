package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
//</editor-fold>

public class DragonBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized double countRevenuesTotal(double revenues, double revenuesPercent) {
        return Math.ceil(revenues * (100 + revenuesPercent) / 100);
    }
//</editor-fold>
}