package model.bo.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isEmpty;
import cococare.database.CCHibernateBo;
import cococare.database.CCHibernateDao.Transaction;
import java.util.List;
import model.dao.lib.LibBorrowingItemDao;
import model.dao.lib.LibReturningItemDao;
import model.obj.lib.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibReturningBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibBorrowingItemDao borrowingItemDao;
    private LibReturningItemDao returningItemDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized List<LibMember> getUnlimitedBorrowingMembers() {
        return borrowingItemDao.getUnlimitedBorrowingMembers();
    }

    public synchronized boolean saveOrUpdate(LibReturning returning, List<LibReturningItem> returningItems) {
        Transaction transaction = returningItemDao.newTransaction();
        //if returning is already saved in the database, returningItems must be empty
        if (isEmpty(returningItems)) {
            returningItems = returningItemDao.getUnlimitedReturningItems(returning);
        }
        for (LibReturningItem returningItem : returningItems) {
            LibBorrowingItem borrowingItem = returningItem.getBorrowingItem();
            borrowingItem.setReturned(true);
            transaction.saveOrUpdate(borrowingItem);
            LibBook book = borrowingItem.getBook();
            book.setBorrowed(false);
            transaction.saveOrUpdate(book);
        }
        return transaction.saveOrUpdate(returning).
                saveOrUpdate(returningItems).
                execute();
    }
//</editor-fold>
}