package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.unformatNumber;
import static cococare.common.CCMath.round;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addActionListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.bo.sale.SVConfigBo;
import model.obj.sale.SVConfig;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class PnlVoucherTypeCtrl extends CFSwingCtrl {

    private SVConfigBo configBo;
    private SVConfig config;
    private JTextField txtPurchasePrice;
    private JTextField txtSalePrice;
    private CCButton btnCalc;

    @Override
    protected Class _getEntity() {
        return SVVoucherType.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        //
        config = configBo.loadSVConfig();
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        addActionListener(btnCalc, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateTxtSalePrice();
            }
        });
    }

    protected void _doUpdateTxtSalePrice() {
        txtSalePrice.setText(formatNumber(round(unformatNumber(txtPurchasePrice.getText()) + config.getMinimalProfit(), config.getSalePriceRound())));
    }
}