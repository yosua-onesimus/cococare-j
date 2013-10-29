package cococare.framework.swing;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.EDT_COLOR_ON_FOCUS;
import static cococare.common.CCFormat.*;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.*;
import static cococare.datafile.CCImage.getImage;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.obj.util.UtilConfAppl;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.framework.swing.controller.form.util.*;
import cococare.swing.CCSwing.LookAndFeel;
import static cococare.swing.CCSwing.centerScreen;
import static cococare.swing.CCSwing.setLookAndFeel;
import java.awt.Color;
import javax.swing.UIManager;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class CFSwingMain extends CFApplCtrl {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    protected void _loadInternalSetting() {
        setLookAndFeel(LookAndFeel.METAL.getName(), null);
        UIManager.put("PopupMenu.consumeEventOnClose", false);
        UIManager.put("Separator.background", Color.BLACK);
        UIManager.put("Separator.foreground", Color.BLACK);
        UIManager.put("nimbusBase", EDT_COLOR_ON_FOCUS.darker());
        UIManager.put("nimbusBlueGrey", EDT_COLOR_ON_FOCUS.darker());
        UIManager.put("control", EDT_COLOR_ON_FOCUS.darker());
        //
        super._loadInternalSetting();
    }

    @Override
    protected void _initScreen() {
        getApplLogo().setIcon(getClass().getResource(APPL_LOGO));
        getApplName().setText(APPL_NAME);
        getApplVer().setText(APPL_VER);
        getMainScreen().setIconImage(getImage(APPL_LOGO));
        getMainScreen().setTitle(APPL_NAME + " " + APPL_VER);
        centerScreen(getMainScreen(), true, true);
        _clearUserConfig();
        getMainScreen().setVisible(true);
    }

    @Override
    public void end() {
        System.exit(0);
    }

    @Override
    protected CFApplUae _initInitialDataUaeUtility(CFApplUae applUae) {
        applUae.reg(turn(Utility), turn(User_Group), PnlUserGroupListCtrl.class);
        applUae.reg(turn(Utility), turn(User), PnlUserListCtrl.class);
        applUae.reg(turn(Utility), turn(Change_Password), PnlChangePasswordCtrl.class);
        applUae.reg(turn(Utility), turn(Parameter), PnlParameterListCtrl.class);
        applUae.reg(turn(Utility), turn(Logger_History), PnlLoggerListCtrl.class);
        applUae.reg(turn(Utility), turn(Screen_Setting), PnlScreenSettingListCtrl.class);
        applUae.reg(turn(Utility), turn(Application_Setting), PnlApplicationSettingCtrl.class);
        applUae.reg(turn(Utility), turn(Database_Setting), PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            applUae.reg(turn(Utility), turn(Registration), PnlRegistrationCtrl.class);
        }
        return applUae;
    }

    @Override
    public boolean showDatabaseSettingScreen() {
        return new PnlDatabaseSettingCtrl().init();
    }

    @Override
    public void updateNonContent(Object object) {
        if (object instanceof UtilConfAppl) {
            UtilConfAppl confAppl = (UtilConfAppl) object;
            load(CCLanguage.LanguagePack.values()[parseInt(confAppl.getApplLanguage())]);
            setLookAndFeel(LookAndFeel.values()[parseInt(confAppl.getApplLookAndFeel())].getName(), getMainScreen());
            getContentImage().setIcon(confAppl.getApplWallpaper());
            getCompLogo().setIcon(confAppl.getCompanyLogo());
            getCompName().setText(wordWrap(new String[]{getStringOrBlank(confAppl.getCompanyName()), getStringOrBlank(confAppl.getCompanyAddress())}));
        }
    }

    @Override
    protected CFApplUae _applyUserConfigUaeUtility(CFApplUae applUae) {
        applUae.addMenuParent(turn(Utility), null, null);
        applUae.addMenuChild(turn(User_Group), null, PnlUserGroupListCtrl.class);
        applUae.addMenuChild(turn(User), null, PnlUserListCtrl.class);
        applUae.addMenuChild(turn(Change_Password), null, PnlChangePasswordCtrl.class);
        applUae.addMenuSeparator();
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            applUae.addMenuChild(turn(Parameter), null, PnlParameterListCtrl.class);
        }
        applUae.addMenuChild(turn(Logger_History), null, PnlLoggerListCtrl.class);
        applUae.addMenuSeparator();
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            applUae.addMenuChild(turn(Screen_Setting), null, PnlScreenSettingListCtrl.class);
        }
        applUae.addMenuChild(turn(Application_Setting), null, PnlApplicationSettingCtrl.class);
        applUae.addMenuChild(turn(Database_Setting), null, PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            applUae.addMenuSeparator();
            applUae.addMenuChild(turn(Registration), null, PnlRegistrationCtrl.class);
        }
        applUae.addMenuParent(turn(Log_Out), null, PnlLoginCtrl.class);
        return applUae;
    }

    @Override
    protected void _clearUserConfig() {
        getMenubarH().setVisible(false);
        getMenubarV().setVisible(false);
        getMainScreen().validate();
    }

    @Override
    protected boolean _showLoginScreen() {
        return new PnlLoginCtrl().init();
    }
//</editor-fold>
}