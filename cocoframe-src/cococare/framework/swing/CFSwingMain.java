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
import cococare.framework.model.obj.util.UtilConfAppl.MenuPosition;
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
    protected CFApplUae _initInitialUaeBegin() {
        return new CFSwingUae();
    }

    @Override
    protected boolean _initInitialUaeEnd(CFApplUae uae) {
        uae.reg(Utility, User_Group, PnlUserGroupListCtrl.class);
        uae.reg(Utility, User, PnlUserListCtrl.class);
        uae.reg(Utility, Change_Password, PnlChangePasswordCtrl.class);
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            uae.reg(Utility, Parameter, PnlParameterListCtrl.class);
            uae.reg(Utility, Export_Import, PnlExportImportCtrl.class);
        }
        if (!HIBERNATE.getAuditableClasses().isEmpty()) {
            uae.reg(Utility, Audit_Trail, PnlAuditTrailListCtrl.class);
        }
        uae.reg(Utility, Logger_History, PnlLoggerListCtrl.class);
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            uae.reg(Utility, Screen_Setting, PnlScreenSettingListCtrl.class);
        }
        uae.reg(Utility, Application_Setting, PnlApplicationSettingCtrl.class);
        uae.reg(Utility, Database_Setting, PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            uae.reg(Utility, Registration, PnlRegistrationCtrl.class);
        }
        return uae.compile();
    }

    @Override
    public boolean showDatabaseSettingScreen() {
        return new PnlDatabaseSettingCtrl().init();
    }

    @Override
    public void updateNonContent(Object object) {
        if (object instanceof UtilConfAppl) {
            load(CCLanguage.LanguagePack.values()[parseInt(confAppl.getApplLanguage())]);
            setLookAndFeel(LookAndFeel.values()[parseInt(confAppl.getApplLookAndFeel())].getName(), getMainScreen());
            getContentImage().setIcon(confAppl.getApplWallpaper());
            getCompLogo().setIcon(confAppl.getCompanyLogo());
            getCompName().setText(wordWrap(new String[]{getStringOrBlank(confAppl.getCompanyName()), getStringOrBlank(confAppl.getCompanyAddress())}));
        }
    }

    @Override
    protected CFApplUae _applyUserConfigUaeBegin() {
        CFSwingUae uae = new CFSwingUae();
        uae.initMenuBar(MenuPosition.LEFT_SIDE.ordinal() == confAppl.getApplMenuPosition().intValue() ? getMenubarV() : getMenubarH());
        uae.addMenuRoot(PnlLoginCtrl.class);
        return uae;
    }

    @Override
    protected void _applyUserConfigUaeEnd(CFApplUae uae) {
        uae.changeMenuSide();
        uae.addMenuParent(Utility, null, null);
        uae.addMenuChild(User_Group, null, PnlUserGroupListCtrl.class);
        uae.addMenuChild(User, null, PnlUserListCtrl.class);
        uae.addMenuChild(Change_Password, null, PnlChangePasswordCtrl.class);
        uae.addMenuSeparator();
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            uae.addMenuChild(Parameter, null, PnlParameterListCtrl.class);
            uae.addMenuChild(Export_Import, null, PnlExportImportCtrl.class);
        }
        if (!HIBERNATE.getAuditableClasses().isEmpty()) {
            uae.addMenuChild(Audit_Trail, null, PnlAuditTrailListCtrl.class);
        }
        uae.addMenuChild(Logger_History, null, PnlLoggerListCtrl.class);
        uae.addMenuSeparator();
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            uae.addMenuChild(Screen_Setting, null, PnlScreenSettingListCtrl.class);
        }
        uae.addMenuChild(Application_Setting, null, PnlApplicationSettingCtrl.class);
        uae.addMenuChild(Database_Setting, null, PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            uae.addMenuSeparator();
            uae.addMenuChild(Registration, null, PnlRegistrationCtrl.class);
        }
        uae.addMenuParent(Log_Out, null, PnlLoginCtrl.class);
        uae.compileMenu();
        getMainScreen().validate();
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