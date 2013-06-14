package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.coalesce;
import cococare.database.CCDatabaseConfig;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDatabaseSettingCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return CCDatabaseConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = coalesce(UtilityModule.INSTANCE.getCCHibernate().getDatabaseConfig(), new CCDatabaseConfig());
    }

    @Override
    protected boolean _doSaveEntity() {
        CCDatabaseConfig databaseConfig = (CCDatabaseConfig) objEntity;
        updateCaller = CFApplCtrl.INSTANCE.openDatabaseConnection(databaseConfig, databaseConfig.isAutoCreateDatabase());
        if (updateCaller && !databaseConfig.isFirstRun() && databaseConfig.isInitInitialData()) {
            updateCaller = CFApplCtrl.INSTANCE.initInitialData();
        }
        return updateCaller;
    }

    @Override
    protected void _doCloseScreen() {
        super._doCloseScreen();
        if (updateCaller) {
            new PnlLoginCtrl().init();
        } else {
            CFApplCtrl.INSTANCE.reloadDatabaseConfig();
        }
    }
}