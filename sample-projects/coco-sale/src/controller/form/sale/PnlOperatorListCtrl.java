package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SVOperator;
//</editor-fold>

public class PnlOperatorListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SVOperator.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        //
        tblEntity.setHqlOrderSyntax("id ASC");
    }
}