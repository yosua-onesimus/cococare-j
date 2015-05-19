package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.HabitatDragon;
//</editor-fold>

public class PnlHabitatDragonListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return HabitatDragon.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }
}