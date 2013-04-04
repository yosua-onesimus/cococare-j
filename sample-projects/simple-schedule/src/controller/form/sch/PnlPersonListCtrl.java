package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class PnlOwnershipListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return InvOwnership.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}