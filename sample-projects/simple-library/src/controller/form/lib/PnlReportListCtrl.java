package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCEditor;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.obj.lib.LibReport;
import model.obj.lib.LibReport.Report;
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
    private JLabel xBook;
    private CCBandBox bndBook;
    private JLabel xMember;
    private CCBandBox bndMember;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibReport.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        edtEntity = new CCEditor(getContainer(), LibReport.class);
        super._initComponent();
    }

    @Override
    protected void _doUpdateAccessible() {
        int selectedIndex = cmbReport.getSelectedIndex();
        edtEntity.setAccessible(bndBook, selectedIndex == Report.BOOK_HISTORY.ordinal() ? CCFieldConfig.Accessible.MANDATORY : CCFieldConfig.Accessible.NORMAL);
        edtEntity.setAccessible(bndMember, selectedIndex == Report.MEMBER_HISTORY.ordinal() ? CCFieldConfig.Accessible.MANDATORY : CCFieldConfig.Accessible.NORMAL);
        xBook.setVisible(selectedIndex == Report.BOOK_HISTORY.ordinal());
        bndBook.setVisible(selectedIndex == Report.BOOK_HISTORY.ordinal());
        xMember.setVisible(selectedIndex == Report.MEMBER_HISTORY.ordinal());
        bndMember.setVisible(selectedIndex == Report.MEMBER_HISTORY.ordinal());
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