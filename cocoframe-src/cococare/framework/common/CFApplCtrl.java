package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.load;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.initDefaultHandler;
import cococare.common.trial.CCLicense;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import cococare.database.CCLoginInfo;
import static cococare.database.CCLoginInfo.INSTANCE_hasLogged;
import cococare.database.model.bo.cc.CCCustomFieldConfigBo;
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
    protected static PlatformMode PLAT_MODE = PlatformMode.DESKTOP;
    protected static DatabaseMode DTBS_MODE = DatabaseMode.SINGLE;
    protected static MenuPosition MENU_POST = MenuPosition.LEFT_SIDE;
    //
    protected static String APPL_ID = "appl.id";
    public static String APPL_CODE = "appl.code";
    protected static String APPL_LOGO = "/cococare/resource/icon-cococare.jpg";
    protected static String APPL_NAME = "appl.name";
    protected static String APPL_VER = "1.0.130317";
    //
    protected static final String S_APPL_CONF = "appl.conf";
    protected static final String S_APPL_LCNS = "appl.lcns";
    protected static final String S_DTBS_CONF = "dtbs.conf";
    //
    public static File FILE_APPL_CONF = new File(getFileUserConfPath(), S_APPL_CONF);
    protected static File FILE_APPL_LCNS = new File(getFileSystConfPath(), S_APPL_LCNS);
    protected static File FILE_DTBS_CONF = new File(getFileSystConfPath(), S_DTBS_CONF);
    //
    protected static CCHibernate HIBERNATE;
    //
    protected static boolean databaseConnected = true;
    //
    protected static boolean LICENSE_ACTIVE = false;
    public static CCLicense LICENSE;
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
        File file = getFileUserConfFile(S_APPL_CONF);
        if (file.exists()) {
            updateNonContent(readObject(file));
        }
        if (LICENSE_ACTIVE) {
            LICENSE = new CCLicense(APPL_ID, FILE_APPL_LCNS);
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
        //if (PlatformMode.WEB.equals(PLAT_MODE)) {
        //needed by hibernate to read external changes
        HIBERNATE.setProperty_C3P0();
        //}
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

    /**
     * Initial custom field configuration.
     *
     * @return true if success; false if fail.
     */
    public boolean initInitialData() {
        return new CCCustomFieldConfigBo().initCustomFieldConfig();
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

    protected abstract void _applyUserConfig();

    protected abstract void _clearUserConfig();

    protected abstract boolean _showLoginScreen();

    protected boolean _showHomeScreen() {
        return true;
    }

    public void showScreen() {
        if (PlatformMode.WEB.equals(PLAT_MODE)) {
            _initScreen();
        }
        if (databaseConnected) {
            UtilConfAppl confAppl = new UtilConfigBo().loadConfAppl();
            updateNonContent(confAppl);
            MENU_POST = MenuPosition.values()[parseInt(confAppl.getApplMenuPosition())];
        }
        if ((PlatformMode.DESKTOP.equals(PLAT_MODE) && databaseConnected)
                || (PlatformMode.WEB.equals(PLAT_MODE) && DatabaseMode.SINGLE.equals(DTBS_MODE) && databaseConnected)
                || (PlatformMode.WEB.equals(PLAT_MODE) && DatabaseMode.MULTIPLE.equals(DTBS_MODE))) {
            if (INSTANCE_hasLogged()) {
                applyDatabaseFilter();
                _applyUserConfig();
                _showHomeScreen();
            } else {
                clearDatabaseFilter();
                _clearUserConfig();
                _showLoginScreen();
            }
        } else if (PlatformMode.WEB.equals(PLAT_MODE) && DatabaseMode.SINGLE.equals(DTBS_MODE) && !databaseConnected) {
            showDatabaseSettingScreen();
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