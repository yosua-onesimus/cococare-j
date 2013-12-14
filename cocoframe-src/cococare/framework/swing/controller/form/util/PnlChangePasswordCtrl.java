package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.database.CCLoginInfo.INSTANCE_getUserLogin;
import cococare.framework.model.bo.util.UtilUserBo;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingCtrl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlChangePasswordCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilUserBo userBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return UtilUser.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        objEntity = INSTANCE_getUserLogin();
        ((UtilUser) objEntity).setNewPassword(null);
        ((UtilUser) objEntity).setRetypePassword(null);
    }

    @Override
    protected boolean _doSaveEntity() {
        return userBo.changePassword((UtilUser) objEntity);
    }

    @Override
    protected boolean _isSavedToClose() {
        return true;
    }
}