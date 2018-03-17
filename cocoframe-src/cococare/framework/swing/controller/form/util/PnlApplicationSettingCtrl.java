package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig.Accessible;
import cococare.database.CCEntity;
import static cococare.datafile.CCFile.writeObject;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.model.obj.util.UtilConfServ;
import cococare.framework.model.obj.util.UtilConfServ.MailProtocol;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import static cococare.swing.CCSwing.addListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationSettingCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigBo configBo;
    //
    private JCheckBox txtFileTransferEnable;
    private JTextField txtFileTransferHostname;
    private JTextField txtFileTransferPort;
    private JTextField txtFileTransferUsername;
    private JTextField txtFileTransferPassword;
    //
    private JCheckBox txtMailSendMailEnable;
    private JComboBox txtMailProtocol;
    private JTextField txtMailMailSmtpHost;
    private JTextField txtMailGmailUsername;
    private JTextField txtMailGmailPassword;
//</editor-fold>

    @Override
    protected void _initListener() {
        super._initListener();
        if (objEntity instanceof UtilConfServ) {
            ActionListener alUpdateAccessible = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doUpdateAccessible(actionEvent.getSource());
                }
            };
            addListener(txtFileTransferEnable, alUpdateAccessible);
            addListener(txtMailSendMailEnable, alUpdateAccessible);
            addListener(txtMailProtocol, alUpdateAccessible);
        }
    }

    private void _doUpdateAccessible(Object object) {
        if (object.equals(txtFileTransferEnable)) {
            Accessible accessible = txtFileTransferEnable.isSelected() ? Accessible.MANDATORY : Accessible.NORMAL;
            edtEntity.setAccessible(txtFileTransferHostname, accessible);
            edtEntity.setAccessible(txtFileTransferPort, accessible);
            edtEntity.setAccessible(txtFileTransferUsername, accessible);
            edtEntity.setAccessible(txtFileTransferPassword, accessible);
        } else if (object.equals(txtMailSendMailEnable)
                || object.equals(txtMailProtocol)) {
            boolean mandatory = txtMailSendMailEnable.isSelected();
            Accessible accessible = mandatory ? Accessible.MANDATORY : Accessible.NORMAL;
            edtEntity.setAccessible(txtMailProtocol, accessible);
            int selectedIndex = txtMailProtocol.getSelectedIndex();
            Accessible accessibleHost = mandatory && selectedIndex == MailProtocol.SMTP_HOST.ordinal() ? Accessible.MANDATORY : Accessible.NORMAL;
            Accessible accessibleGmail = mandatory && selectedIndex == MailProtocol.SMTP_GMAIL.ordinal() ? Accessible.MANDATORY : Accessible.NORMAL;
            edtEntity.setAccessible(txtMailMailSmtpHost, accessibleHost);
            edtEntity.setAccessible(txtMailGmailUsername, accessibleGmail);
            edtEntity.setAccessible(txtMailGmailPassword, accessibleGmail);
        }
    }

    @Override
    protected boolean _doSaveEntity() {
        if (updateCaller = configBo.saveConf(objEntity)) {
            if (objEntity instanceof UtilConfAppl) {
                updateCaller = writeObject((CCEntity) objEntity, CFApplCtrl.FILE_APPL_CONF);
            }
            if ((objEntity instanceof UtilConfAppl) || (objEntity instanceof UtilConfServ)) {
                CFApplCtrl.INSTANCE.updateNonContent(objEntity);
            }
        }
        return updateCaller;
    }

    @Override
    protected String _getTabTitle() {
        return _getEntityLabel();
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        if (objEntity instanceof UtilConfServ) {
            _doUpdateAccessible(txtFileTransferEnable);
            _doUpdateAccessible(txtMailSendMailEnable);
        }
    }
}