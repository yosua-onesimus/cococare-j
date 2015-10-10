package cococare.framework.swing.controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.jasperreports.CCReport;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.showPanel;
import javax.swing.JPanel;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportDefaultCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    protected JPanel pnlReport;
//</editor-fold>

    @Override
    protected Class _getClass() {
        return PnlReportDefaultCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return objEntity.getClass();
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        showPanel(pnlReport, ((CCReport) objEntity).newReport().getViewer());
    }

    @Override
    protected String _getSysRef(Object objEntity) {
        return parameter.get(toString()).toString();
    }

    @Override
    protected String _getTabTitle() {
        return ((CCReport) objEntity).getReportName();
    }
}