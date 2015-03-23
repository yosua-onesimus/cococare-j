package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplUae;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.swing.CFSwingMain;
import java.util.Arrays;
import model.obj.fb.FBConfig;
//</editor-fold>

public class FableMain extends CFSwingMain {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static final boolean withoutLogin = true;
//</editor-fold>

    @Override
    protected void _loadInternalSetting() {
        APPL_ID = "fablengine";
        APPL_CODE = "fablengine";
        APPL_NAME = "<html><b>F</b>a<b>B</b>l<b>E</b>ngine</html>";
        super._loadInternalSetting();
        if (withoutLogin) {
            CCLoginInfo.INSTANCE = null;
        }
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        FableModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected boolean _initInitialData() {
        UtilConfigBo configBo = new UtilConfigBo();
        confAppl = configBo.loadConfAppl();
        confAppl.setUtilAdditionalSettingClass(Arrays.asList(
                FBConfig.class.getName()));
        return super._initInitialData()
                && configBo.saveConf(confAppl);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
    }

    @Override
    public void showScreen() {
        if (withoutLogin) {
            _applyUserConfig();
        } else {
            super.showScreen();
        }
    }

    public static void main(String[] args) {
        new FableMain().showScreen();
    }
}