package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig.Accessible;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCDatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.lib.LibBorrowing;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlBorrowingCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCDatePicker dtpDate;
    private JTextField txtTotalItem;
    private JTextField txtTotalCost;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibBorrowing.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        parameter.put(toString() + "dtpDate", dtpDate);
        parameter.put(toString() + "txtTotalItem", txtTotalItem);
        parameter.put(toString() + "txtTotalCost", txtTotalCost);
        parameter.put(toString() + "dtpDate-MANDATORY", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateDtpDate(Accessible.MANDATORY);
            }
        });
        parameter.put(toString() + "dtpDate-MANDATORY_READONLY", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateDtpDate(Accessible.MANDATORY_READONLY);
            }
        });
        _addChildScreen("borrowing", new PnlBorrowingItemListCtrl(), "pnlBorrowingItem");
    }

    private void _doUpdateDtpDate(Accessible accessible) {
        edtEntity.setAccessible(dtpDate, accessible);
    }
}