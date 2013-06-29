package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.common.CFViewCtrl;
import cococare.framework.swing.CFSwingCtrl;
import model.obj.GameWorld;
//</editor-fold>

public class DlgGameOverCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return GameWorld.class;
    }

    @Override
    protected CFViewCtrl.BaseFunction _getBaseFunction() {
        return CFViewCtrl.BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected CFViewCtrl.ShowMode _getShowMode() {
        return CFViewCtrl.ShowMode.DIALOG_MODE;
    }
}