package controller.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.dao.EmployeeDao;
import model.obj.Employee;
import view.form.FrmEmployeeList;

public class FrmEmployeeListCtrl {

    private EmployeeDao employeeDao = new EmployeeDao();
    private List<Employee> employees;
    private FrmEmployeeList frmEmployeeList = new FrmEmployeeList();
    private DefaultTableModel customTableModel = new DefaultTableModel(null, new String[]{"Code", "Name"});

    public void init() {
        frmEmployeeList.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doAdd();
            }
        });
        frmEmployeeList.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doEdit();
            }
        });
        frmEmployeeList.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doDelete();
            }
        });
        frmEmployeeList.getTxtKeyword().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                _doSearch();
            }
        });
        frmEmployeeList.getTblEntity().setModel(customTableModel);
        _doSearch();
        frmEmployeeList.setVisible(true);
    }

    private void _doSearch() {
        customTableModel.setRowCount(0);
        employees = employeeDao.getList();
        for (Employee employee : employees) {
            customTableModel.addRow(new String[]{employee.getCode(), employee.getName()});
        }
    }

    private void _doAdd() {
        if (new DlgEmployeeCtrl().init(new Employee())) {
            _doSearch();
        }
    }

    private void _doEdit() {
        if (frmEmployeeList.getTblEntity().getSelectedRow() > -1 && new DlgEmployeeCtrl().init(employees.get(frmEmployeeList.getTblEntity().getSelectedRow()))) {
            _doSearch();
        }
    }

    private void _doDelete() {
        if (frmEmployeeList.getTblEntity().getSelectedRow() > -1) {
            if (employeeDao.delete(employees.get(frmEmployeeList.getTblEntity().getSelectedRow()))) {
                _doSearch();
            } else {
                System.out.println("ERROR!");
            }
        }
    }

    public static void main(String[] args) {
        new FrmEmployeeListCtrl().init();
    }
}