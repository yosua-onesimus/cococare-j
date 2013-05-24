package controller.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.dao.EmployeeDao;
import model.obj.Employee;
import view.form.DlgEmployee;

public class DlgEmployeeCtrl {

    private EmployeeDao employeeDao = new EmployeeDao();
    private Employee employee;
    private boolean success = false;
    private DlgEmployee dlgEmployee = new DlgEmployee(null, true);

    public boolean init(Employee employee) {
        this.employee = employee;
        dlgEmployee.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSave();
            }
        });
        dlgEmployee.getBtnClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doClose();
            }
        });
        dlgEmployee.getTxtCode().setText(employee.getCode());
        dlgEmployee.getTxtName().setText(employee.getName());
        dlgEmployee.setVisible(true);
        return success;
    }

    private void _doSave() {
        employee.setCode(dlgEmployee.getTxtCode().getText());
        employee.setName(dlgEmployee.getTxtName().getText());
        if (success = employeeDao.saveOrUpdate(employee)) {
            _doClose();
        } else {
            System.out.println("ERROR!");
        }
    }

    private void _doClose() {
        dlgEmployee.dispose();
    }
}