package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.fb.FBClassBo;
import model.obj.fb.FBClass;
//</editor-fold>

public class PnlClassCtrl extends CFSwingCtrl {

    private FBClassBo classBo;

    @Override
    protected Class _getEntity() {
        return FBClass.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        //
        classBo.load((FBClass) objEntity);
    }

    @Override
    protected boolean _doSaveEntity() {
        return classBo.save();
    }
}