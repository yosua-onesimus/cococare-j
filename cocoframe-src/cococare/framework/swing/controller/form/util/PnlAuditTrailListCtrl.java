package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getLabel;
import cococare.common.CCCustomField;
import cococare.database.CCEntityModule;
import cococare.database.CCHibernateFilter;
import cococare.database.model.obj.cc.CCAuditData;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlAuditTrailListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCComboBox cmbEntity;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return CCAuditData.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected String _getSysRef(Object objEntity) {
        return ((CCAuditData) objEntity).getSysRef();
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        cmbEntity.addItem("");
        for (Class clazz : CCEntityModule.INSTANCE.getCCHibernate().getAuditableClasses()) {
            cmbEntity.addItem(getLabel(clazz));
        }
    }

    @Override
    protected void _initTable() {
        super._initTable();
        int column = 0;
        tblEntity.addField(column++, new CCCustomField() {
            @Override
            public Object getCustomView(Object object) {
                return ((CCAuditData) object).getLabel();
            }
        });
        tblEntity.addField(column++, new CCCustomField() {
            @Override
            public Object getCustomView(Object object) {
                return ((CCAuditData) object).getProcessType().toString();
            }
        });
        tblEntity.addField(column++, new CCCustomField() {
            @Override
            public Object getCustomView(Object object) {
                return ((CCAuditData) object).getCreator();
            }
        });
        tblEntity.addField(column++, new CCCustomField() {
            @Override
            public Object getCustomView(Object object) {
                return ((CCAuditData) object).getApprover();
            }
        });
        tblEntity.setColumnLabel("Class Name", "Process", "Creator", "Approver");
        tblEntity.setColumnWidth(80, 80, 180, 180, 60);
        tblEntity.setHqlFilters(new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "className";
            }

            @Override
            public Object getFieldValue() {
                if (cmbEntity.getSelectedIndex() > 0) {
                    return CCEntityModule.INSTANCE.getCCHibernate().getAuditableClasses().get(cmbEntity.getSelectedIndex() - 1).getName();
                } else {
                    return null;
                }
            }
        });
        tblEntity.setHqlOrderSyntax("id DESC");
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbEntity, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSearch();
            }
        });
    }
}