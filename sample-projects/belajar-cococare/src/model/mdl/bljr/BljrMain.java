package model.mdl.bljr;

import cococare.common.CCLanguage;
import cococare.database.CCLoginInfo;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
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
    public boolean initInitialData() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg("Bljr", "Employee", PnlEmployeeListCtrl.class);
        return _initInitialDataUaeUtility(swingUae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(CFSwingMap.getMenubarV());
        swingUae.addMenuRoot(PnlLoginCtrl.class);
        swingUae.addMenuParent(CCLanguage.Archive, null, null);
        swingUae.addMenuChild("Employee", null, PnlEmployeeListCtrl.class);
        swingUae.changeMenuSide();
        _applyUserConfigUaeUtility(swingUae).compileMenu();
        CFSwingMap.getMainScreen().validate();
    }

    @Override
    public void showScreen() {
        //super.showScreen();//with login
        _applyUserConfig();//without login
    }

    public static void main(String[] args) {
        new BljrMain().showScreen();
    }
}