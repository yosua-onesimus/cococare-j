package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.HBN_MULTI_DOMAIN;
import static cococare.common.CCConfig.HBN_WORKFLOW_MODULE_INCLUDED;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.load;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.initLogHandler;
import cococare.common.trial.CCLicense;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import static cococare.database.CCLoginInfo.INSTANCE_hasLogged;
import static cococare.database.CCLoginInfo.INSTANCE_logout;
import cococare.database.model.bo.cc.CCCustomFieldConfigBo;
import static cococare.datafile.CCFile.*;
import static cococare.datafile.CCSetup.executeMandatoryFile;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.bo.util.UtilProvinceRegencyBo;
import cococare.framework.model.bo.util.UtilUserBo;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.mdl.wf.WorkflowModule;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.model.obj.util.UtilConfServ;
import java.io.File;
// </editor-fold>

/**
 * CFApplCtrl is an abstract class which functions as an application controller, in charge of
 * controlling the flow of applications in general.
 *
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
// </editor-fold>
    //
//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    protected static PlatformMode PLAT_MODE = PlatformMode.DESKTOP;
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
    protected static UtilConfAppl confAppl = new UtilConfAppl();
    protected static UtilConfServ confServ = new UtilConfServ();
    //
    protected static boolean LICENSE_ACTIVE = false;
    public static CCLicense LICENSE;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CFApplCtrl ">
    /**
     * CFApplCtrl is an abstract class which functions as an application controller, in charge of
     * controlling the flow of applications in general.
     */
    public CFApplCtrl() {
        __init();
    }

    private void __init() {
        if (isNull(INSTANCE)) {
            INSTANCE = this;
            _loadInternalSetting();
            _loadExternalSetting();
            _initDatabaseProfile();
        }
        if (PlatformMode.WEB.equals(PLAT_MODE)) {
            _initScreen();
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    /**
     * <b>Line Number: 100</b>
     */
    public abstract void end();

    /**
     * <b>Line Number: 105</b>
     * <ol>
     * <li>Add a default log Handler to receive logging messages.</li>
     * <li>Execute setup for mandatory file.</li>
     * </ol>
     */
    protected void _loadInternalSetting() {
        initLogHandler();
        executeMandatoryFile();
    }

    /**
     * <b>Line Number: 117</b>
     * <ol>
     * <li>Load a language pack for some domains.</li>
     * <li>Get user configuration file.</li>
     * <li>updateNonContent(readObject(file)): ...</li>
     * </ol>
     */
    protected void _loadExternalSetting() {
        load(CCLanguage.LanguagePack.EN);
        File file = getFileUserConfFile(S_APPL_CONF);
        if (file.exists()) {
            updateNonContent(confAppl = (UtilConfAppl) readObject(file));
        }
        if (LICENSE_ACTIVE) {
            LICENSE = new CCLicense(APPL_ID, FILE_APPL_LCNS);
        }
    }

    /**
     * <b>Line Number: 136</b>
     */
    protected abstract void _initScreen();

    /**
     * <b>Line Number: 141</b>
     * <ol>
     * <li>Load a list databaseConfig from a file.</li>
     * <li>Automatic set C3P0 property.</li>
     * <li>_initDatabaseEntity(): ...</li>
     * <li>_initDatabaseFilter(): ...</li>
     * <li>[singleDomain]openDatabaseConnection(HIBERNATE.getDatabaseConfig(), false): ..</li>
     * <li>[multiDomain]Instantiate a new SessionFactory, using the properties and mappings in this
     * configuration.</li>
     * </ol>
     */
    protected void _initDatabaseProfile() {
        HIBERNATE = new CCHibernate();
        HIBERNATE.loadDatabaseConfig(FILE_DTBS_CONF);
        HIBERNATE.setProperty_C3P0();
        _initDatabaseEntity();
        _initDatabaseFilter();
        if (!HBN_MULTI_DOMAIN) {
            databaseConnected = openDatabaseConnection(HIBERNATE.getDatabaseConfig(), false);
        } else {
            HIBERNATE.buildSessionFactories();
        }
    }

    /**
     * <b>Line Number: 166</b>
     * <ol>
     * <li>Initialization module with the specified hibernate.</li>
     * </ol>
     */
    protected void _initDatabaseEntity() {
        UtilityModule.INSTANCE.init(HIBERNATE);
        if (HBN_WORKFLOW_MODULE_INCLUDED) {
            WorkflowModule.INSTANCE.init(HIBERNATE);
        }
    }

    /**
     * <b>Line Number: 179</b>
     * <ol>
     * <li>Check whether the connection is valid or not.</li>
     * <li>Add a databaseConfig and instantiate a new SessionFactory.</li>
     * <li>initInitialData(): ...</li>
     * <li>Save databaseConfig to the file.</li>
     * </ol>
     *
     * @param databaseConfig the databaseConfig.
     * @param autoCreateDatabase the autoCreateDatabase.
     * @return true if the database connection is open.
     */
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

    /**
     * <b>Line Number: 204</b>
     * <ol>
     * <li>Reload databaseConfig from the file.</li>
     * </ol>
     */
    public void reloadDatabaseConfig() {
        HIBERNATE.reloadDatabaseConfig();
    }

    /**
     * <b>Line Number: 214</b>
     * <ol>
     * <li>Initial default data (custom field configuration, province, regency, etc).</li>
     * </ol>
     *
     * @return true if success; false if fail.
     */
    protected boolean _initInitialData() {
        return new CCCustomFieldConfigBo().initCustomFieldConfig()
                && new UtilProvinceRegencyBo().initInitialData();
    }

    /**
     * <b>Line Number: 227</b>
     *
     * @return the CFApplUae.
     */
    protected abstract CFApplUae _initInitialUaeBegin();

    /**
     * <b>Line Number: 234</b>
     *
     * @param uae a CFApplUae.
     */
    protected abstract void _initInitialUaeBody(CFApplUae uae);

    /**
     * <b>Line Number: 241</b>
     *
     * @param uae a CFApplUae.
     * @return true if success; false if fail.
     */
    protected abstract boolean _initInitialUaeEnd(CFApplUae uae);

    /**
     * <b>Line Number: 249</b>
     * <ol>
     * <li>_initInitialUaeBegin(): ...</li>
     * <li>_initInitialUaeBody(uae): ...</li>
     * <li>_initInitialUaeEnd(uae): ...</li>
     * </ol>
     *
     * @return true if success; false if fail.
     */
    protected boolean _initInitialUae() {
        CFApplUae uae = _initInitialUaeBegin();
        _initInitialUaeBody(uae);
        return _initInitialUaeEnd(uae);
    }

    /**
     * <b>Line Number: 265</b>
     * <ol>
     * <li>_initInitialData() && _initInitialUae(): ...</li>
     * </ol>
     *
     * @return true if success; false if fail.
     */
    public boolean initInitialData() {
        return _initInitialData() && _initInitialUae();
    }

    /**
     * <b>Line Number: 277</b>
     *
     * @return true if success; false if fail.
     */
    public abstract boolean showDatabaseSettingScreen();

    /**
     * <b>Line Number: 284</b>
     *
     * @param username the username.
     * @param password the password.
     * @return true if success; false if fail.
     */
    protected boolean _login(String username, String password) {
        return new UtilUserBo().login(username, password);
    }

    /**
     * <b>Line Number: 295</b>
     *
     * @param object the object.
     */
    public abstract void updateNonContent(Object object);

    /**
     * <b>Line Number: 302</b>
     * <ol>
     * <li>Initial database filter. Default blank.</li>
     * </ol>
     */
    protected void _initDatabaseFilter() {
    }

    /**
     * <b>Line Number: 311</b>
     * <ol>
     * <li>Apply database filter. Default blank.</li>
     * </ol>
     */
    public void applyDatabaseFilter() {
    }

    /**
     * <b>Line Number: 320</b>
     * <ol>
     * <li>Clear database filter. Default blank.</li>
     * </ol>
     */
    public void clearDatabaseFilter() {
    }

    /**
     * <b>Line Number: 329</b>
     *
     * @return the CFApplUae.
     */
    protected abstract CFApplUae _applyUserConfigUaeBegin();

    /**
     * <b>Line Number: 336</b>
     *
     * @param uae a CFApplUae.
     */
    protected abstract void _applyUserConfigUaeBody(CFApplUae uae);

    /**
     * <b>Line Number: 343</b>
     *
     * @param uae a CFApplUae.
     */
    protected abstract void _applyUserConfigUaeEnd(CFApplUae uae);

    /**
     * <b>Line Number: 350</b>
     * <ol>
     * <li>_applyUserConfigUaeBegin(): ...</li>
     * <li>_applyUserConfigUaeBody(uae): ...</li>
     * <li>_applyUserConfigUaeEnd(uae): ...</li>
     * </ol>
     */
    protected void _applyUserConfig() {
        CFApplUae uae = _applyUserConfigUaeBegin();
        _applyUserConfigUaeBody(uae);
        _applyUserConfigUaeEnd(uae);
    }

    /**
     * <b>Line Number: 364</b>
     */
    protected abstract void _clearUserConfig();

    /**
     * <b>Line Number: 369</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _showLoginScreen();

    /**
     * <b>Line Number: 376</b>
     * <ol>
     * <li>Show home screen. Default blank.</li>
     * </ol>
     *
     * @return true if success; false if fail.
     */
    protected boolean _showHomeScreen() {
        return true;
    }

    /**
     * <b>Line Number: 388</b>
     * <ol>
     * <li>[webPlatform]_initScreen(): ...</li>
     * <li>[databaseConnected]updateNonContent(new UtilConfigBo().loadConfAppl()): ...</li>
     * <li>[hasLogged]applyDatabaseFilter(): ...</li>
     * <li>[hasLogged]_applyUserConfig(): ...</li>
     * <li>[hasLogged]_showHomeScreen(): ...</li>
     * <li>[notLogYet]clearDatabaseFilter(): ...</li>
     * <li>[notLogYet]_clearUserConfig(): ...</li>
     * <li>[notLogYet]_showLoginScreen(): ...</li>
     * <li>[databaseNotConnected]showDatabaseSettingScreen(): ...</li>
     * </ol>
     */
    public void showScreen() {
        if (databaseConnected) {
            UtilConfigBo configBo = new UtilConfigBo();
            updateNonContent(confAppl = configBo.loadConfAppl());
            updateNonContent(confServ = configBo.loadConfServ());
        }
        if ((PlatformMode.DESKTOP.equals(PLAT_MODE) && databaseConnected)
                || (PlatformMode.WEB.equals(PLAT_MODE) && !HBN_MULTI_DOMAIN && databaseConnected)
                || (PlatformMode.WEB.equals(PLAT_MODE) && HBN_MULTI_DOMAIN)) {
            if (INSTANCE_hasLogged()) {
                applyDatabaseFilter();
                _applyUserConfig();
                _showHomeScreen();
            } else {
                clearDatabaseFilter();
                _clearUserConfig();
                _showLoginScreen();
            }
        } else if ((PlatformMode.DESKTOP.equals(PLAT_MODE) && !databaseConnected)
                || (PlatformMode.WEB.equals(PLAT_MODE) && !HBN_MULTI_DOMAIN && !databaseConnected)) {
            showDatabaseSettingScreen();
        }
    }

    /**
     * <b>Line Number: 426</b>
     * <ol>
     * <li>_login(username, password): ...</li>
     * <li>showScreen(): ...</li>
     * </ol>
     *
     * @param username the username.
     * @param password the password.
     * @return true if success; false if fail.
     */
    public boolean login(String username, String password) {
        if (_login(username, password)) {
            showScreen();
            return true;
        } else {
            return false;
        }
    }

    /**
     * <b>Line Number: 446</b>
     * <ol>
     * <li>Clear session values.</li>
     * <li>showScreen(): ...</li>
     * </ol>
     *
     * @return true if success; false if fail.
     */
    public boolean logout() {
        if (INSTANCE_hasLogged()) {
            INSTANCE_logout();
            showScreen();
            return true;
        } else {
            return false;
        }
    }
//</editor-fold>
}