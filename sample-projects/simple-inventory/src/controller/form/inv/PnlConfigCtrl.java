package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.inv.InvConfigBo;
import model.obj.inv.InvConfig;
//</editor-fold>

public class PnlConfigCtrl extends CFSwingCtrl {

    private InvConfigBo configBo;

    @Override
    protected Class _getEntity() {
        return InvConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = configBo.loadInvConfig();
    }

    @Override
    protected boolean _doSaveEntity() {
        return configBo.saveConf(objEntity);
    }
}