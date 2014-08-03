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
 * CFSwingMain is an abstract class which functions as an application
 * controller, in charge of controlling the flow of applications in general.
 *
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
        applUae.reg(Utility, User_Group, PnlUserGroupListCtrl.class);
        applUae.reg(Utility, User, PnlUserListCtrl.class);
        applUae.reg(Utility, Change_Password, PnlChangePasswordCtrl.class);
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            applUae.reg(Utility, Parameter, PnlParameterListCtrl.class);
        }
        if (!HIBERNATE.getAuditableClasses().isEmpty()) {
            applUae.reg(Utility, Audit_Trail, PnlAuditTrailListCtrl.class);
        }
        applUae.reg(Utility, Logger_History, PnlLoggerListCtrl.class);
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            applUae.reg(Utility, Screen_Setting, PnlScreenSettingListCtrl.class);
        }
        applUae.reg(Utility, Application_Setting, PnlApplicationSettingCtrl.class);
        applUae.reg(Utility, Database_Setting, PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            applUae.reg(Utility, Registration, PnlRegistrationCtrl.class);
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
        applUae.addMenuParent(Utility, null, null);
        applUae.addMenuChild(User_Group, null, PnlUserGroupListCtrl.class);
        applUae.addMenuChild(User, null, PnlUserListCtrl.class);
        applUae.addMenuChild(Change_Password, null, PnlChangePasswordCtrl.class);
        applUae.addMenuSeparator();
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            applUae.addMenuChild(Parameter, null, PnlParameterListCtrl.class);
        }
        if (!HIBERNATE.getAuditableClasses().isEmpty()) {
            applUae.addMenuChild(Audit_Trail, null, PnlAuditTrailListCtrl.class);
        }
        applUae.addMenuChild(Logger_History, null, PnlLoggerListCtrl.class);
        applUae.addMenuSeparator();
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            applUae.addMenuChild(Screen_Setting, null, PnlScreenSettingListCtrl.class);
        }
        applUae.addMenuChild(Application_Setting, null, PnlApplicationSettingCtrl.class);
        applUae.addMenuChild(Database_Setting, null, PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            applUae.addMenuSeparator();
            applUae.addMenuChild(Registration, null, PnlRegistrationCtrl.class);
        }
        applUae.addMenuParent(Log_Out, null, PnlLoginCtrl.class);
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