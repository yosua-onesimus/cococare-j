package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import model.mdl.TebakAngkaMain;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.07.20
 * @version 13.07.20
 */
public class PnlAnswerCtrl extends CFSwingCtrl {

    private JLabel lblAnswer;
    private CCButton btnTryAgain;

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        //
        lblAnswer.setText(CCFormat.getString(TebakAngkaMain.ANSWER));
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addActionListener(btnTryAgain, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doShowIntro();
            }
        });
    }

    protected void _doShowIntro() {
        new PnlIntroCtrl().init();
    }
}