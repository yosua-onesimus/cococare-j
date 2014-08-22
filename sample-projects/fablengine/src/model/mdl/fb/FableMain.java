package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import controller.form.fb.PnlActionListCtrl;
import controller.form.fb.PnlActorListCtrl;
import controller.form.fb.PnlClassListCtrl;
//</editor-fold>

public class FableMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "fablengine";
        APPL_NAME = "<html><b>F</b>a<b>B</b>l<b>E</b>ngine</html>";
        super._loadInternalSetting();
        //CCLoginInfo.INSTANCE = null;//without login
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        FableModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg("FB", "Action", PnlActionListCtrl.class);
        uae.reg("FB", "Class", PnlClassListCtrl.class);
        uae.reg("FB", "Actor", PnlActorListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent("FaBle Engine", null, null);
        uae.addMenuChild("Action", null, PnlActionListCtrl.class);
        uae.addMenuChild("Class", null, PnlClassListCtrl.class);
        uae.addMenuChild("Actor", null, PnlActorListCtrl.class);
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