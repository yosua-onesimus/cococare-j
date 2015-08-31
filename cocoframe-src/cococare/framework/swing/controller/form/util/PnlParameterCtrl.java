package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlParameterCtrl extends PnlDefaultCtrl {

    @Override
    protected String _getTabTitle() {
        return _getEntityLabel() + ": " + super._getTabTitle();
    }
}