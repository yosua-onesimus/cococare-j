package model.mdl.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.util.PnlApplicationSettingCtrl;
import model.bo.sale.SVConfigBo;
//</editor-fold>

public class SVConfigCtrl extends PnlApplicationSettingCtrl {

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && new SVConfigBo().recalculateSalePrice();
    }
}