package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.formatNumeric;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.execute;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCDatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.lib.LibReturningItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReturningItemListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCDatePicker dtpDate;
    private CCBandBox bndMember;
    private JTextField txtTotalItem;
    private JTextField txtTotalFine;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibReturningItem.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        dtpDate = (CCDatePicker) parameter.get(callerCtrl.toString() + "dtpDate");
        bndMember = (CCBandBox) parameter.get(callerCtrl.toString() + "bndMember");
        txtTotalItem = (JTextField) parameter.get(callerCtrl.toString() + "txtTotalItem");
        txtTotalFine = (JTextField) parameter.get(callerCtrl.toString() + "txtTotalFine");
        parameter.put(toString() + "dtpDate", dtpDate);
        parameter.put(toString() + "bndMember", bndMember);
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.addListenerOnChange(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateParentField(actionEvent);
            }
        });
    }

    private void _doUpdateParentField(ActionEvent actionEvent) {
        execute(((ActionListener) parameter.get(callerCtrl.toString()
                + (tblEntity.getRowCount() == 0 ? "returningInfo-MANDATORY" : "returningInfo-MANDATORY_READONLY"))),
                actionEvent);
        txtTotalItem.setText(formatNumeric(tblEntity.getRowCount()));
        double totalFine = 0;
        for (Object object : tblEntity.getList()) {
            LibReturningItem returningItem = (LibReturningItem) object;
            totalFine += returningItem.getBorrowingFine();
        }
        txtTotalFine.setText(formatNumber(totalFine));
    }
}