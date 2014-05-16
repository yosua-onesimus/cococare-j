package model.dao.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.List;
import model.mdl.lib.LibraryDao;
import model.obj.lib.LibMember;
import model.obj.lib.LibReturning;
import model.obj.lib.LibReturningItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibReturningItemDao extends LibraryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return LibReturningItem.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<LibReturningItem> getUnlimitedReturningItems(LibMember member) {
        return getListUnlimitedByField("returning.member_", member, false);
    }

    public List<LibReturningItem> getUnlimitedReturningItems(LibReturning returning) {
        return getListUnlimitedByField("returning", returning, false);
    }
//</editor-fold>
}