package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SVDeposit;
//</editor-fold>

public class PnlDepositListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SVDeposit.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}