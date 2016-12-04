package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.HBN_MAX_RESULTS;
import static cococare.common.CCLogic.isNotEmpty;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.logp;
import static cococare.common.CCMessage.showError;
import cococare.database.CCDatabase;
import cococare.database.CCEntityModule;
import cococare.database.CCHibernate;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.CCTable;
import cococare.swing.component.CCButton;
import cococare.swing.component.CCComboBox;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTextArea;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlQueryEditorCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCDatabase database;
    private CCComboBox cmbDatabaseConfig;
    private CCButton _btnRun;
    private JTextArea txtSql;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        database = new CCDatabase();
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        for (CCHibernate hibernate : CCEntityModule.getHibernates()) {
            cmbDatabaseConfig.addItem(hibernate.getDatabaseConfig().getDatabase());
        }
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(_btnRun, alSearch);
    }

    @Override
    public void doUpdateTable() {
        int selectedIndex = cmbDatabaseConfig.getSelectedIndex();
        String sql = txtSql.getText();
        if (selectedIndex > -1 && isNotEmpty(sql)) {
            try {
                CCHibernate hibernate = CCEntityModule.getHibernates().get(selectedIndex);
                //get columnNames
                database.getConnection(hibernate.getDatabaseConfig(), false);
                ResultSet resultSet = database.executeQuery(sql, null, HBN_MAX_RESULTS);
                if (isNull(resultSet)) {
                    showError();
                    return;
                }
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                String[] columnNames = new String[resultSetMetaData.getColumnCount()];
                Integer[] columnWidths = new Integer[resultSetMetaData.getColumnCount()];
                for (int i = 0; i < columnNames.length; i++) {
                    columnNames[i] = resultSetMetaData.getColumnName(i + 1);
                    columnWidths[i] = Math.min(resultSetMetaData.getColumnDisplaySize(i + 1) * 5, 255);
                }
                //create tblEntity
                tblEntity = new CCTable(swingView.getTblEntity(), columnNames);
                tblEntity.setColumnWidth(columnWidths);
                tblEntity.removeRows();
                //add rowData
                while (resultSet.next()) {
                    Object[] rowData = new Object[resultSetMetaData.getColumnCount()];
                    for (int i = 0; i < rowData.length; i++) {
                        rowData[i] = resultSet.getObject(i + 1);
                    }
                    tblEntity.addRow(rowData);
                }
            } catch (Exception exception) {
                logp(exception.toString());
                showError();
            }
        }
    }
}