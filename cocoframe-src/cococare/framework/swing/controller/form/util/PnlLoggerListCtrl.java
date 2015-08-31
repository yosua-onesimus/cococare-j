package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import static cococare.common.CCFinal.FORMAT_MYSQL;
import static cococare.common.CCFormat.getString;
import cococare.database.CCHibernateFilter;
import cococare.framework.model.obj.util.UtilLogger;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.fillUp;
import javax.swing.JComboBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlLoggerListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JComboBox cmbUsername;
    private JComboBox cmbScreen;
    private JComboBox cmbAction;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return UtilLogger.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        fillUp(cmbUsername, loggerBo.getUsernames(), true);
        fillUp(cmbScreen, loggerBo.getScreens(), true);
        fillUp(cmbAction, loggerBo.getActions(), true);
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.addField(0, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Date Time";
            }

            @Override
            public Object getCustomView(Object object) {
                return getString(((UtilLogger) object).getLogCreatedOn(), FORMAT_MYSQL);
            }
        });
        tblEntity.setColumnWidth(150, 100, 100, 100, 150, 100, null);
        tblEntity.setHqlFilters(new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "username";
            }

            @Override
            public Object getFieldValue() {
                return cmbUsername.getSelectedIndex() < 1 ? null : cmbUsername.getSelectedItem();
            }
        }, new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "screen";
            }

            @Override
            public Object getFieldValue() {
                return cmbScreen.getSelectedIndex() < 1 ? null : cmbScreen.getSelectedItem();
            }
        }, new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "action";
            }

            @Override
            public Object getFieldValue() {
                return cmbAction.getSelectedIndex() < 1 ? null : cmbAction.getSelectedItem();
            }
        });
        tblEntity.setHqlOrderSyntax("id DESC");
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbUsername, alSearch);
        addListener(cmbScreen, alSearch);
        addListener(cmbAction, alSearch);
    }
}