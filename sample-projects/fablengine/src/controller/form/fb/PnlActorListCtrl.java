package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.fb.FBActor;
//</editor-fold>

public class PnlActorListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return FBActor.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}