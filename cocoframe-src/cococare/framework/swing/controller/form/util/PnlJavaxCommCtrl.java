package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCMessage.*;
import static cococare.common.comm.CCComm.*;
import static cococare.common.jasperreports.CCJasper.getBellFile;
import static cococare.common.jasperreports.CCJasper.printTextFile;
import static cococare.datafile.CCFile.showOpenDialog;
import cococare.datafile.CCSetup;
import static cococare.datafile.CCSystem.ENTER;
import static cococare.datafile.CCSystem.JAVA_HOME;
import cococare.framework.model.obj.util.UtilJavaxComm;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlJavaxCommCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    private JTextField txtJavaHome;
    private JTextField txtJavaHomeBin;
    private JTextField txtJavaHomeLib;
    private CCButton btnBrowseJavaHome;
    private CCButton btnBrowseJavaHomeBin;
    private CCButton btnBrowseJavaHomeLib;
    private CCButton btnCopy;
    //
    private JComboBox cmbPort;
    private JComboBox cmbAscii;
    private JTextField txtText1;
    private JTextField txtText2;
    private CCButton btnAscii2Port;
    private CCButton btnText2Display;
    private CCButton btnText2Port;
    private CCButton btnOpenDrawer1;
    private CCButton btnOpenDrawer2;
    private CCButton btnOpenDrawer3;
    private CCButton btnOpenDrawer4;
//</editor-fold>

    @Override
    protected Class _getClass() {
        return PnlJavaxCommCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return UtilJavaxComm.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(btnBrowseJavaHome, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doBrowseJavaHome();
            }
        });
        addListener(btnBrowseJavaHomeBin, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doBrowseJavaHomeBin();
            }
        });
        addListener(btnBrowseJavaHomeLib, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doBrowseJavaHomeLib();
            }
        });
        addListener(btnCopy, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doCopy();
            }
        });
        addListener(btnAscii2Port, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doAscii2Port();
            }
        });
        addListener(btnText2Display, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doText2Display();
            }
        });
        addListener(btnText2Port, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doText2Port();
            }
        });
        addListener(btnOpenDrawer1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doOpenDrawer1();
            }
        });
        addListener(btnOpenDrawer2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doOpenDrawer2();
            }
        });
        addListener(btnOpenDrawer3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doOpenDrawer3();
            }
        });
        addListener(btnOpenDrawer4, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doOpenDrawer4();
            }
        });
    }

    private void _doBrowseJavaHome() {
        File file = showOpenDialog(new File(txtJavaHome.getText()), JFileChooser.DIRECTORIES_ONLY);
        if (isNotNull(file)) {
            _doUpdateJavaHome(file.getPath());
        }
    }

    private void _doBrowseJavaHomeBin() {
        File file = showOpenDialog(new File(txtJavaHomeBin.getText()), JFileChooser.DIRECTORIES_ONLY);
        if (isNotNull(file)) {
            txtJavaHomeBin.setText(file.getPath());
        }
    }

    private void _doBrowseJavaHomeLib() {
        File file = showOpenDialog(new File(txtJavaHomeLib.getText()), JFileChooser.DIRECTORIES_ONLY);
        if (isNotNull(file)) {
            txtJavaHomeLib.setText(file.getPath());
        }
    }

    private void _doCopy() {
        CCSetup setup = new CCSetup(getClass());
        setup.addSetupMap("win32com.dll", txtJavaHomeBin.getText());
        setup.addSetupMap("comm.jar", txtJavaHomeLib.getText());
        setup.addSetupMap("javax.comm.properties", txtJavaHomeLib.getText());
        showInformation("Setup " + (setup.execute() ? "success!" : ("failed!" + ENTER + getErrorMessage())));
    }

    private void _doAscii2Port() {
        if (!writeWordToPort(
                String.valueOf((char) cmbAscii.getSelectedIndex()),
                cmbPort.getSelectedItem().toString())) {
            showError();
        }
    }

    private void _doText2Display() {
        if (!showWordToPoleDisplay(
                txtText1.getText(),
                txtText2.getText(),
                cmbPort.getSelectedItem().toString())) {
            showError();
        }
    }

    private void _doText2Port() {
        if (!writeWordToPort(
                txtText1.getText() + ENTER + txtText2.getText(),
                cmbPort.getSelectedItem().toString())) {
            showError();
        }
    }

    private void _doOpenDrawer1() {
        openCashDrawer(cmbPort.getSelectedItem().toString());
    }

    private void _doOpenDrawer2() {
        printTextFile(getBellFile());
    }

    private void _doOpenDrawer3() {
        writeWordToPort(
                String.valueOf(((char) 27) + ((char) 112) + ((char) 0) + ((char) 50) + ((char) 250)),
                cmbPort.getSelectedItem().toString());
    }

    private void _doOpenDrawer4() {
        writeWordToPort(String.valueOf((char) 27), cmbPort.getSelectedItem().toString());
        writeWordToPort(String.valueOf((char) 112), cmbPort.getSelectedItem().toString());
        writeWordToPort(String.valueOf((char) 0), cmbPort.getSelectedItem().toString());
        writeWordToPort(String.valueOf((char) 50), cmbPort.getSelectedItem().toString());
        writeWordToPort(String.valueOf((char) 250), cmbPort.getSelectedItem().toString());
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        _doUpdateJavaHome(JAVA_HOME);
        for (String port : getSerialPorts()) {
            cmbPort.addItem(port);
        }
        for (int i = 0; i < 128; i++) {
            cmbAscii.addItem(i);
        }
    }

    private void _doUpdateJavaHome(String javaHome) {
        txtJavaHome.setText(javaHome);
        txtJavaHomeBin.setText(new File(javaHome, "bin").getPath());
        txtJavaHomeLib.setText(new File(javaHome, "lib").getPath());
    }

    @Override
    protected String _getTabTitle() {
        return _getEntityLabel();
    }
}