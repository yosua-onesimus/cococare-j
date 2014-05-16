package model.bo.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isEmpty;
import cococare.database.CCHibernateBo;
import cococare.database.CCHibernateDao.Transaction;
import java.util.List;
import model.dao.lib.LibBorrowingItemDao;
import model.obj.lib.LibBook;
import model.obj.lib.LibBorrowing;
import model.obj.lib.LibBorrowingItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibBorrowingBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibBorrowingItemDao borrowingItemDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized boolean saveOrUpdate(LibBorrowing borrowing, List<LibBorrowingItem> borrowingItems) {
        Transaction transaction = borrowingItemDao.newTransaction();
        //if borrowing is already saved in the database, borrowingItems must be empty
        if (isEmpty(borrowingItems)) {
            borrowingItems = borrowingItemDao.getUnlimitedBorrowingItems(borrowing);
        }
        for (LibBorrowingItem borrowingItem : borrowingItems) {
            LibBook book = borrowingItem.getBook();
            if (!borrowingItem.isReturned()) {
                book.setBorrowed(true);
            }
            transaction.saveOrUpdate(book);
        }
        return transaction.saveOrUpdate(borrowing).
                saveOrUpdate(borrowingItems).
                execute();
    }
//</editor-fold>
}