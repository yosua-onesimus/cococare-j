package model.mdl.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import controller.form.sch.PnlPersonListCtrl;
import controller.form.sch.PnlScheduleListCtrl;
//</editor-fold>

public class ScheduleMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "smpl-schdl";
        APPL_NAME = "simple-schedule";
        super._loadInternalSetting();
        //CCLoginInfo.INSTANCE = null;//without login
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        ScheduleModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    public boolean initInitialData() {
        CFSwingUae uae = new CFSwingUae();
        uae.reg("Schedule", "Person", PnlPersonListCtrl.class);
        uae.reg("Schedule", "Schedule", PnlScheduleListCtrl.class);
        return _initInitialDataUaeUtility(uae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        CFSwingUae uae = new CFSwingUae();
        uae.initMenuBar(MenuPosition.LEFT_SIDE.equals(MENU_POST) ? CFSwingMap.getMenubarV() : CFSwingMap.getMenubarH());
        uae.addMenuRoot(PnlLoginCtrl.class);
        uae.addMenuParent(CCLanguage.Archive, null, null);
        uae.addMenuChild("Person", null, PnlPersonListCtrl.class);
        uae.addMenuChild("Schedule", null, PnlScheduleListCtrl.class);
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
        new ScheduleMain().showScreen();
    }
}