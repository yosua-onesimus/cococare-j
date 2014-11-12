package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.coalesce;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCDatabaseConfig.SupportedDatabase;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDatabaseSettingCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JComboBox cmbDriver;
    private JTextField txtPort;
    private JTextField txtUsername;
//</editor-fold>

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
    protected void _initListener() {
        super._initListener();
        addListener(cmbDriver, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doCmbDriver();
            }
        });
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

    private void _doCmbDriver() {
        SupportedDatabase supportedDatabase = SupportedDatabase.values()[cmbDriver.getSelectedIndex()];
        txtPort.setText(supportedDatabase.getDefaultPort());
        txtUsername.setText(supportedDatabase.getDefaultUsername());
    }
}