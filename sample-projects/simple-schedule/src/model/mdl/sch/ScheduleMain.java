package model.mdl.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import controller.form.sch.PnlPersonListCtrl;
import controller.form.sch.PnlScheduleListCtrl;
//</editor-fold>

public class ScheduleMain extends CFApplCtrl {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "smpl-schdl";
        APPL_NAME = "simple-schedule";
        //CCLoginInfo.INSTANCE = null;//without login
        super._loadInternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        ScheduleModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    public boolean initInitialData() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg("Schedule", "Person", PnlPersonListCtrl.class);
        swingUae.reg("Schedule", "Schedule", PnlScheduleListCtrl.class);
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
        swingUae.addMenuParent(CCLanguage.Archive, null, null);
        swingUae.addMenuChild("Person", null, PnlPersonListCtrl.class);
        swingUae.addMenuChild("Schedule", null, PnlScheduleListCtrl.class);
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
        new ScheduleMain().showScreen();
    }
}