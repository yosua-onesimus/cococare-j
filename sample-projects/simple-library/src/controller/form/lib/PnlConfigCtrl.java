package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.lib.LibConfigBo;
import model.obj.lib.LibConfig;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlConfigCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibConfigBo configBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = configBo.loadLibConfig();
    }

    @Override
    protected boolean _doSaveEntity() {
        return configBo.saveConf(objEntity);
    }
}