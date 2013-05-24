package controller.form;

import cococare.common.CCMessage;
import cococare.swing.CCEditor;
import cococare.swing.CCSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.obj.Employee;
import view.form.DlgEmployee;

public class DlgEmployeeCtrl {

    private boolean success = false;
    private DlgEmployee dlgEmployee = new DlgEmployee(null, true);
    private JButton btnSave;
    private JButton btnClose;
    private CCEditor edtEntity = new CCEditor(dlgEmployee, Employee.class);

    public boolean init(Employee employee) {
        CCSwing.initComponent(dlgEmployee, this);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSave();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doClose();
            }
        });
        edtEntity.setValueToEditor(employee);
        dlgEmployee.setVisible(true);
        return success;
    }

    private void _doSave() {
        if (edtEntity.isValueValid()) {
            if (success = edtEntity.saveOrUpdate(edtEntity.getValueFromEditor())) {
                _doClose();
            } else {
                CCMessage.showError();
            }
        }
    }

    private void _doClose() {
        dlgEmployee.dispose();
    }
}