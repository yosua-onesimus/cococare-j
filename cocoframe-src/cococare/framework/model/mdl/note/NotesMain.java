package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.framework.model.mdl.note.NotesLanguage.*;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.note.PnlBookmarkListCtrl;
import cococare.framework.swing.controller.form.note.PnlObjectiveListCtrl;
import cococare.framework.swing.controller.form.note.PnlShortcutListCtrl;
import cococare.framework.swing.controller.form.note.PnlTrackerListCtrl;
import cococare.framework.swing.controller.form.setup.PnlJavaxCommSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlLanguageSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlListFilesSetupCtrl;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
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
    public boolean initInitialData() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg(turn(Notes), turn(Bookmark), PnlBookmarkListCtrl.class);
        swingUae.reg(turn(Notes), turn(Shortcut), PnlShortcutListCtrl.class);
        swingUae.reg(turn(Notes), turn(Objective), PnlObjectiveListCtrl.class);
        swingUae.reg(turn(Notes), turn(Tracker), PnlTrackerListCtrl.class);
        swingUae.reg("Setup", "Javax.Comm Setup", PnlJavaxCommSetupCtrl.class);
        swingUae.reg("Setup", "List Files Setup", PnlListFilesSetupCtrl.class);
        swingUae.reg("Setup", "Language Setup", PnlLanguageSetupCtrl.class);
        return _initInitialDataUaeUtility(swingUae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        super._applyUserConfig();
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(MenuPosition.LEFT_SIDE.equals(MENU_POST) ? CFSwingMap.getMenubarV() : CFSwingMap.getMenubarH());
        swingUae.addMenuRoot(PnlLoginCtrl.class);
        swingUae.addMenuParent(turn(Notes), null, null);
        swingUae.addMenuChild(turn(Bookmark), null, PnlBookmarkListCtrl.class);
        swingUae.addMenuChild(turn(Shortcut), null, PnlShortcutListCtrl.class);
        swingUae.addMenuChild(turn(Objective), null, PnlObjectiveListCtrl.class);
        swingUae.addMenuChild(turn(Tracker), null, PnlTrackerListCtrl.class);
        swingUae.addMenuParent("Setup", null, null);
        swingUae.addMenuChild("Javax.Comm Setup", null, PnlJavaxCommSetupCtrl.class);
        swingUae.addMenuChild("List Files Setup", null, PnlListFilesSetupCtrl.class);
        swingUae.addMenuChild("Language Setup", null, PnlLanguageSetupCtrl.class);
        swingUae.changeMenuSide();
        _applyUserConfigUaeUtility(swingUae).compileMenu();
        CFSwingMap.getMainScreen().validate();
    }

    public static void main(String[] args) {
        new NotesMain().showScreen();
    }
}