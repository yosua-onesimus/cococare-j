package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.common.CCLanguage;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.bo.util.UtilConfigBo;
import static cococare.framework.model.mdl.note.NotesLanguage.*;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.note.PnlBookmarkListCtrl;
import cococare.framework.swing.controller.form.note.PnlObjectiveListCtrl;
import cococare.framework.swing.controller.form.note.PnlShortcutListCtrl;
import cococare.framework.swing.controller.form.note.PnlTrackerListCtrl;
import cococare.framework.swing.controller.form.util.*;
import cococare.framework.swing.controller.form.setup.PnlJavaxCommSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlLanguageSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlListFilesSetupCtrl;
import cococare.swing.CCSwing;
import cococare.swing.component.CCImage;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NotesMain extends CFApplCtrl {

    @Override
    protected void _loadInternalSetting() {
        super._loadInternalSetting();
        APPL_NAME = "cococare-notes";
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
        CFSwingUae utilSwingUae = new CFSwingUae();
        utilSwingUae.reg(turn(Notes), turn(Bookmark), PnlBookmarkListCtrl.class);
        utilSwingUae.reg(turn(Notes), turn(Shortcut), PnlShortcutListCtrl.class);
        utilSwingUae.reg(turn(Notes), turn(Objective), PnlObjectiveListCtrl.class);
        utilSwingUae.reg(turn(Notes), turn(Tracker), PnlTrackerListCtrl.class);
        utilSwingUae.reg("Setup", "Javax.Comm Setup", PnlJavaxCommSetupCtrl.class);
        utilSwingUae.reg("Setup", "List Files Setup", PnlListFilesSetupCtrl.class);
        utilSwingUae.reg("Setup", "Language Setup", PnlLanguageSetupCtrl.class);
        utilSwingUae.reg(turn(Utility), turn(User_Group), PnlUserGroupListCtrl.class);
        utilSwingUae.reg(turn(Utility), turn(User), PnlUserListCtrl.class);
        utilSwingUae.reg(turn(Utility), turn(Change_Password), PnlChangePasswordCtrl.class);
        utilSwingUae.reg(turn(Utility), turn(Logger_History), PnlLoggerListCtrl.class);
        utilSwingUae.reg(turn(Utility), turn(Application_Setting), PnlApplicationSettingCtrl.class);
        utilSwingUae.reg(turn(Utility), turn(Database_Setting), PnlDatabaseSettingCtrl.class);
        return utilSwingUae.compile();
    }

    @Override
    protected void _applyUserConfig() {
        UtilConfAppl confAppl = new UtilConfigBo().loadConfAppl();
        load(CCLanguage.LanguagePack.values()[CCFormat.parseInt(confAppl.getApplLanguage())]);
        CCSwing.setLookAndFeel(CCSwing.LookAndFeel.values()[CCFormat.parseInt(confAppl.getApplLookAndFeel())].getName(), CFSwingMap.getMainScreen());
        CFSwingUae utilSwingUae = new CFSwingUae();
        if (MenuPosition.LEFT_SIDE.ordinal() == CCFormat.parseInt(confAppl.getApplMenuPosition())) {
            CFSwingMap.getMenubarV().setVisible(true);
            utilSwingUae.initMenuBar(CFSwingMap.getMenubarV());
        } else {
            CFSwingMap.getMenubarH().setVisible(true);
            utilSwingUae.initMenuBar(CFSwingMap.getMenubarH());
        }
        (((CCImage) CFSwingMap.getContent())).setIcon(confAppl.getApplWallpaper());

        CFSwingMap.getCompLogo().setIcon(confAppl.getCompanyLogo());
        CFSwingMap.getCompName().setText(CCFormat.wordWrap(new String[]{confAppl.getCompanyName(), confAppl.getCompanyAddress()}));

        utilSwingUae.addMenuRoot(PnlLoginCtrl.class);
        utilSwingUae.addMenuParent(turn(Notes), null, null);
        utilSwingUae.addMenuChild(turn(Bookmark), null, PnlBookmarkListCtrl.class);
        utilSwingUae.addMenuChild(turn(Shortcut), null, PnlShortcutListCtrl.class);
        utilSwingUae.addMenuChild(turn(Objective), null, PnlObjectiveListCtrl.class);
        utilSwingUae.addMenuChild(turn(Tracker), null, PnlTrackerListCtrl.class);
        utilSwingUae.addMenuParent("Setup", null, null);
        utilSwingUae.addMenuChild("Javax.Comm Setup", null, PnlJavaxCommSetupCtrl.class);
        utilSwingUae.addMenuChild("List Files Setup", null, PnlListFilesSetupCtrl.class);
        utilSwingUae.addMenuChild("Language Setup", null, PnlLanguageSetupCtrl.class);
        utilSwingUae.changeMenuSide();
        utilSwingUae.addMenuParent(turn(Utility), null, null);
        utilSwingUae.addMenuChild(turn(User_Group), null, PnlUserGroupListCtrl.class);
        utilSwingUae.addMenuChild(turn(User), null, PnlUserListCtrl.class);
        utilSwingUae.addMenuChild(turn(Change_Password), null, PnlChangePasswordCtrl.class);
        utilSwingUae.addMenuChild(turn(Logger_History), null, PnlLoggerListCtrl.class);
        utilSwingUae.addMenuChild(turn(Application_Setting), null, PnlApplicationSettingCtrl.class);
        utilSwingUae.addMenuChild(turn(Database_Setting), null, PnlDatabaseSettingCtrl.class);
        utilSwingUae.addMenuChild(turn(Log_Out), null, PnlLoginCtrl.class);
        utilSwingUae.compileMenu();
        CFSwingMap.getMainScreen().validate();
    }

    public static void main(String[] args) {
        new NotesMain().showScreen();
    }
}