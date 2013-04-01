package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.InvInventory;
//</editor-fold>

public class PnlInventory3Ctrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return InvInventory.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.PANEL_MODE;
    }
}