package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCEntity;
import static cococare.datafile.CCFile.writeObject;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationSettingCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigBo configBo;
//</editor-fold>

    @Override
    protected boolean _doSaveEntity() {
        if ((updateCaller = configBo.saveConf(objEntity)) && (objEntity instanceof UtilConfAppl)) {
            updateCaller = writeObject((CCEntity) objEntity, CFApplCtrl.FILE_APPL_CONF);
            CFApplCtrl.INSTANCE.updateNonContent(objEntity);
        }
        return updateCaller;
    }

    @Override
    protected String _getTabTitle() {
        return _getEntityLabel();
    }
}