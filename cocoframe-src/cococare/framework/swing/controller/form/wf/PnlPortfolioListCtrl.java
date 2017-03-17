package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.WF_DOCUMENT_CLASS;
import static cococare.framework.model.obj.wf.WfFilter.isDocumentStatusIsPortfolio;
import cococare.framework.swing.controller.custom.wf.NumberFieldShowEditor;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import static cococare.swing.CCSwing.setVisible;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlPortfolioListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return WF_DOCUMENT_CLASS;
    }

    @Override
    protected Class _getClass() {
        return _getDefaultToCustomClass();
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setVisibleField(false, "number");
        tblEntity.addField(0, new NumberFieldShowEditor(this, tblEntity, null, null));
        tblEntity.setEditableColumn(true, 0);
        tblEntity.setHqlFilters(isDocumentStatusIsPortfolio);
    }

    @Override
    protected void _initNaviElements() {
        super._initNaviElements();
        setVisible(false, swingView.getBtnEdit(), swingView.getBtnDelete());
    }
}