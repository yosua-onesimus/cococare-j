package model.dao.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.lib.LibraryDao;
import model.obj.lib.LibBorrowing;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibBorrowingDao extends LibraryDao {

    @Override
    protected Class getEntity() {
        return LibBorrowing.class;
    }
}