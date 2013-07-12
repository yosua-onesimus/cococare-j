package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.sale.SVConfigBo;
import model.obj.sale.SVDeposit;
//</editor-fold>

public class PnlDepositCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private SVConfigBo configBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return SVDeposit.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && configBo.recalculateSaldo();
    }
}