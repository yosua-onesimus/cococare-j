package model.mdl.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.database.CCLoginInfo;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import controller.form.inv.*;
import model.obj.inv.InvReport;
//</editor-fold>

public class InventoryMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "smpl-invntry";
        APPL_NAME = "simple-inventory";
        super._loadInternalSetting();
        InvReport.setupReportFile();
        //CCLoginInfo.INSTANCE = null;//without login
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        InventoryModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    public boolean initInitialData() {
        CFSwingUae uae = new CFSwingUae();
        uae.reg("Inventory", "Inventory", PnlInventoryListCtrl.class);
        uae.reg("Inventory", "Employee", PnlEmployeeListCtrl.class);
        uae.reg("Inventory", "Ownership", PnlOwnershipListCtrl.class);
        uae.reg("Inventory", "Config", PnlConfigCtrl.class);
        uae.reg("Inventory", "Report", PnlReportListCtrl.class);
        return _initInitialDataUaeUtility(uae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae uae = new CFSwingUae();
        uae.initMenuBar(MenuPosition.LEFT_SIDE.equals(MENU_POST) ? CFSwingMap.getMenubarV() : CFSwingMap.getMenubarH());
        uae.addMenuRoot(PnlLoginCtrl.class);
        if (CCLoginInfo.INSTANCE_getUserLogin() != null && ((UtilUser) CCLoginInfo.INSTANCE_getUserLogin()).getUserGroup().isRoot()) {
            uae.addMenuRoot(PnlInventory2ListCtrl.class, PnlInventory3ListCtrl.class);
        }
        uae.addMenuParent(CCLanguage.Archive, null, null);
        uae.addMenuChild("Inventory", null, PnlInventoryListCtrl.class);
        uae.addMenuChild("Employee", null, PnlEmployeeListCtrl.class);
        uae.addMenuChild("Ownership", null, PnlOwnershipListCtrl.class);
        uae.addMenuChild("Config", null, PnlConfigCtrl.class);
        uae.addMenuChild("Report", null, PnlReportListCtrl.class);
        uae.addMenuParent("Dialog Flow Sample", null, null);
        uae.addMenuChild("Inventory", null, PnlInventory2ListCtrl.class);
        uae.addMenuParent("Panel Flow Sample", null, null);
        uae.addMenuChild("Inventory", null, PnlInventory3ListCtrl.class);
        uae.changeMenuSide();
        _applyUserConfigUaeUtility(uae).compileMenu();
        CFSwingMap.getMainScreen().validate();
    }

    @Override
    public void showScreen() {
        super.showScreen();//with login
        //_applyUserConfig();//without login
    }

    public static void main(String[] args) {
        new InventoryMain().showScreen();
    }
}