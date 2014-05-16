package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.extract;
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.getMinTime;
import static cococare.common.CCLogic.isNotNull;
import cococare.database.CCHibernateFilter;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCDatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;
import model.bo.lib.LibReturningItemBo;
import model.obj.lib.LibBorrowingItem;
import static model.obj.lib.LibFilter.isReturnedFalse;
import model.obj.lib.LibMember;
import model.obj.lib.LibReturningItem;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReturningItemCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibReturningItemBo returningItemBo;
    private CCDatePicker dtpdate;
    private CCBandBox bndMember;
    private CCBandBox bndBorrowingItem;
    private JTextField txtBorrowingFine;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibReturningItem.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        dtpdate = (CCDatePicker) parameter.get(callerCtrl.toString() + "dtpDate");
        bndMember = (CCBandBox) parameter.get(callerCtrl.toString() + "bndMember");
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndBorrowingItem.getTable().setHqlFilters(
                isReturnedFalse,
                new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "borrowing.member_";
            }

            @Override
            public Object getFieldValue() {
                return bndMember.getObject();
            }
        }, new CCHibernateFilter() {
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
                //get borrowed items from database
                List ids = extract(returningItemBo.getUnlimitedReturningItems((LibMember) bndMember.getObject()), "borrowingItem.id");
                //get borrowed items from screen
                ids.addAll(extract((List) parameter.get(callerCtrl.toString() + childsValue), "borrowingItem.id"));
                return ids;
            }
        });
    }

    @Override
    protected void _initListener() {
        super._initListener();
        bndBorrowingItem.addEventListenerOnSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateBookInfo();
            }
        });
    }

    private void _doUpdateBookInfo() {
        LibBorrowingItem borrowingItem = bndBorrowingItem.getObject();
        if (isNotNull(borrowingItem)) {
            if (getMinTime(dtpdate.getDate()).after(borrowingItem.getDateReturn())) {
                txtBorrowingFine.setText(formatNumber(borrowingItem.getBorrowingFine()));
            }
        }
    }
}