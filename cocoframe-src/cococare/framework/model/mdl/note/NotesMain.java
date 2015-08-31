package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.HBN_WORKFLOW_MODULE_INCLUDED;
import cococare.common.CCLanguage;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.dao.wf.WfProcessDao;
import static cococare.framework.model.mdl.note.NotesLanguage.*;
import cococare.framework.model.obj.wf.WfProcess;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.controller.form.note.PnlNoteListCtrl;
import cococare.framework.swing.controller.form.note.PnlReferenceListCtrl;
import cococare.framework.swing.controller.form.setup.PnlJavaxCommSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlLanguageSetupCtrl;
import cococare.framework.swing.controller.form.wf.PnlDocumentListCtrl;
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
        HBN_WORKFLOW_MODULE_INCLUDED = true;
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
    protected boolean _initInitialData() {
        WfProcessDao processDao = new WfProcessDao();
        WfProcess process = processDao.getByCode("TEST");
        if (process == null) {
            process = new WfProcess();
            process.setCode("TEST");
            process.setName("TEST");
            processDao.saveOrUpdate(process);
        }
        process = processDao.getByCode("TEST2");
        if (process == null) {
            process = new WfProcess();
            process.setCode("TEST2");
            process.setName("TEST2");
            processDao.saveOrUpdate(process);
        }
        return super._initInitialData();
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
        uae.addMenuRoot(PnlDocumentListCtrl.class);
        uae.addMenuParent("Document", "/cococare/resource/icon-menu-child.png", PnlDocumentListCtrl.class);
        //
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