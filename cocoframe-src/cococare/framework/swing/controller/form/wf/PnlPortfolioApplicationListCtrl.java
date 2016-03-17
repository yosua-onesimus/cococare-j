package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.WF_DOCUMENT_CLASS;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import static cococare.swing.CCSwing.setVisible;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlPortfolioApplicationListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return WF_DOCUMENT_CLASS;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.addField(tblEntity.getColumnCount(), "status");
    }

    @Override
    protected void _initNaviElements() {
        super._initNaviElements();
        setVisible(false, swingView.getBtnAdd(), swingView.getBtnEdit(), swingView.getBtnDelete());
    }
}