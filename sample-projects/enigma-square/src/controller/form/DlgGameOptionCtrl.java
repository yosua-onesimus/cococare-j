package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFormat;
import cococare.common.CCLogic;
import cococare.datafile.CCFile;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.component.CCImage;
import java.awt.event.*;
import java.io.File;
import java.util.List;
import javax.swing.*;
import static model.mdl.EnigmaSquareMain.*;
import model.obj.GameOption;
import model.obj.Player;
//</editor-fold>

public class DlgGameOptionCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JCheckBox chkQuestionShow;
    private JComboBox cmbQuestionOrder;
    private JTextField txtQuestionNumber;
    private JTextField txtQuestionTime;
    //
    private JTextField txtPlayerNumber;
    //
    private JButton btnStart;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return GameOption.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.DIALOG_MODE;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = gameOption;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addListener(chkQuestionShow, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateAccessibleQuestion();
            }
        });
        txtQuestionNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                _doUpdateTxtQuestionNumber();
            }
        });
        txtQuestionTime.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                _doUpdateTxtQuestionTime();
            }
        });
        //
        txtPlayerNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                _doUpdateAccessiblePlayer();
            }
        });
        //
        MouseListener mlIcon = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getComponent().isEnabled()) {
                    File file = CCFile.showOpenDialog(CCFile.getFileSystArchFile(""), JFileChooser.FILES_ONLY, "png");
                    if (CCLogic.isNotNull(file)) {
                        ((CCImage) mouseEvent.getComponent()).setIcon(cococare.datafile.CCImage.getByteA(file));
                        getContainer().repaint();
                    }
                }
            }
        };
        for (int i = 1; i < 6; i++) {
            CCSwing.getComponent(getContainer(), "imgIcon" + (i)).addMouseListener(mlIcon);
        }
        //
        CCSwing.addListener(btnStart, alSave);
    }

    @Override
    protected void _doSave() {
        if (_isValueValid()) {
            _getValueFromEditor();
            //
            List<Player> players = gameOption.getPlayers();
            for (int i = 0; i < 5; i++) {
                players.get(i).setIcon(((CCImage) CCSwing.getComponent(getContainer(), "imgIcon" + (i + 1))).getByteA());
                players.get(i).setName(((JTextField) CCSwing.getComponent(getContainer(), "txtName" + (i + 1))).getText());
            }
            //
            if (updateCaller = saveGameOption()) {
                _doCloseScreen();
            } else {
                _showSaved(updateCaller);
            }
        }
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        //
        _doUpdateAccessibleQuestion();
        _doUpdateAccessiblePlayer();
        //
        _doUpdateTxtQuestionNumber();
        _doUpdateTxtQuestionTime();
        _doUpdateEditorPlayer();
    }

    protected void _doUpdateAccessibleQuestion() {
        boolean enabled = chkQuestionShow.isSelected();
        edtEntity.setAccessible(cmbQuestionOrder, enabled ? Accessible.MANDATORY : Accessible.MANDATORY_READONLY);
        edtEntity.setAccessible(txtQuestionNumber, enabled ? Accessible.MANDATORY : Accessible.MANDATORY_READONLY);
        edtEntity.setAccessible(txtQuestionTime, enabled ? Accessible.MANDATORY : Accessible.MANDATORY_READONLY);
    }

    protected void _doUpdateAccessiblePlayer() {
        int playerNumber = CCFormat.parseInt(txtPlayerNumber.getText());
        playerNumber = Math.max(Math.min(playerNumber, 5), 2);
        txtPlayerNumber.setText(CCFormat.getString(playerNumber));
        //
        for (int i = 1; i < 6; i++) {
            CCSwing.getComponent(getContainer(), "imgIcon" + (i)).setEnabled(playerNumber >= i);
            CCSwing.getComponent(getContainer(), "txtName" + (i)).setEnabled(playerNumber >= i);
        }
    }

    protected void _doUpdateTxtQuestionNumber() {
        int questionNumber = CCFormat.parseInt(txtQuestionNumber.getText());
        questionNumber = Math.max(Math.min(questionNumber, Math.min(questions.size(), 25)), 0);
        txtQuestionNumber.setText(CCFormat.getString(questionNumber));
    }

    protected void _doUpdateTxtQuestionTime() {
        int questionTime = CCFormat.parseInt(txtQuestionTime.getText());
        questionTime = Math.max(Math.min(questionTime, 60), 5);
        txtQuestionTime.setText(CCFormat.getString(questionTime));
    }

    protected void _doUpdateEditorPlayer() {
        List<Player> players = gameOption.getPlayers();
        for (int i = 0; i < 5; i++) {
            ((CCImage) CCSwing.getComponent(getContainer(), "imgIcon" + (i + 1))).setIcon(players.get(i).getIcon());
            ((JTextField) CCSwing.getComponent(getContainer(), "txtName" + (i + 1))).setText(players.get(i).getName());
        }
    }
}