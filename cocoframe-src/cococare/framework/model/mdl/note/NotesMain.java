package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.framework.common.CFApplUae;
import static cococare.framework.model.mdl.note.NotesLanguage.*;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.controller.form.note.PnlNoteListCtrl;
import cococare.framework.swing.controller.form.note.PnlReferenceListCtrl;
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
        CCLanguage.init(false, NotesLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        NotesModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(Note, Reference, PnlReferenceListCtrl.class);
        uae.reg(Note, Note, PnlNoteListCtrl.class);
        uae.reg("Setup", "Javax.Comm Setup", PnlJavaxCommSetupCtrl.class);
        uae.reg("Setup", "Language Setup", PnlLanguageSetupCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent(Notes, "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild(Reference, "/cococare/resource/icon-menu-child.png", PnlReferenceListCtrl.class);
        uae.addMenuSeparator();
        uae.addMenuChild(Note, "/cococare/resource/icon-menu-child.png", PnlNoteListCtrl.class);
        uae.addMenuParent("Setup", "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild("Javax.Comm Setup", "/cococare/resource/icon-menu-child.png", PnlJavaxCommSetupCtrl.class);
        uae.addMenuChild("Language Setup", "/cococare/resource/icon-menu-child.png", PnlLanguageSetupCtrl.class);
    }

    public static void main(String[] args) {
        new NotesMain().showScreen();
    }
}