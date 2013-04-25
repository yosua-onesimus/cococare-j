package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.common.CCLanguage;
import cococare.common.CCLanguage.LanguagePack;
import cococare.datafile.CCFile;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.common.CFApplCtrl.MenuPosition;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.*;
import cococare.swing.CCSwing;
import controller.form.fb.PnlActionListCtrl;
import controller.form.fb.PnlClassListCtrl;
import java.io.File;
//</editor-fold>

public class FableMain extends CFApplCtrl {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "fablengine";
        APPL_NAME = "fablengine";
        //CCLoginInfo.INSTANCE = null;//without login
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        super._loadExternalSetting();
        File file = CCFile.getFileSystConfFile(S_APPL_CONF);
        if (file.exists()) {
            updateNonContent((UtilConfAppl) CCFile.readObject(file));
        }
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        FableModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    public boolean initInitialData() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg("FB", "Class", PnlClassListCtrl.class);
        swingUae.reg("FB", "Action", PnlActionListCtrl.class);
        swingUae.reg(CCLanguage.Utility, CCLanguage.User_Group, PnlUserGroupListCtrl.class);
        swingUae.reg(CCLanguage.Utility, CCLanguage.User, PnlUserListCtrl.class);
        swingUae.reg(CCLanguage.Utility, CCLanguage.Change_Password, PnlChangePasswordCtrl.class);
        swingUae.reg(CCLanguage.Utility, CCLanguage.Logger_History, PnlLoggerListCtrl.class);
        swingUae.reg(CCLanguage.Utility, CCLanguage.Application_Setting, PnlApplicationSettingCtrl.class);
        swingUae.reg(CCLanguage.Utility, CCLanguage.Database_Setting, PnlDatabaseSettingCtrl.class);
        return swingUae.compile();
    }

    @Override
    public void updateNonContent(Object object) {
        UtilConfAppl confAppl = (UtilConfAppl) object;
        CCLanguage.load(LanguagePack.values()[CCFormat.parseInt(confAppl.getApplLanguage())]);
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
        swingUae.addMenuParent("FaBle Engine", null, null);
        swingUae.addMenuChild("Class", null, PnlClassListCtrl.class);
        swingUae.addMenuChild("Action", null, PnlActionListCtrl.class);
        swingUae.changeMenuSide();
        swingUae.addMenuParent(CCLanguage.Utility, null, null);
        swingUae.addMenuChild(CCLanguage.User_Group, null, PnlUserGroupListCtrl.class);
        swingUae.addMenuChild(CCLanguage.User, null, PnlUserListCtrl.class);
        swingUae.addMenuChild(CCLanguage.Change_Password, null, PnlChangePasswordCtrl.class);
        swingUae.addMenuChild(CCLanguage.Logger_History, null, PnlLoggerListCtrl.class);
        swingUae.addMenuChild(CCLanguage.Application_Setting, null, PnlApplicationSettingCtrl.class);
        swingUae.addMenuChild(CCLanguage.Database_Setting, null, PnlDatabaseSettingCtrl.class);
        swingUae.addMenuChild(CCLanguage.Log_Out, null, PnlLoginCtrl.class);
        swingUae.compileMenu();

        CFSwingMap.getMainScreen().validate();
    }

    @Override
    public void showScreen() {
        super.showScreen();//with login
        //_applyUserConfig();//without login
    }

    public static void main(String[] args) {
        new FableMain().showScreen();
    }
}