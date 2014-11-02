package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.mdl.TebakAngkaMain;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.07.20
 * @version 13.07.20
 */
public class PnlQuestion1Ctrl extends CFSwingCtrl {

    private CCButton btnYes;
    private CCButton btnNo;

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addListener(btnYes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doShowNextQuestion(true);
            }
        });
        CCSwing.addListener(btnNo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doShowNextQuestion(false);
            }
        });
    }

    protected void _doShowNextQuestion(boolean yes) {
        if (yes) {
            TebakAngkaMain.ANSWER += 1;
        }
        new PnlQuestion2Ctrl().init();
    }
}