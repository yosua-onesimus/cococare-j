package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
//</editor-fold>

public class PnlEllusion1Ctrl extends CFSwingCtrl {

    //
    private int step = 0;
    private int question = 0;
    private int answer = 0;
    private Object[] aryQuestion;
    //Navi Step
    private JTabbedPane tabStep;
    private JButton btnBack;
    private JButton btnNext;
    //

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        CCSwing.addListener(btnBack, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doBack();
            }
        });
        CCSwing.addListener(btnNext, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doNext();
            }
        });
    }

    private void _doBack() {
        step--;
        if (step < 0) {
            step = 0;
        }
        _doUpdateTabStep();
    }

    private void _doNext() {
        step++;
        if (step > 2) {
            step = 2;
        }
        _doUpdateTabStep();
    }

    private void _doUpdateTabStep() {
        tabStep.setSelectedIndex(step);
        btnBack.setVisible(step > 0);
        btnNext.setVisible(step < tabStep.getTabCount() - 1);
        if (step == 2) {
        }
    }
}