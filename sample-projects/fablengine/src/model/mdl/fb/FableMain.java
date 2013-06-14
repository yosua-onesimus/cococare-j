package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.framework.swing.controller.form.util.PnlLoginCtrl;
import controller.form.fb.PnlActionListCtrl;
import controller.form.fb.PnlActorListCtrl;
import controller.form.fb.PnlClassListCtrl;
//</editor-fold>

public class FableMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "fablengine";
        APPL_NAME = "<html><b>F</b>a<b>B</b>l<b>E</b>ngine</html>";
        //CCLoginInfo.INSTANCE = null;//without login
        super._loadInternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        FableModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    public boolean initInitialData() {
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.reg("FB", "Action", PnlActionListCtrl.class);
        swingUae.reg("FB", "Class", PnlClassListCtrl.class);
        swingUae.reg("FB", "Actor", PnlActorListCtrl.class);
        return _initInitialDataUaeUtility(swingUae).compile();
    }

    @Override
    protected void _applyUserConfig() {
        super._applyUserConfig();
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(MenuPosition.LEFT_SIDE.equals(MENU_POST) ? CFSwingMap.getMenubarV() : CFSwingMap.getMenubarH());
        swingUae.addMenuRoot(PnlLoginCtrl.class);
        swingUae.addMenuParent("FaBle Engine", null, null);
        swingUae.addMenuChild("Action", null, PnlActionListCtrl.class);
        swingUae.addMenuChild("Class", null, PnlClassListCtrl.class);
        swingUae.addMenuChild("Actor", null, PnlActorListCtrl.class);
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
        new FableMain().showScreen();
    }
}