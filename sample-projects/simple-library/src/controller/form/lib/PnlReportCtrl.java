package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.showPanel;
import javax.swing.JPanel;
import model.obj.lib.LibReport;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JPanel pnlReport;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibReport.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        showPanel(pnlReport, ((LibReport) objEntity).newReport().getViewer());
    }

    @Override
    protected String _getSysRef(Object objEntity) {
        return parameter.get(toString()).toString();
    }

    @Override
    protected String _getTabTitle() {
        return ((LibReport) objEntity).getReportName();
    }
}