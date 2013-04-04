package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.datafile.CCFile;
import cococare.framework.common.CFApplCtrl;
import static cococare.framework.common.CFApplCtrl.APPL_CODE;
import cococare.framework.model.bo.util.UtilConfigBo;
import static cococare.framework.model.mdl.note.NotesLanguage.*;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.note.PnlBookmarkListCtrl;
import cococare.framework.swing.controller.form.note.PnlObjectiveListCtrl;
import cococare.framework.swing.controller.form.note.PnlShortcutListCtrl;
import cococare.framework.swing.controller.form.note.PnlTrackerListCtrl;
import cococare.framework.swing.controller.form.setup.PnlJavaxCommSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlLanguageSetupCtrl;
import cococare.framework.swing.controller.form.setup.PnlListFilesSetupCtrl;
import cococare.framework.swing.controller.form.util.*;
import cococare.swing.CCSwing;
import java.io.File;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NotesMain extends CFApplCtrl {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "cccr-nts";
        APPL_NAME = "cococare-notes";
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        init(false, NotesLanguage.class);
        super._loadExternalSetting();
        File file = CCFile.getFileSystConfFile(S_APPL_CONF);
        if (file.exists()) {
            updateNonContent((UtilConfAppl) CCFile.readObject(file));
        }
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
        swingUae.reg(turn(Utility), turn(User_Group), PnlUserGroupListCtrl.class);
        swingUae.reg(turn(Utility), turn(User), PnlUserListCtrl.class);
        swingUae.reg(turn(Utility), turn(Change_Password), PnlChangePasswordCtrl.class);
        swingUae.reg(turn(Utility), turn(Logger_History), PnlLoggerListCtrl.class);
        swingUae.reg(turn(Utility), turn(Application_Setting), PnlApplicationSettingCtrl.class);
        swingUae.reg(turn(Utility), turn(Database_Setting), PnlDatabaseSettingCtrl.class);
        return swingUae.compile();
    }

    @Override
    public void updateNonContent(Object object) {
        UtilConfAppl confAppl = (UtilConfAppl) object;
        load(LanguagePack.values()[CCFormat.parseInt(confAppl.getApplLanguage())]);
        CCSwing.setLookAndFeel(CCSwing.LookAndFeel.values()[CCFormat.parseInt(confAppl.getApplLookAndFeel())].getName(), CFSwingMap.getMainScreen());
        CFSwingMap.getContentImage().setIcon(confAppl.getApplWallpaper());
        CFSwingMap.getCompLogo().setIcon(confAppl.getCompanyLogo());
        CFSwingMap.getCompName().setText(CCFormat.wordWrap(new String[]{CCFormat.getStringOrBlank(confAppl.getCompanyName()), CCFormat.getStringOrBlank(confAppl.getCompanyAddress())}));
    }

    @Override
    protected void _applyUserConfig() {
        UtilConfAppl confAppl = new UtilConfigBo().loadConfAppl();
        updateNonContent(confAppl);

        CFSwingUae swingUae = new CFSwingUae();
        if (MenuPosition.LEFT_SIDE.ordinal() == CCFormat.parseInt(confAppl.getApplMenuPosition())) {
            CFSwingMap.getMenubarV().setVisible(true);
            swingUae.initMenuBar(CFSwingMap.getMenubarV());
        } else {
            CFSwingMap.getMenubarH().setVisible(true);
            swingUae.initMenuBar(CFSwingMap.getMenubarH());
        }
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
        swingUae.addMenuParent(turn(Utility), null, null);
        swingUae.addMenuChild(turn(User_Group), null, PnlUserGroupListCtrl.class);
        swingUae.addMenuChild(turn(User), null, PnlUserListCtrl.class);
        swingUae.addMenuChild(turn(Change_Password), null, PnlChangePasswordCtrl.class);
        swingUae.addMenuChild(turn(Logger_History), null, PnlLoggerListCtrl.class);
        swingUae.addMenuChild(turn(Application_Setting), null, PnlApplicationSettingCtrl.class);
        swingUae.addMenuChild(turn(Database_Setting), null, PnlDatabaseSettingCtrl.class);
        swingUae.addMenuChild(turn(Log_Out), null, PnlLoginCtrl.class);
        swingUae.compileMenu();

        CFSwingMap.getMainScreen().validate();
    }

    public static void main(String[] args) {
        new NotesMain().showScreen();
    }
}