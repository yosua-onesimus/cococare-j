package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.wf.WfWorkflowHistory;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import static cococare.swing.CCSwing.setVisible;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlWorkflowHistoryListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return WfWorkflowHistory.class;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.initFields("dateAssigned", "dateDue", "activity", "dateClaimed", "user", "dateProcessed", "action");
    }

    @Override
    protected void _initNaviElements() {
        super._initNaviElements();
        setVisible(false, swingView.getBtnAdd(), swingView.getBtnEdit(), swingView.getBtnDelete());
    }
}