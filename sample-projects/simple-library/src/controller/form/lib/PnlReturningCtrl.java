package controller.form.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getIds;
import cococare.common.CCFieldConfig.Accessible;
import cococare.database.CCHibernateFilter;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCDatePicker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.bo.lib.LibReturningBo;
import model.obj.lib.LibReturning;
//</editor-fold>

public class PnlReturningCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private LibReturningBo returningBo;
    private CCDatePicker dtpDate;
    private CCBandBox bndMember;
    private JTextField txtTotalItem;
    private JTextField txtTotalFine;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibReturning.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        parameter.put(toString() + "dtpDate", dtpDate);
        parameter.put(toString() + "bndMember", bndMember);
        parameter.put(toString() + "txtTotalItem", txtTotalItem);
        parameter.put(toString() + "txtTotalFine", txtTotalFine);
        parameter.put(toString() + "returningInfo-MANDATORY", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateReturningInfo(Accessible.MANDATORY);
            }
        });
        parameter.put(toString() + "returningInfo-MANDATORY_READONLY", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateReturningInfo(Accessible.MANDATORY_READONLY);
            }
        });
        _addChildScreen("returning", new PnlReturningItemListCtrl(), "pnlReturningItem");
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndMember.getTable().setHqlFilters(new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "id";
            }

            @Override
            public String getParameterName() {
                return "ids";
            }

            @Override
            public Object getFieldValue() {
                return getIds(returningBo.getUnlimitedBorrowingMembers());
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return returningBo.saveOrUpdate((LibReturning) objEntity, _getEntityChilds());
    }

    private void _doUpdateReturningInfo(Accessible accessible) {
        edtEntity.setAccessible(dtpDate, accessible);
        edtEntity.setAccessible(bndMember, accessible);
    }
}