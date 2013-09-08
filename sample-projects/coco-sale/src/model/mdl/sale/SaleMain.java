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
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg(Sale, Customer, PnlCustomerListCtrl.class);
        swingUae.reg(Sale, Operator, PnlOperatorListCtrl.class);
        swingUae.reg(Sale, Voucher_Type, PnlVoucherTypeListCtrl.class);
        swingUae.reg(Sale, Deposit, PnlDepositListCtrl.class);
        swingUae.reg(Sale, Selling, PnlSellingListCtrl.class);
        swingUae.reg(Sale, Config, PnlConfigCtrl.class);
        return _initInitialDataUaeUtility(swingUae).compile() && new SVInitInitialDataBo().initFirstData();
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(MenuPosition.LEFT_SIDE.equals(MENU_POST) ? getMenubarV() : getMenubarH());
        swingUae.addMenuRoot(PnlLoginCtrl.class, PnlHomeCtrl.class);
        swingUae.addMenuParent(Home, null, PnlHomeCtrl.class);
        swingUae.addMenuParent(Customer, null, PnlCustomerListCtrl.class);
        swingUae.addMenuParent(Voucher, null, null);
        swingUae.addMenuChild(Operator, null, PnlOperatorListCtrl.class);
        swingUae.addMenuChild(Voucher_Type, null, PnlVoucherTypeListCtrl.class);
        swingUae.addMenuChild(Deposit, null, PnlDepositListCtrl.class);
        swingUae.addMenuChild(Selling, null, PnlSellingListCtrl.class);
        swingUae.addMenuChild(Config, null, PnlConfigCtrl.class);
        swingUae.changeMenuSide();
        _applyUserConfigUaeUtility(swingUae).compileMenu();
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