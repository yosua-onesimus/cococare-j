package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.extract;
import static cococare.common.CCClass.getIds;
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCLogic.isNotNull;
import cococare.database.CCHibernateFilter;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCDateInput;
import cococare.swing.component.CCDatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;
import model.bo.lib.LibBorrowingItemBo;
import model.obj.lib.LibBook;
import model.obj.lib.LibBorrowingItem;
import static model.obj.lib.LibFilter.isSuspendFalse;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlBorrowingItemCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibBorrowingItemBo borrowingItemBo;
    private CCDatePicker dtpdate;
    private CCBandBox bndBook;
    private JTextField txtBorrowingCost;
    private CCDateInput dtpDateReturn;
    private JTextField txtBorrowingFine;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibBorrowingItem.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        dtpdate = (CCDatePicker) parameter.get(callerCtrl.toString() + "dtpDate");
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndBook.getTable().setHqlFilters(
                isSuspendFalse,
                new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "id";
            }

            @Override
            public String getExpression() {
                return "id NOT IN (:ids)";
            }

            @Override
            public String getParameterName() {
                return "ids";
            }

            @Override
            public Object getFieldValue() {
                //get borrowed books from database
                List<LibBook> borrowedBooks = borrowingItemBo.getUnlimitedBorrowedBooks();
                //get borrowed books from screen
                borrowedBooks.addAll(extract((List) parameter.get(callerCtrl.toString() + childsValue), "book"));
                return getIds(borrowedBooks);
            }
        });
    }

    @Override
    protected void _initListener() {
        super._initListener();
        bndBook.addEventListenerOnSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateBookInfo();
            }
        });
    }

    private void _doUpdateBookInfo() {
        LibBook book = bndBook.getObject();
        if (isNotNull(book)) {
            txtBorrowingCost.setText(formatNumber(book.getBorrowingCost()));
            dtpDateReturn.setDate(borrowingItemBo.calculateDateReturn(dtpdate.getDate(), book.getBorrowingLimit()));
            txtBorrowingFine.setText(formatNumber(book.getBorrowingFine()));
        }
    }
}