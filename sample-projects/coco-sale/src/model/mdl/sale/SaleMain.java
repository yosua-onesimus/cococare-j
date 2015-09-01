package model.mdl.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.swing.CFSwingMain;
import controller.form.sale.*;
import java.util.Arrays;
import model.bo.sale.SVInitInitialDataBo;
import static model.mdl.sale.SaleLanguage.*;
import model.obj.sale.SVConfig;
//</editor-fold>

public class SaleMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_VER = "1.0.150901";
        APPL_CODE = "cccr-sl-vchr-pprl";
        APPL_NAME = "Coco Sale ~ Voucher and Apparel";
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        CCLanguage.init(false, SaleLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        SaleModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected boolean _initInitialData() {
        UtilConfigBo configBo = new UtilConfigBo();
        confAppl = configBo.loadConfAppl();
        confAppl.setUtilAdditionalSettingClass(Arrays.asList(
                SVConfig.class.getName()));
        return super._initInitialData()
                && configBo.saveConf(confAppl)
                && new SVInitInitialDataBo().initFirstData();
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(Sale, Customer, PnlCustomerListCtrl.class);
        uae.reg(Sale, Operator, PnlOperatorListCtrl.class);
        uae.reg(Sale, Voucher_Type, PnlVoucherTypeListCtrl.class);
        uae.reg(Sale, Deposit, PnlDepositListCtrl.class);
        uae.reg(Sale, Selling, PnlSellingListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuRoot(PnlHomeCtrl.class);
        uae.addMenuParent(Home, "/cococare/resource/icon-menu-home.png", PnlHomeCtrl.class);
        uae.addMenuParent(Customer, "/cococare/resource/icon-menu-child.png", PnlCustomerListCtrl.class);
        uae.addMenuParent(Voucher, "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild(Operator, "/cococare/resource/icon-menu-child.png", PnlOperatorListCtrl.class);
        uae.addMenuChild(Voucher_Type, "/cococare/resource/icon-menu-child.png", PnlVoucherTypeListCtrl.class);
        uae.addMenuChild(Deposit, "/cococare/resource/icon-menu-child.png", PnlDepositListCtrl.class);
        uae.addMenuChild(Selling, "/cococare/resource/icon-menu-child.png", PnlSellingListCtrl.class);
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