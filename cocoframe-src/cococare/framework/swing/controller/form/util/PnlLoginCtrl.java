package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCMessage.showError;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlLoginCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JButton btnExit;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return UtilUser.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    public boolean init() {
        CFApplCtrl.INSTANCE.logout();
        return super.init();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doLogin();
            }
        };
        txtUsername.addActionListener(alLogin);
        txtPassword.addActionListener(alLogin);
        btnLogin.addActionListener(alLogin);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CFApplCtrl.INSTANCE.end();
            }
        });
    }

    protected void _doLogin() {
        if (_hasEdtEntity()) {
            if (_isValueValid()) {
                _getValueFromEditor();
                UtilUser user = (UtilUser) objEntity;
                if (updateCaller = CFApplCtrl.INSTANCE.login(user.getUsername(), user.getPassword())) {
                    _logger(objEntity);
                    _doCloseScreen();
                } else {
                    showError();
                }
            }
        }
    }
}