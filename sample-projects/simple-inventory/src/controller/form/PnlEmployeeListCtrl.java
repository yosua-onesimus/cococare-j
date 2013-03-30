package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.InvEmployee;
//</editor-fold>

public class PnlEmployeeListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return InvEmployee.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}