package model.mdl.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import controller.form.sale.*;
import model.bo.sale.SVInitInitialDataBo;
import static model.mdl.sale.SaleLanguage.*;
//</editor-fold>

public class SaleMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "cccr-sl-vchr-pprl";
        APPL_NAME = "Coco Sale ~ Voucher and Apparel";
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        init(false, SaleLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        SaleModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected boolean _initInitialData() {
        return super._initInitialData() && new SVInitInitialDataBo().initFirstData();
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(Sale, Customer, PnlCustomerListCtrl.class);
        uae.reg(Sale, Operator, PnlOperatorListCtrl.class);
        uae.reg(Sale, Voucher_Type, PnlVoucherTypeListCtrl.class);
        uae.reg(Sale, Deposit, PnlDepositListCtrl.class);
        uae.reg(Sale, Selling, PnlSellingListCtrl.class);
        uae.reg(Sale, Config, PnlConfigCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent(Home, null, PnlHomeCtrl.class);
        uae.addMenuParent(Customer, null, PnlCustomerListCtrl.class);
        uae.addMenuParent(Voucher, null, null);
        uae.addMenuChild(Operator, null, PnlOperatorListCtrl.class);
        uae.addMenuChild(Voucher_Type, null, PnlVoucherTypeListCtrl.class);
        uae.addMenuChild(Deposit, null, PnlDepositListCtrl.class);
        uae.addMenuChild(Selling, null, PnlSellingListCtrl.class);
        uae.addMenuChild(Config, null, PnlConfigCtrl.class);
    }

    @Override
    protected boolean _showHomeScreen() {
        return new PnlHomeCtrl().init();
    }

    public static void main(String[] args) {
        new SaleMain().showScreen();
        //SaleRepair.repairName();//repair customer name
        //SaleRepair.repairPhone1();//repair customer phone
        //SaleRepair.repairPhone2();//repair customer phone
        //SaleRepair.repairCustomer();
    }
}