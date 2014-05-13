package model.bo.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.getNextDate;
import cococare.database.CCHibernateBo;
import java.util.Date;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibBorrowingItemBo extends CCHibernateBo {

    public synchronized Date calculateDateReturn(Date borrowedDate, Integer borrowingLimit) {
        return getNextDate(borrowedDate, borrowingLimit);
    }
}