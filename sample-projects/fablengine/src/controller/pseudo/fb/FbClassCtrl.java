package controller.pseudo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.*;
import cococare.framework.swing.controller.form.util.PnlParameterCtrl;
import static cococare.swing.CCSwing.addListener2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
//</editor-fold>

public class FbClassCtrl extends PnlParameterCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JTextField txtHp;
    private JTextField txtAp;
    private JTextField txtOffense;
    private JTextField txtDefense;
    private JTextField txtEssence;
    private JTextField txtVelense;
    private JTextField txtBalance;
    private JTextField txtCrtRate;
//</editor-fold>

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alUpdateTxtBalance = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTxtBalance();
            }
        };
        addListener2(txtHp, alUpdateTxtBalance);
        addListener2(txtAp, alUpdateTxtBalance);
        addListener2(txtOffense, alUpdateTxtBalance);
        addListener2(txtDefense, alUpdateTxtBalance);
        addListener2(txtEssence, alUpdateTxtBalance);
        addListener2(txtVelense, alUpdateTxtBalance);
    }

    private void _doUpdateTxtBalance() {
        txtBalance.setText(formatNumeric(
                (parseInt(txtHp.getText()) / 10)
                + parseInt(txtAp.getText())
                + parseInt(txtOffense.getText())
                + parseInt(txtDefense.getText())
                + parseInt(txtEssence.getText())
                + parseInt(txtVelense.getText())));
        txtCrtRate.setText(formatDecimal(
                (parseInt(txtOffense.getText()) - 2) * 10));
    }
}