package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.*;
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.swing.CFSwingMain;
import static cococare.framework.swing.CFSwingMap.getMainScreen;
import cococare.framework.swing.controller.form.util.*;
import controller.form.fb.PnlPathfindingCtrl;
import java.util.Arrays;
import static model.mdl.fb.FableLanguage.Pathfinding;
import static model.mdl.fb.FableLanguage.Tester;
import model.obj.fb.FbConfig;
//</editor-fold>

public class FableMain extends CFSwingMain {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static final boolean withoutLogin = true;
//</editor-fold>

    @Override
    protected void _loadInternalSetting() {
        CCConfig.MSG_SHOW_LOG_DEBUG = true;
        CCConfig.HBN_SHOW_HQL = "true";
        APPL_ID = "fablengine";
        APPL_CODE = "fablengine";
        APPL_NAME = "FaBlEngine";
        APPL_VER = "2.0.150913";
        super._loadInternalSetting();
        if (withoutLogin) {
            CCLoginInfo.INSTANCE = null;
        }
    }

    @Override
    protected void _loadExternalSetting() {
        CCLanguage.init(false, FableLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        FableModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected boolean _initInitialData() {
        UtilConfigBo configBo = new UtilConfigBo();
        confAppl = configBo.loadConfAppl();
        confAppl.setUtilAdditionalSettingClass(Arrays.asList(
                FbConfig.class.getName()));
        return configBo.saveConf(confAppl);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
    }

    @Override
    protected boolean _initInitialUaeEnd(CFApplUae uae) {
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            uae.reg(Utility, Parameter, PnlParameterListCtrl.class);
            uae.reg(Utility, Export_Import, PnlExportImportCtrl.class);
        }
        uae.reg(Utility, Application_Setting, PnlApplicationSettingListCtrl.class);
        uae.reg(Utility, Database_Setting, PnlDatabaseSettingCtrl.class);
        return uae.compile();
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuRoot(PnlPathfindingCtrl.class);
        uae.addMenuParent(Tester, "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild(Pathfinding, "/cococare/resource/icon-menu-child.png", PnlPathfindingCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeEnd(CFApplUae uae) {
        uae.changeMenuSide();
        uae.addMenuParent(Utility, "/cococare/resource/icon-menu-parent.png", null);
        if (!HIBERNATE.getParameterClasses().isEmpty()) {
            uae.addMenuChild(Parameter, "/cococare/resource/icon-menu-parameter.png", PnlParameterListCtrl.class);
            uae.addMenuChild(Export_Import, "/cococare/resource/icon-menu-export-import.png", PnlExportImportCtrl.class);
        }
        uae.addMenuSeparator();
        uae.addMenuChild(Application_Setting, "/cococare/resource/icon-menu-application-setting.png", PnlApplicationSettingListCtrl.class);
        uae.addMenuChild(Database_Setting, "/cococare/resource/icon-menu-database-setting.png", PnlDatabaseSettingCtrl.class);
        if (!withoutLogin) {
            uae.addMenuParent(Log_Out, "/cococare/resource/icon-menu-log-out.png", PnlLoginCtrl.class);
        }
        uae.compileMenu();
        getMainScreen().validate();
    }

    @Override
    public void showScreen() {
        if (withoutLogin) {
            _applyUserConfig();
        } else {
            super.showScreen();
        }
    }

    public static void main(String[] args) {
        new FableMain().showScreen();
    }
}