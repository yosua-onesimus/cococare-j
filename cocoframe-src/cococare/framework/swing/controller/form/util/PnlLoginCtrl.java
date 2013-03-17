package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCMessage.showError;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.framework.swing.CFSwingMap.getMainScreen;
import cococare.swing.CCHotkey;
import static cococare.swing.CCSwing.addActionListener;
import static cococare.swing.CCSwing.getJButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlLoginCtrl extends CFSwingCtrl {

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
        CCHotkey hotkey = new CCHotkey(getMainScreen());
        hotkey.add(KeyEvent.VK_ENTER, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                _doLogin();
            }
        }, getJButton(getContainer(), "btnLogin"));
        addActionListener(getJButton(getContainer(), "btnExit"), new ActionListener() {

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