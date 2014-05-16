package model.bo.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.getNextDate;
import cococare.database.CCHibernateBo;
import java.util.Date;
import java.util.List;
import model.dao.lib.LibBorrowingItemDao;
import model.obj.lib.LibBook;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibBorrowingItemBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibBorrowingItemDao borrowingItemDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized List<LibBook> getUnlimitedBorrowedBooks() {
        return borrowingItemDao.getUnlimitedBorrowedBooks();
    }

    public synchronized Date calculateDateReturn(Date borrowedDate, Integer borrowingLimit) {
        return getNextDate(borrowedDate, borrowingLimit);
    }
//</editor-fold>
}