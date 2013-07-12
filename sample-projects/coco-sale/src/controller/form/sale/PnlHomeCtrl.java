package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.sale.SVConfigBo;
import model.obj.sale.SVConfig;
//</editor-fold>

public class PnlHomeCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private SVConfigBo configBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return SVConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = configBo.loadSVConfig();
    }
}