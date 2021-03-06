package cococare.framework.swing.controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDefaultWithChildCtrl extends CFSwingCtrl {

    @Override
    protected Class _getClass() {
        return PnlDefaultWithChildCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return objEntity.getClass();
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}