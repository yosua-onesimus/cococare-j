package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.common.CFApplUae;
import static cococare.framework.model.mdl.note.NotesLanguage.*;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.controller.form.note.PnlBookmarkListCtrl;
import cococare.framework.swing.controller.form.note.PnlObjectiveListCtrl;
import cococare.framework.swing.controller.form.note.PnlShortcutListCtrl;
import cococare.framework.swing.controller.form.note.PnlTrackerListCtrl;
import cococare.framework.swing.controller.form.setup.PnlJavaxCommSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlLanguageSetupCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NotesMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "cccr-nts";
        APPL_NAME = "Coco Notes";
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        init(false, NotesLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        NotesModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(Note, Bookmark, PnlBookmarkListCtrl.class);
        uae.reg(Note, Shortcut, PnlShortcutListCtrl.class);
        uae.reg(Note, Objective, PnlObjectiveListCtrl.class);
        uae.reg(Note, Tracker, PnlTrackerListCtrl.class);
        uae.reg("Setup", "Javax.Comm Setup", PnlJavaxCommSetupCtrl.class);
        uae.reg("Setup", "Language Setup", PnlLanguageSetupCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent(Notes, null, null);
        uae.addMenuChild(Bookmark, null, PnlBookmarkListCtrl.class);
        uae.addMenuChild(Shortcut, null, PnlShortcutListCtrl.class);
        uae.addMenuChild(Objective, null, PnlObjectiveListCtrl.class);
        uae.addMenuChild(Tracker, null, PnlTrackerListCtrl.class);
        uae.addMenuParent("Setup", null, null);
        uae.addMenuChild("Javax.Comm Setup", null, PnlJavaxCommSetupCtrl.class);
        uae.addMenuChild("Language Setup", null, PnlLanguageSetupCtrl.class);
    }

    public static void main(String[] args) {
        new NotesMain().showScreen();
    }
}