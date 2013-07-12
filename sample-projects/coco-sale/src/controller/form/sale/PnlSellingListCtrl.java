package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SVSelling;
//</editor-fold>

public class PnlSellingListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SVSelling.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}