package controller.form.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.copy;
import cococare.framework.swing.CFSwingCtrl;
import model.bo.lib.LibConfigBo;
import model.obj.lib.LibBook;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlBook2Ctrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    private LibConfigBo configBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return LibBook.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.DIALOG_MODE;
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        copy(configBo.loadLibConfig(), objEntity);
    }
}