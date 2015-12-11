package cococare.framework.swing;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.EDT_COLOR_ON_FOCUS;
import static cococare.common.CCFormat.*;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.*;
import static cococare.database.CCLoginInfo.INSTANCE_getLogUser;
import static cococare.datafile.CCImage.readImage;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.model.obj.util.UtilConfAppl.MenuPosition;
import cococare.framework.model.obj.util.UtilConfServ;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.framework.swing.controller.form.util.*;
import static cococare.swing.CCSwing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
//</editor-fold>

/**
 * CFSwingMain is an abstract class which functions as an application controller, in charge of
 * controlling the flow of applications in general.
 *
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class CFSwingMain extends CFApplCtrl {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void end() {
        System.exit(0);
    }

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
        getMainScreen().setIconImage(readImage(APPL_LOGO));
        getMainScreen().setTitle(APPL_NAME + " " + APPL_VER);
        _clearUserConfig();
        centerScreen(getMainScreen(), true, true);
        getMainScreen().setVisible(true);
        //add listener to service components
        addListener(getFileTransfer(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PnlFileTransferCtrl().init();
            }
        });
        addListener(getSendMail(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("SEND-MAIL");
            }
        });
        addListener(getBugReport(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("BUG-REPORT");
            }
        });
    }

    @Override
    protected void _initDatabaseProfile() {
        _initScreen();
        getCCProgressbar().start();
        super._initDatabaseProfile();
        getCCProgressbar().complete();
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
        uae.reg(Utility, Logger_History, PnlLoggerListCtrl.class);
        if (!HIBERNATE.getAuditableClasses().isEmpty()) {
            uae.reg(Utility, Audit_Trail, PnlAuditTrailListCtrl.class);
        }
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            uae.reg(Utility, Screen_Setting, PnlScreenSettingListCtrl.class);
        }
        uae.reg(Utility, Application_Setting, PnlApplicationSettingListCtrl.class);
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
            confAppl = (UtilConfAppl) object;
            load(CCLanguage.LanguagePack.values()[parseInt(confAppl.getApplLanguage())]);
            setLookAndFeel(LookAndFeel.values()[parseInt(confAppl.getApplLookAndFeel())].getName(), getMainScreen());
            getContentImage().setIcon(confAppl.getApplWallpaper());
            getCompLogo().setIcon(confAppl.getCompanyLogo());
            getCompName().setText(wordWrap(getStringOrBlank(confAppl.getCompanyName()), getStringOrBlank(confAppl.getCompanyAddress())));
        } else if (object instanceof UtilConfServ) {
            confServ = (UtilConfServ) object;
            getFileTransfer().setVisible(confServ.getFileTransferEnable());
            getSendMail().setVisible(confServ.getMailSendMailEnable());
            getBugReport().setVisible(confServ.getMailBugReportEnable());
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
        uae.addMenuParent(Utility, "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild(User_Group, "/cococare/resource/icon-menu-user-group.png", PnlUserGroupListCtrl.class);
        uae.addMenuChild(User, "/cococare/resource/icon-menu-user.png", PnlUserListCtrl.class);
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            uae.addMenuSeparator();
            uae.addMenuChild(Parameter, "/cococare/resource/icon-menu-parameter.png", PnlParameterListCtrl.class);
            uae.addMenuChild(Export_Import, "/cococare/resource/icon-menu-export-import.png", PnlExportImportCtrl.class);
        }
        uae.addMenuSeparator();
        uae.addMenuChild(Logger_History, "/cococare/resource/icon-menu-logger-history.png", PnlLoggerListCtrl.class);
        if (!HIBERNATE.getAuditableClasses().isEmpty()) {
            uae.addMenuChild(Audit_Trail, "/cococare/resource/icon-menu-audit-trail.png", PnlAuditTrailListCtrl.class);
        }
        uae.addMenuSeparator();
        if (!HIBERNATE.getCustomizableClasses().isEmpty()) {
            uae.addMenuChild(Screen_Setting, "/cococare/resource/icon-menu-screen-setting.png", PnlScreenSettingListCtrl.class);
        }
        uae.addMenuChild(Application_Setting, "/cococare/resource/icon-menu-application-setting.png", PnlApplicationSettingListCtrl.class);
        uae.addMenuChild(Database_Setting, "/cococare/resource/icon-menu-database-setting.png", PnlDatabaseSettingCtrl.class);
        if (LICENSE_ACTIVE) {
            uae.addMenuSeparator();
            uae.addMenuChild(Registration, "/cococare/resource/icon-menu-registration.png", PnlRegistrationCtrl.class);
        }
        uae.addMenuParent(INSTANCE_getLogUser(), "/cococare/resource/icon-menu-user.png", null);
        uae.addMenuChild(Change_Password, "/cococare/resource/icon-menu-change-password.png", PnlChangePasswordCtrl.class);
        uae.addMenuChild(Log_Out, "/cococare/resource/icon-menu-log-out.png", PnlLoginCtrl.class);
        uae.compileMenu();
        getMainScreen().validate();
    }

    @Override
    protected void _clearUserConfig() {
        setVisible(false, getMenubarH(), getMenubarV());
        getMainScreen().validate();
        //
        setVisible(false, getFileTransfer(), getSendMail(), getBugReport());
    }

    @Override
    protected boolean _showLoginScreen() {
        return new PnlLoginCtrl().init();
    }
//</editor-fold>
}