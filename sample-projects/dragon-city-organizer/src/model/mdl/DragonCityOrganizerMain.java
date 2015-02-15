package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCLoginInfo;
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DragonCityOrganizerMain extends CFSwingMain {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private static final boolean withoutLogin = true;
//</editor-fold>

    @Override
    protected void _loadInternalSetting() {
        APPL_ID = "dragon-city-organizer";
        APPL_CODE = "dragon-city-organizer";
        APPL_NAME = "Dragon City Organizer";
        super._loadInternalSetting();
        if (withoutLogin) {
            CCLoginInfo.INSTANCE = null;
        }
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        DragonCityOrganizerModule.INSTANCE.init(HIBERNATE);
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
        new DragonCityOrganizerMain().showScreen();
    }
}