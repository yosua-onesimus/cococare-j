package controller.form;

import cococare.common.CCLanguage;
import cococare.common.CCMessage;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import cococare.swing.CCSwing;
import cococare.swing.CCTable;
import cococare.swing.component.CCButton;
import console.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.Employee;
import view.form.FrmEmployeeList;

public class FrmEmployeeListCtrl {

    private FrmEmployeeList frmEmployeeList = new FrmEmployeeList();
    private CCButton btnAdd;
    private CCButton btnEdit;
    private CCButton btnDelete;
    private JTextField txtKeyword;
    private CCTable tblEntity = CCSwing.newCCTable(frmEmployeeList, "tblEntity", Employee.class);

    public void init() {
        CCSwing.initComponent(frmEmployeeList, this);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doAdd();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doEdit();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doDelete();
            }
        });
        tblEntity.setNaviElements(null, txtKeyword, btnEdit, btnDelete);
        tblEntity.search();
        frmEmployeeList.setVisible(true);
    }

    private void _doAdd() {
        if (new DlgEmployeeCtrl().init(new Employee())) {
            tblEntity.search();
        }
    }

    private void _doEdit() {
        if (new DlgEmployeeCtrl().init((Employee) tblEntity.getSelectedItem())) {
            tblEntity.reloadSelectedItem();
        }
    }

    private void _doDelete() {
        if (tblEntity.deleteById(tblEntity.getSelectedItem()) > -1) {
            tblEntity.search();
        } else {
            CCMessage.showError();
        }
    }

    public static void main(String[] args) {
        CCLanguage.init(true);
        Main.HIBERNATE = new CCHibernate();
        Main.HIBERNATE.addAnnotatedClass(Employee.class);
        Main.HIBERNATE.addDatabaseConfig(new CCDatabaseConfig().withPassword("1234").withDatabase("test"));
        new FrmEmployeeListCtrl().init();
    }
}