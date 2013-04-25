package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.fb.FBClass;
//</editor-fold>

public class PnlClassListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return FBClass.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}