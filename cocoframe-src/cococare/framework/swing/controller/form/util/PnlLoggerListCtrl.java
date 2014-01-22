package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import static cococare.common.CCFinal.FORMAT_MYSQL;
import static cococare.common.CCFormat.getString;
import cococare.database.CCHibernateFilter;
import cococare.framework.model.obj.util.UtilLogger;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addActionListener;
import static cococare.swing.CCSwing.fillUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                return "Created On";
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
                return cmbUsername.getSelectedItem();
            }
        }, new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "screen";
            }

            @Override
            public Object getFieldValue() {
                return cmbScreen.getSelectedItem();
            }
        }, new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return "action";
            }

            @Override
            public Object getFieldValue() {
                return cmbAction.getSelectedItem();
            }
        });
        tblEntity.setHqlOrderSyntax("id DESC");
    }

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alSearch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSearch();
            }
        };
        addActionListener(cmbUsername, alSearch);
        addActionListener(cmbScreen, alSearch);
        addActionListener(cmbAction, alSearch);
    }
}