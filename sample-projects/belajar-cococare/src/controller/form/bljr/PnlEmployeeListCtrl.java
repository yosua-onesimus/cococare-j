package controller.form.bljr;

import cococare.framework.swing.CFSwingCtrl;
import model.obj.bljr.Employee;

public class PnlEmployeeListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return Employee.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}