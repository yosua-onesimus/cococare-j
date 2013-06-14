package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.load;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.initDefaultHandler;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import cococare.database.CCLoginInfo;
import static cococare.database.CCLoginInfo.INSTANCE_hasLogged;
import static cococare.datafile.CCFile.*;
import static cococare.datafile.CCSetup.executeMandatoryFile;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.bo.util.UtilUserBo;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.obj.util.UtilConfAppl;
import static cococare.framework.swing.CFSwingMap.getCCProgressbar;
import java.io.File;
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

    protected enum MenuPosition {

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
// </editor-fold>
    //
//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    protected PlatformMode PLAT_MODE = PlatformMode.DESKTOP;
    protected DatabaseMode DTBS_MODE = DatabaseMode.SINGLE;
    protected MenuPosition MENU_POST = MenuPosition.LEFT_SIDE;
    //
    protected String APPL_ID = "appl.id";
    public static String APPL_CODE = "appl.code";
    protected String APPL_LOGO = "/cococare/resource/icon-cococare.jpg";
    protected String APPL_NAME = "appl.name";
    protected String APPL_VER = "1.0.120317";
    //
    public static String S_APPL_CONF = "appl.conf";
    public static String S_APPL_LCNS = "appl.lcns";
    public static String S_DTBS_CONF = "dtbs.conf";
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
        executeMandatoryFile();
    }

    protected void _loadExternalSetting() {
        load(CCLanguage.LanguagePack.EN);
        File file = getFileSystConfFile(S_APPL_CONF);
        if (file.exists()) {
            updateNonContent(readObject(file));
        }
    }

    protected abstract void _initScreen();

    public abstract void end();

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

    protected abstract CFApplUae _initInitialDataUaeUtility(CFApplUae applUae);

    public boolean initInitialData() {
        return true;
    }

    public abstract boolean showDatabaseSettingScreen();

    protected boolean _login(String username, String password) {
        return new UtilUserBo().login(username, password);
    }

    public abstract void updateNonContent(Object object);

    protected void _initDatabaseFilter() {
    }

    public void applyDatabaseFilter() {
    }

    public void clearDatabaseFilter() {
    }

    protected abstract CFApplUae _applyUserConfigUaeUtility(CFApplUae applUae);

    protected void _applyUserConfig() {
        UtilConfAppl confAppl = new UtilConfigBo().loadConfAppl();
        updateNonContent(confAppl);
        MENU_POST = MenuPosition.values()[parseInt(confAppl.getApplMenuPosition())];
    }

    protected abstract void _clearUserConfig();

    protected abstract boolean _showLoginScreen();

    protected boolean _showHomeScreen() {
        return true;
    }

    public void showScreen() {
        if (databaseConnected) {
            if (INSTANCE_hasLogged()) {
                applyDatabaseFilter();
                _applyUserConfig();
                _showHomeScreen();
            } else {
                clearDatabaseFilter();
                _clearUserConfig();
                _showLoginScreen();
            }
        }
    }

    public boolean login(String username, String password) {
        if (_login(username, password)) {
            showScreen();
            return true;
        } else {
            return false;
        }
    }

    public boolean logout() {
        if (INSTANCE_hasLogged()) {
            CCLoginInfo.INSTANCE.logout();
            showScreen();
            return true;
        } else {
            return false;
        }
    }
//</editor-fold>
}