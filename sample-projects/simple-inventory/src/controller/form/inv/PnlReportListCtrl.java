package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCEditor;
import static cococare.swing.CCSwing.addActionListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.obj.inv.InvReport;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCButton _btnView;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return InvReport.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        edtEntity = new CCEditor(getContainer(), InvReport.class);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addActionListener(_btnView, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doView();
            }
        });
    }

    @Override
    protected void _doView() {
        PnlReportCtrl reportCtrl = new PnlReportCtrl();
        parameter.put(reportCtrl.toString(), swingView.getTabEntity().getTabCount());
        reportCtrl.with(parameter).with(this).init(edtEntity.getValueFromEditor());
    }
}