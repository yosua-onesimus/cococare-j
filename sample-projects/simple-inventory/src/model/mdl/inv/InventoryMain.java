package model.mdl.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import controller.form.inv.*;
//</editor-fold>

public class InventoryMain extends CFApplCtrl {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "smpl-invntry";
        APPL_NAME = "simple-inventory";
        //CCLoginInfo.INSTANCE = null;//without login
        super._loadInternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        InventoryModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    public boolean initInitialData() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg("Inventory", "Inventory", PnlInventoryListCtrl.class);
        swingUae.reg("Inventory", "Employee", PnlEmployeeListCtrl.class);
        swingUae.reg("Inventory", "Ownership", PnlOwnershipListCtrl.class);
        return _initInitialDataUaeUtility(swingUae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        super._applyUserConfig();
        CFSwingUae swingUae = new CFSwingUae();
        if (MenuPosition.LEFT_SIDE == MENU_POST) {
            CFSwingMap.getMenubarV().setVisible(true);
            swingUae.initMenuBar(CFSwingMap.getMenubarV());
        } else {
            CFSwingMap.getMenubarH().setVisible(true);
            swingUae.initMenuBar(CFSwingMap.getMenubarH());
        }
        swingUae.addMenuRoot(PnlLoginCtrl.class);
        if (CCLoginInfo.INSTANCE_getUserLogin() != null && ((UtilUser) CCLoginInfo.INSTANCE_getUserLogin()).getUserGroup().isRoot()) {
            swingUae.addMenuRoot(PnlInventory2ListCtrl.class, PnlInventory3ListCtrl.class);
        }
        swingUae.addMenuParent(CCLanguage.Archive, null, null);
        swingUae.addMenuChild("Inventory", null, PnlInventoryListCtrl.class);
        swingUae.addMenuChild("Employee", null, PnlEmployeeListCtrl.class);
        swingUae.addMenuChild("Ownership", null, PnlOwnershipListCtrl.class);
        swingUae.addMenuParent("Dialog Flow Sample", null, null);
        swingUae.addMenuChild("Inventory", null, PnlInventory2ListCtrl.class);
        swingUae.addMenuParent("Panel Flow Sample", null, null);
        swingUae.addMenuChild("Inventory", null, PnlInventory3ListCtrl.class);
        swingUae.changeMenuSide();
        _applyUserConfigUaeUtility(swingUae).compileMenu();
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