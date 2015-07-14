package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.fb.FbActionAttribute;
//</editor-fold>

public class PnlActionAttributeCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return FbActionAttribute.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}