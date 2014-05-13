package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.lib.LibBorrowingItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlBorrowingItemListCtrl extends CFSwingCtrl {

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
        parameter.put(toString() + "dtpdate", parameter.get(callerCtrl.toString() + "dtpdate"));
    }
}