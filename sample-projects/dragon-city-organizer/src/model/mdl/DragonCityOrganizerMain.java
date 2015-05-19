package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.*;
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import static cococare.framework.swing.CFSwingMap.getMainScreen;
import cococare.framework.swing.controller.form.util.*;
//</editor-fold>

public class DragonCityOrganizerMain extends CFSwingMain {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static final boolean withoutLogin = true;
//</editor-fold>

    @Override
    protected void _loadInternalSetting() {
        APPL_ID = "dragon-city-organizer";
        APPL_CODE = "dragon-city-organizer";
        APPL_NAME = "Dragon City Organizer";
        super._loadInternalSetting();
        if (withoutLogin) {
            CCLoginInfo.INSTANCE = null;
        }
    }

    @Override
    protected void _loadExternalSetting() {
        CCLanguage.init(false, DragonCityOrganizerLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        DragonCityOrganizerModule.INSTANCE.init(HIBERNATE);
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
        new DragonCityOrganizerMain().showScreen();
    }
}