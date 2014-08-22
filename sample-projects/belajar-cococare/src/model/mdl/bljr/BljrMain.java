package model.mdl.bljr;

import cococare.common.CCLanguage;
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import controller.form.bljr.PnlEmployeeListCtrl;

public class BljrMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        super._loadInternalSetting();
        CCLoginInfo.INSTANCE = null;//without login
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        BljrModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg("Bljr", "Employee", PnlEmployeeListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent(CCLanguage.Archive, null, null);
        uae.addMenuChild("Employee", null, PnlEmployeeListCtrl.class);
    }

    @Override
    public void showScreen() {
//        super.showScreen();//with login
        _applyUserConfig();//without login
    }

    public static void main(String[] args) {
        new BljrMain().showScreen();
    }
}