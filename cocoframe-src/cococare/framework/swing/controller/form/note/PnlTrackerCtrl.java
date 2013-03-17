package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.bo.note.NoteTrackerBo;
import cococare.framework.model.obj.note.NoteTracker;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.getJPanel;
import static cococare.swing.CCSwing.showPanel;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlTrackerCtrl extends CFSwingCtrl {

    private NoteTrackerBo trackerBo;

    @Override
    protected Class _getEntity() {
        return NoteTracker.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        parameter.put("tracker", objEntity);
        parameter.put("tracker_newEntity", newEntity);
        if (newEntity) {
            parameter.put("bookmarks", new ArrayList());
            parameter.put("shortcuts", new ArrayList());
        }
        PnlBookmarkListCtrl bookmarkListCtrl = new PnlBookmarkListCtrl();
        bookmarkListCtrl.with(parameter).init();
        showPanel(getJPanel(getContainer(), "pnlBookmark"), bookmarkListCtrl.getContainer());
        PnlShortcutListCtrl shortcutListCtrl = new PnlShortcutListCtrl();
        shortcutListCtrl.with(parameter).init();
        showPanel(getJPanel(getContainer(), "pnlShortcut"), shortcutListCtrl.getContainer());
    }

    @Override
    protected boolean _doSaveEntity() {
        if (newEntity) {
            return trackerBo.saveOrUpdate((NoteTracker) objEntity,
                    (List) parameter.get("bookmarks"),
                    (List) parameter.get("shortcuts"));
        } else {
            return super._doSaveEntity();
        }
    }
}