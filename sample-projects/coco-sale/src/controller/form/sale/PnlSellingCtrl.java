package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCFinal.btnAdd;
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCLogic.isNull;
import static cococare.database.CCLoginInfo.INSTANCE_isCompAccessible;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.*;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.sale.SVSelling;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class PnlSellingCtrl extends CFSwingCtrl {

    private CCBandBox bndCustomer;
    private CCButton btnCustomerAdd;
    private CCBandBox bndVoucherType;
    private JTextField txtPurchasePrice;
    private JTextField txtSalePrice;
    private JTextField txtAmountPaid;
    private CCButton btnEven;

    @Override
    protected Class _getEntity() {
        return SVSelling.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        //
        bndCustomer.getTable().initFields("name", "phone");
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
        bndVoucherType.addEventListenerOnSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateTxtVoucherType();
            }
        });
        addActionListener(btnEven, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateTxtAmountPaid();
            }
        });
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

    protected void _doUpdateTxtVoucherType() {
        SVVoucherType voucherType = (SVVoucherType) bndVoucherType.getObject();
        txtPurchasePrice.setText(formatNumber(isNull(voucherType) ? 0 : voucherType.getPurchasePrice()));
        txtSalePrice.setText(formatNumber(isNull(voucherType) ? 0 : voucherType.getSalePrice()));
    }

    protected void _doUpdateTxtAmountPaid() {
        txtAmountPaid.setText(txtSalePrice.getText());
    }
}