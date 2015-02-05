package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import model.obj.HabitatType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DragonCityOrganizerMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_ID = "dragon-city-organizer";
        APPL_CODE = "dragon-city-organizer";
        APPL_NAME = "Dragon City Organizer";
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        HIBERNATE.addAnnotatedClass(HabitatType.class);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
    }

    public static void main(String[] args) {
        new DragonCityOrganizerMain().showScreen();
    }
}