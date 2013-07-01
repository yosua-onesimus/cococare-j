package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.datafile.CCFile;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

public class PnlCococareCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected CFViewCtrl.BaseFunction _getBaseFunction() {
        return null;
    }

    @Override
    public boolean init() {
        CCFile.browse("http://cococare.wordpress.com/");
        return true;
    }
}