package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class PnlVoucherTypeListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SVVoucherType.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        //
        tblEntity.setHqlOrderSyntax("operator.id ASC, purchasePrice ASC");
    }
}