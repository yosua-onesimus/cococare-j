package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.fb.FBAction;
//</editor-fold>

public class PnlActionListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return FBAction.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}