package model.dao.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.List;
import model.mdl.lib.LibraryDao;
import model.obj.lib.LibBook;
import model.obj.lib.LibBorrowing;
import model.obj.lib.LibBorrowingItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibBorrowingItemDao extends LibraryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return LibBorrowingItem.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<LibBook> getUnlimitedBorrowedBooks() {
        hql.start().
                alias("borrowingItem").
                select("borrowingItem.book").
                where("borrowingItem.book.borrowed = TRUE");
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public List<LibBorrowingItem> getUnlimitedBorrowingItem(LibBorrowing borrowing) {
        return getListUnlimitedByField("borrowing", borrowing, false);
    }
//</editor-fold>
}