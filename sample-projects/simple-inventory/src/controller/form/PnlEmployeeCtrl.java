package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class PnlEmployeeCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return InvEmployee.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}