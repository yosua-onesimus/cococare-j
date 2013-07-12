package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SCustomer;
//</editor-fold>

public class PnlCustomerCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SCustomer.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}