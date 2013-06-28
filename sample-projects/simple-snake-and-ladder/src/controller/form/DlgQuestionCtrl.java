package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import model.mdl.SnakeAndLadderMain;
import model.obj.Enum.AutoAnswer;
import model.obj.Question;
//</editor-fold>

public class DlgQuestionCtrl extends CFSwingCtrl {

    private Question question;
    private JLabel lblQuestion;
    private JTextField txtAnswer;
    private JLabel lblTimer;
    private JButton btnEnter;
    private JLabel lblCorrectAnswer;

    @Override
    protected Class _getEntity() {
        return Question.class;
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
    protected void _initComponent() {
        super._initComponent();
        //
        question = (Question) objEntity;
        lblQuestion.setText(CCFormat.wordWrap(question.getQuestion()));
        lblTimer.setText(CCFormat.getString(SnakeAndLadderMain.gameOption.getQuestionTime()));
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int timer = CCFormat.parseInt(lblTimer.getText());
                if (timer > 0) {
                    lblTimer.setText(CCFormat.getString(--timer));
                } else {
                    AutoAnswer autoAnswer = AutoAnswer.values()[question.getAutoAnswerIndex()];
                    updateCaller = AutoAnswer.TRUE.equals(autoAnswer);
                    _doCloseScreen();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        ActionListener alEnter = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doEnter();
            }
        };
        CCSwing.addActionListener(txtAnswer, alEnter);
        CCSwing.addActionListener(btnEnter, alEnter);
    }

    protected void _doEnter() {
        updateCaller = txtAnswer.getText().equalsIgnoreCase(question.getAnswer());
        if (SnakeAndLadderMain.gameOption.getQuestionAnswerShow()) {
            lblCorrectAnswer.setText(question.getAnswer());
        }
        _doCloseScreen();
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        //
        txtAnswer.setText("");
    }
}