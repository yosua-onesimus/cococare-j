package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCDatePicker;
import model.obj.lib.LibBorrowing;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlBorrowingCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCDatePicker dtpdate;
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
        parameter.put(toString() + "dtpdate", dtpdate);
        _addChildScreen("borrowing", new PnlBorrowingItemListCtrl(), "pnlBorrowingItem");
    }
}