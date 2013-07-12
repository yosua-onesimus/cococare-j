package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SVOperator;
//</editor-fold>

public class PnlOperatorCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SVOperator.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}