package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

public class PnlExitCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return null;
    }

    @Override
    public boolean init() {
        System.exit(0);
        return true;
    }
}