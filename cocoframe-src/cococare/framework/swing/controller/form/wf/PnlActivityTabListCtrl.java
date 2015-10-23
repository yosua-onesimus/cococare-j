package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.model.obj.wf.WfActivityTab;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlActivityTabListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getClass() {
        if (isNotNull(swingView)) {
            return getClass();
        }
        return super._getClass();
    }

    @Override
    protected Class _getEntity() {
        return WfActivityTab.class;
    }
}