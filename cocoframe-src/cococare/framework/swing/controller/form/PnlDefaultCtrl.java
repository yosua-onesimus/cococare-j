package cococare.framework.swing.controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDefaultCtrl extends CFSwingCtrl {

    @Override
    protected Class _getClass() {
        return PnlDefaultCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return isNotNull(objEntity) ? objEntity.getClass() : null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}