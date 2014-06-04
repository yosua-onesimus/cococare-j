package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.formatNumeric;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCDatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.lib.LibBorrowingItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlBorrowingItemListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCDatePicker dtpDate;
    private JTextField txtTotalItem;
    private JTextField txtTotalCost;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibBorrowingItem.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        dtpDate = (CCDatePicker) parameter.get(callerCtrl.toString() + "dtpDate");
        txtTotalItem = (JTextField) parameter.get(callerCtrl.toString() + "txtTotalItem");
        txtTotalCost = (JTextField) parameter.get(callerCtrl.toString() + "txtTotalCost");
        parameter.put(toString() + "dtpDate", dtpDate);
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.addEventListenerOnChange(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateParentField();
            }
        });
    }

    private void _doUpdateParentField() {
        ((ActionListener) parameter.get(callerCtrl.toString()
                + (tblEntity.getRowCount() == 0 ? "dtpDate-MANDATORY" : "dtpDate-MANDATORY_READONLY"))).
                actionPerformed(null);
        txtTotalItem.setText(formatNumeric(tblEntity.getRowCount()));
        double totalCost = 0;
        for (Object object : tblEntity.getList()) {
            LibBorrowingItem borrowingItem = (LibBorrowingItem) object;
            totalCost += borrowingItem.getBorrowingCost();
        }
        txtTotalCost.setText(formatNumber(totalCost));
    }
}