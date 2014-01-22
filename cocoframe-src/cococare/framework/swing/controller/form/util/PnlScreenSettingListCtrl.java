package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateFilter;
import cococare.database.model.bo.cc.CCCustomFieldConfigBo;
import cococare.database.model.obj.cc.CCCustomFieldConfig;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addActionListener;
import cococare.swing.component.CCComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlScreenSettingListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCCustomFieldConfigBo customFieldConfigBo;
    private CCComboBox cmbEntity;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return CCCustomFieldConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        cmbEntity.initList(null, CCCustomFieldConfig.class, "entityName");
        cmbEntity.setList(customFieldConfigBo.getListDistinctEntity());
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setHqlFilters(new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "entity";
            }

            @Override
            public Object getFieldValue() {
                return ((CCCustomFieldConfig) cmbEntity.getSelectedObject()).getEntity();
            }
        });
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addActionListener(cmbEntity, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSearch();
            }
        });
    }
}