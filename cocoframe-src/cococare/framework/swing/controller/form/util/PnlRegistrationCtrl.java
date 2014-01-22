package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getValue;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.CompareRule;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCFormat.getString;
import static cococare.common.CCFormat.getStringOrBlank;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCMessage.showInformation;
import static cococare.framework.common.CFApplCtrl.LICENSE;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCEditor;
import static cococare.swing.CCEditor.requestFocusInWindow;
import static cococare.swing.CCSwing.addActionListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlRegistrationCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //if hasRegister then user may re-register..
    private boolean hasRegister = LICENSE.hasRegister();
    private CCButton btnRegister;
    private JTextField txtLock;
    private JTextField txtRegTo;
    private JTextField txtPass;
    private JTextField txtRunFirst;
    private JTextField txtRunTime;
    private JTextField txtMaxData;
    private JTextField txtRunLast;
    private JTextField txtRunUntil;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initEditor() {
        edtEntity = new CCEditor(getContainer());
        edtEntity.reg(null, null, txtLock, Accessible.READONLY, Type.TEXT, 0, null, CompareRule.NONE, null);
        edtEntity.reg("Register To", "Register To", txtRegTo, hasRegister ? Accessible.MANDATORY : Accessible.MANDATORY, Type.TEXT, 0, null, CompareRule.NONE, null);
        edtEntity.reg("Pass", "Pass", txtPass, hasRegister ? Accessible.MANDATORY : Accessible.MANDATORY, Type.TEXT, 0, null, CompareRule.NONE, null);
        edtEntity.reg(null, null, txtRunFirst, Accessible.READONLY, Type.TEXT, 0, null, CompareRule.NONE, null);
        edtEntity.reg(null, null, txtRunTime, Accessible.READONLY, Type.NUMERIC, 0, null, CompareRule.NONE, null);
        edtEntity.reg(null, null, txtMaxData, Accessible.READONLY, Type.NUMERIC, 0, null, CompareRule.NONE, null);
        edtEntity.reg(null, null, txtRunLast, Accessible.READONLY, Type.TEXT, 0, null, CompareRule.NONE, null);
        edtEntity.reg(null, null, txtRunUntil, Accessible.READONLY, Type.TEXT, 0, null, CompareRule.NONE, null);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        if (hasRegister) {
            addActionListener(btnRegister, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _doRegister();
                }
            });
        } else {
            addActionListener(btnRegister, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _doRegister();
                }
            });
        }
    }

    private void _doRegister() {
        if (edtEntity.isValueValid()) {
            if (hasRegister = LICENSE.register(txtRegTo.getText(), txtPass.getText())) {
                _doUpdateEditor();
            }
            showInformation(turn(hasRegister ? Registration_success : Invalid_serial_number));
        }
    }

    @Override
    protected void _doUpdateEditor() {
        txtLock.setText(getString(getValue(LICENSE, "applLock")));
        txtRegTo.setText(getString(getValue(LICENSE, "applRegTo")));
        txtPass.setText(getStringOrBlank(getValue(LICENSE, "applPass")));
        txtRunFirst.setText(getString(getValue(LICENSE, "runFirst")));
        txtRunTime.setText(getString(getValue(LICENSE, "runTime")));
        txtMaxData.setText(getStringOrBlank(getValue(LICENSE, "maxData")));
        txtRunLast.setText(getString(getValue(LICENSE, "runLast")));
        txtRunUntil.setText(getStringOrBlank(getValue(LICENSE, "runUntil")));
        if (hasRegister) {
        } else {
            requestFocusInWindow(txtRegTo);
        }
    }
}