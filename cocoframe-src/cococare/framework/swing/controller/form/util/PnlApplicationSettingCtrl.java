package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationSettingCtrl extends CFSwingCtrl {

    private UtilConfigBo configBo;

    @Override
    protected Class _getEntity() {
        return UtilConfAppl.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = configBo.loadConfAppl();
    }

    @Override
    protected boolean _doSaveEntity() {
        return configBo.saveConf(objEntity);
    }
}