package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import controller.form.PnlEmployeeListCtrl;
import controller.form.PnlInventory2ListCtrl;
import controller.form.PnlInventory3ListCtrl;
import controller.form.PnlInventoryListCtrl;
//</editor-fold>

public class InventoryMain extends CFApplCtrl {

    @Override
    protected void _loadInternalSetting() {
        super._loadInternalSetting();
        APPL_NAME = "simple-inventory";
        CCLoginInfo.INSTANCE = null;//menghiraukan login
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        InventoryModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae swingUae = new CFSwingUae();
        CFSwingMap.getMenubarV().setVisible(true);
        swingUae.initMenuBar(CFSwingMap.getMenubarV());
        swingUae.addMenuParent(CCLanguage.Archive, null, null);
        swingUae.addMenuChild("Inventory", null, PnlInventoryListCtrl.class);
        swingUae.addMenuChild("Employee", null, PnlEmployeeListCtrl.class);
        swingUae.addMenuParent("Dialog Flow Sample", null, null);
        swingUae.addMenuChild("Inventory", null, PnlInventory2ListCtrl.class);
        swingUae.addMenuParent("Panel Flow Sample", null, null);
        swingUae.addMenuChild("Inventory", null, PnlInventory3ListCtrl.class);
        swingUae.compileMenu();
        CFSwingMap.getMainScreen().validate();
    }

    @Override
    public void showScreen() {
        _applyUserConfig();//menghiraukan login
    }

    public static void main(String[] args) {
        new InventoryMain().showScreen();
    }
}