package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCFinal.btnAdd;
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.unformatNumber;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.showSaved;
import static cococare.database.CCLoginInfo.INSTANCE_isCompAccessible;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.*;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.bo.sale.SVConfigBo;
import model.obj.sale.SCustomer;
import model.obj.sale.SVConfig;
import model.obj.sale.SVSelling;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class PnlSellingCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private SVConfigBo configBo;
    private SVConfig config;
    private JLabel lblFormatVoucherSelling;
    private CCBandBox bndCustomer;
    private CCButton btnCustomerAdd;
    private CCBandBox bndVoucherType;
    private JTextField txtPurchasePrice;
    private CCButton btnVoucherTypeUpdate;
    private JTextField txtSalePrice;
    private JTextField txtAmountPaid;
    private CCButton btnEven;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return SVSelling.class;
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
    protected void _initEditor() {
        super._initEditor();
        //
        bndCustomer.getTable().initFields("name", "phone");
        bndVoucherType.getTable().setHqlOrderSyntax("operator.id ASC, purchasePrice ASC");
    }

    @Override
    protected void _initAccessible() {
        super._initAccessible();
        //
        if (!INSTANCE_isCompAccessible(PnlCustomerListCtrl.class.getName() + "." + btnAdd)) {
            addAccessibleListener(btnCustomerAdd, CCAccessibleListener.nonAccessible);
        }
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        //
        applyAccessible(btnCustomerAdd);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        addActionListener(btnCustomerAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doCustomerAdd();
            }
        });
        bndCustomer.addEventListenerOnSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateLblFormatVoucherSelling();
            }
        });
        bndVoucherType.addEventListenerOnSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateLblFormatVoucherSelling();
                _doUpdateTxtVoucherType();
            }
        });
        addActionListener(btnVoucherTypeUpdate, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateVoucherType();
            }
        });
        addActionListener(btnEven, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateTxtAmountPaid();
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && configBo.recalculateSaldoProfit();
    }

    protected void _doCustomerAdd() {
        new PnlCustomerCtrl().with(callerCtrl).init();
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        //
        _doUpdateTxtVoucherType();
    }

    protected void _doUpdateLblFormatVoucherSelling() {
        String formatVoucherSelling = config.getFormatVoucherSelling();
        if (isNotNull(bndCustomer.getObject()) && isNotNull(bndVoucherType.getObject())) {
            formatVoucherSelling = formatVoucherSelling.replaceFirst("NOMINAL", ((SVVoucherType) bndVoucherType.getObject()).getNominal());
            formatVoucherSelling = formatVoucherSelling.replaceFirst("PHONE", ((SCustomer) bndCustomer.getObject()).getPhone());
            formatVoucherSelling = formatVoucherSelling.replaceFirst("PIN", config.getPin());
        }
        lblFormatVoucherSelling.setText(formatVoucherSelling);
    }

    protected void _doUpdateTxtVoucherType() {
        if (newEntity) {
            SVVoucherType voucherType = (SVVoucherType) bndVoucherType.getObject();
            txtPurchasePrice.setText(formatNumber(isNull(voucherType) ? 0 : voucherType.getPurchasePrice()));
            txtSalePrice.setText(formatNumber(isNull(voucherType) ? 0 : voucherType.getSalePrice()));
        }
    }

    protected void _doUpdateVoucherType() {
        SVVoucherType voucherType = (SVVoucherType) bndVoucherType.getObject();
        voucherType.setPurchasePrice(unformatNumber(txtPurchasePrice.getText()));
        showSaved(edtEntity.saveOrUpdate(voucherType));
    }

    protected void _doUpdateTxtAmountPaid() {
        txtAmountPaid.setText(txtSalePrice.getText());
    }
}