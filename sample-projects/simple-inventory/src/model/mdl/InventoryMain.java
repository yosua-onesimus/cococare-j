package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import controller.form.PnlEmployeeListCtrl;
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
    public boolean initInitialData() {
        return true;
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae utilSwingUae = new CFSwingUae();
        CFSwingMap.getMenubarV().setVisible(true);
        utilSwingUae.initMenuBar(CFSwingMap.getMenubarV());
        utilSwingUae.addMenuParent(CCLanguage.Archive, null, null);
        utilSwingUae.addMenuChild("Inventory", null, PnlInventoryListCtrl.class);
        utilSwingUae.addMenuChild("Employee", null, PnlEmployeeListCtrl.class);
        utilSwingUae.compileMenu();
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