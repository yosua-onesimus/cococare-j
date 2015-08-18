package controller.form.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCEditor;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import model.obj.stk.StkReport;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JComboBox cmbReport;
    private CCButton _btnView;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return StkReport.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        edtEntity = new CCEditor(getContainer(), StkReport.class);
        super._initComponent();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbReport, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateAccessible();
            }
        });
        addListener(_btnView, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doView();
            }
        });
    }

    @Override
    protected void _doView() {
        if (edtEntity.isValueValid()) {
            PnlReportCtrl reportCtrl = new PnlReportCtrl();
            parameter.put(reportCtrl.toString(), swingView.getTabEntity().getTabCount());
            reportCtrl.with(parameter).with(this).init(edtEntity.getValueFromEditor());
        }
    }
}