package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.EDT_COLOR_ON_FOCUS;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.initDefaultHandler;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import cococare.database.CCLoginInfo;
import static cococare.database.CCLoginInfo.INSTANCE_hasLogged;
import static cococare.datafile.CCFile.getFileSystConfPath;
import cococare.framework.model.bo.util.UtilUserBo;
import cococare.framework.model.mdl.util.UtilityModule;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.framework.swing.controller.form.util.PnlDatabaseSettingCtrl;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import cococare.swing.CCSwing.LookAndFeel;
import static cococare.swing.CCSwing.centerScreen;
import static cococare.swing.CCSwing.setLookAndFeel;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
// </editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class CFApplCtrl {

    public static CFApplCtrl INSTANCE;

// <editor-fold defaultstate="collapsed" desc=" private enum ">
    protected enum PlatformMode {

        DESKTOP, WEB;
    }

    protected enum DatabaseMode {

        SINGLE, MULTIPLE;
    }
// </editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public enum ">
    public enum MenuPosition {

        LEFT_SIDE("Left Side"), TOP_SIDE("Top Side");
        private String string;

        private MenuPosition(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    protected PlatformMode PLAT_MODE = PlatformMode.DESKTOP;
    protected DatabaseMode DTBS_MODE = DatabaseMode.SINGLE;
    //
    protected String APPL_ID = "appl.id";
    public static String APPL_CODE = "appl.code";
    protected String APPL_LOGO = "/cococare/resource/icon-cococare.jpg";
    protected String APPL_NAME = "appl.name";
    protected String APPL_VER = "1.0.120317";
    //
    protected String S_APPL_CONF = "appl.conf";
    protected String S_APPL_LCNS = "appl.lcns";
    protected String S_DTBS_CONF = "dtbs.conf";
    //
    protected File FILE_APPL_CONF = new File(getFileSystConfPath(), S_APPL_CONF);
    protected File FILE_APPL_LCNS = new File(getFileSystConfPath(), S_APPL_LCNS);
    protected File FILE_DTBS_CONF = new File(getFileSystConfPath(), S_DTBS_CONF);
    //
    protected CCHibernate HIBERNATE;
    //
    protected boolean databaseConnected = true;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CFApplCtrl ">
    public CFApplCtrl() {
        __init();
    }

    private void __init() {
        if (isNull(INSTANCE)) {
            INSTANCE = this;
            _loadInternalSetting();
            _loadExternalSetting();
            _initScreen();
            _initDatabaseProfile();
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    protected void _loadInternalSetting() {
        initDefaultHandler();
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            setLookAndFeel(LookAndFeel.METAL.getName(), null);
            UIManager.put("PopupMenu.consumeEventOnClose", false);
            UIManager.put("nimbusBase", EDT_COLOR_ON_FOCUS.darker());
            UIManager.put("nimbusBlueGrey", EDT_COLOR_ON_FOCUS.darker());
            UIManager.put("control", EDT_COLOR_ON_FOCUS.darker());
        } else if (PlatformMode.WEB.equals(PLAT_MODE)) {
            FILE_APPL_CONF = new File(getFileSystConfPath(), S_APPL_CONF);
            FILE_APPL_LCNS = new File(getFileSystConfPath(), S_APPL_LCNS);
            FILE_DTBS_CONF = new File(getFileSystConfPath(), S_DTBS_CONF);
        }
    }

    protected void _loadExternalSetting() {
        load(CCLanguage.LanguagePack.EN);
    }

    protected void _initScreen() {
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            getApplLogo().setIcon(getClass().getResource(APPL_LOGO));
            getApplName().setText(APPL_NAME);
            getApplVer().setText(APPL_VER);
            getMainScreen().setIconImage(new ImageIcon(getClass().getResource(APPL_LOGO)).getImage());
            getMainScreen().setTitle(APPL_NAME + " " + APPL_VER);
            centerScreen(getMainScreen(), true, true);
            _clearUserConfig();
            getMainScreen().setVisible(true);
        } else if (PlatformMode.WEB.equals(PLAT_MODE)) {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        }
    }

    public void end() {
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            System.exit(0);
        } else if (PlatformMode.WEB.equals(PLAT_MODE)) {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        }
    }

    protected void _initDatabaseProfile() {
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            getCCProgressbar().start();
        }
        HIBERNATE = new CCHibernate();
        HIBERNATE.loadDatabaseConfig(FILE_DTBS_CONF);
        if (PlatformMode.WEB.equals(PLAT_MODE)) {
            HIBERNATE.setProperty_C3P0();
        }
        _initDatabaseEntity();
        _initDatabaseFilter();
        if (DatabaseMode.SINGLE.equals(DTBS_MODE)) {
            if (!(databaseConnected = openDatabaseConnection(HIBERNATE.getDatabaseConfig(), false))) {
                showDatabaseSettingScreen();
            }
        } else if (DatabaseMode.MULTIPLE.equals(DTBS_MODE)) {
            HIBERNATE.buildSessionFactories();
        }
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            getCCProgressbar().complete();
        }
    }

    protected void _initDatabaseEntity() {
        UtilityModule.INSTANCE.init(HIBERNATE);
    }

    public boolean openDatabaseConnection(CCDatabaseConfig databaseConfig, boolean autoCreateDatabase) {
        if (HIBERNATE.isDatabaseConfigValid(databaseConfig, autoCreateDatabase)) {
            HIBERNATE.addDatabaseConfig(databaseConfig, autoCreateDatabase);
            if (databaseConfig.isFirstRun()) {
                initInitialData();
            }
            return databaseConnected = HIBERNATE.saveDatabaseConfig();
        } else {
            return false;
        }
    }

    public void reloadDatabaseConfig() {
        HIBERNATE.reloadDatabaseConfig();
    }

    public abstract boolean initInitialData();

    public boolean showDatabaseSettingScreen() {
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            return new PnlDatabaseSettingCtrl().init();
        } else if (PlatformMode.WEB.equals(PLAT_MODE)) {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        } else {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        }
    }

    protected boolean _login(String username, String password) {
        return new UtilUserBo().login(username, password);
    }

    protected void _initDatabaseFilter() {
    }

    public void applyDatabaseFilter() {
    }

    public void clearDatabaseFilter() {
    }

    protected abstract void _applyUserConfig();

    protected void _clearUserConfig() {
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            getMenubarH().setVisible(false);
            getMenubarV().setVisible(false);
            getMainScreen().validate();
        } else if (PlatformMode.WEB.equals(PLAT_MODE)) {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        }
    }

    protected boolean _showLoginScreen() {
        if (PlatformMode.DESKTOP.equals(PLAT_MODE)) {
            return new PnlLoginCtrl().init();
        } else if (PlatformMode.WEB.equals(PLAT_MODE)) {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        } else {
            throw new UnsupportedOperationException(turn(Not_supported_yet));
        }
    }

    protected boolean _showHomeScreen() {
        return true;
    }

    public void showScreen() {
        if (databaseConnected) {
            if (INSTANCE_hasLogged()) {
                _showHomeScreen();
            } else {
                _showLoginScreen();
            }
        }
    }

    public boolean login(String username, String password) {
        if (_login(username, password)) {
            applyDatabaseFilter();
            _applyUserConfig();
            showScreen();
            return true;
        } else {
            return false;
        }
    }

    public boolean logout() {
        if (INSTANCE_hasLogged()) {
            CCLoginInfo.INSTANCE.logout();
            clearDatabaseFilter();
            _clearUserConfig();
            showScreen();
            return true;
        } else {
            return false;
        }
    }
//</editor-fold>
}