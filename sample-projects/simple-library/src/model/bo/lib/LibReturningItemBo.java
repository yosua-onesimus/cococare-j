package model.bo.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.lib.LibReturningItemDao;
import model.obj.lib.LibMember;
import model.obj.lib.LibReturningItem;
//</editor-fold>

public class LibReturningItemBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibReturningItemDao returningItemDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized List<LibReturningItem> getUnlimitedReturningItems(LibMember member) {
        return returningItemDao.getUnlimitedReturningItems(member);
    }
//</editor-fold>
}