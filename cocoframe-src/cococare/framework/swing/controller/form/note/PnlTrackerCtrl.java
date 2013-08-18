package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.note.NoteTracker;
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlTrackerCtrl extends CFSwingCtrl {

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
        _addChildScreen("tracker", new PnlBookmarkListCtrl(), "pnlBookmark");
        _addChildScreen("tracker", new PnlShortcutListCtrl(), "pnlShortcut");
    }
}