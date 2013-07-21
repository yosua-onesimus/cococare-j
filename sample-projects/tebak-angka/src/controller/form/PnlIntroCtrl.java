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
public class PnlIntroCtrl extends CFSwingCtrl {

    private CCButton btnStart;

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
        CCSwing.addActionListener(btnStart, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doStart();
            }
        });
    }

    protected void _doStart() {
        TebakAngkaMain.ANSWER = 0;
        new PnlQuestion1Ctrl().init();
    }
}