package cococare.framework.model.bo.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.note.NoteTrackerDao;
import cococare.framework.model.obj.note.NoteBookmark;
import cococare.framework.model.obj.note.NoteShortcut;
import cococare.framework.model.obj.note.NoteTracker;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NoteTrackerBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private NoteTrackerDao trackerDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized boolean saveOrUpdate(NoteTracker tracker, List<NoteBookmark> bookmarks, List<NoteShortcut> shortcuts) {
        return trackerDao.newTransaction().start().
                saveOrUpdate(tracker).
                saveOrUpdate(bookmarks).
                saveOrUpdate(shortcuts).
                execute();
    }
//</editor-fold>
}