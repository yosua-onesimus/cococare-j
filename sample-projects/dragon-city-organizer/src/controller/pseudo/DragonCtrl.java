package controller.pseudo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.unformatNumber;
import cococare.framework.swing.controller.form.util.PnlParameterCtrl;
import static cococare.swing.CCSwing.addListener2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.bo.DragonBo;
//</editor-fold>

public class DragonCtrl extends PnlParameterCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private DragonBo dragonBo;
    private JTextField txtRevenues;
    private JTextField txtRevenuesPercent;
    private JTextField txtRevenuesTotal;
//</editor-fold>

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alUpdateTxtRevenuesTotal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTxtRevenuesTotal();
            }
        };
        addListener2(txtRevenues, alUpdateTxtRevenuesTotal);
        addListener2(txtRevenuesPercent, alUpdateTxtRevenuesTotal);
    }

    private void _doUpdateTxtRevenuesTotal() {
        txtRevenuesTotal.setText(
                formatNumber(dragonBo.countRevenuesTotal(
                unformatNumber(txtRevenues.getText()),
                unformatNumber(txtRevenuesPercent.getText()))));
    }
}