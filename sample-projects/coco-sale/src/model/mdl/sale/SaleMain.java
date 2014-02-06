package model.mdl.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingMain;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
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
    public boolean initInitialData() {
        CFSwingUae uae = new CFSwingUae();
        uae.reg(Sale, Customer, PnlCustomerListCtrl.class);
        uae.reg(Sale, Operator, PnlOperatorListCtrl.class);
        uae.reg(Sale, Voucher_Type, PnlVoucherTypeListCtrl.class);
        uae.reg(Sale, Deposit, PnlDepositListCtrl.class);
        uae.reg(Sale, Selling, PnlSellingListCtrl.class);
        uae.reg(Sale, Config, PnlConfigCtrl.class);
        return _initInitialDataUaeUtility(uae).compile() && new SVInitInitialDataBo().initFirstData();
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae uae = new CFSwingUae();
        uae.initMenuBar(MenuPosition.LEFT_SIDE.equals(MENU_POST) ? getMenubarV() : getMenubarH());
        uae.addMenuRoot(PnlLoginCtrl.class, PnlHomeCtrl.class);
        uae.addMenuParent(Home, null, PnlHomeCtrl.class);
        uae.addMenuParent(Customer, null, PnlCustomerListCtrl.class);
        uae.addMenuParent(Voucher, null, null);
        uae.addMenuChild(Operator, null, PnlOperatorListCtrl.class);
        uae.addMenuChild(Voucher_Type, null, PnlVoucherTypeListCtrl.class);
        uae.addMenuChild(Deposit, null, PnlDepositListCtrl.class);
        uae.addMenuChild(Selling, null, PnlSellingListCtrl.class);
        uae.addMenuChild(Config, null, PnlConfigCtrl.class);
        uae.changeMenuSide();
        _applyUserConfigUaeUtility(uae).compileMenu();
        getMainScreen().validate();
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