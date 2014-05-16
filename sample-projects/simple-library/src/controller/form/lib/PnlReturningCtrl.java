package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.lib.LibReturning;
//</editor-fold>

public class PnlReturningCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return LibReturning.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}