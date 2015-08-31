package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfActivity;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsActionVisibility;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsRouteValidation;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import cococare.swing.component.CCBandBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlActionCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCBandBox bndActionVisibility;
    private CCBandBox bndRouteValidation;
//</editor-fold>

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndActionVisibility.getTable().setHqlFilters(isTypeIsActionVisibility);
        bndRouteValidation.getTable().setHqlFilters(isTypeIsRouteValidation);
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        ((WfAction) objEntity).setActivity((WfActivity) parameter.get(callerCtrl.toString() + "selectedObject"));
    }

    @Override
    protected boolean _doSaveEntity() {
        parameter.put(callerCtrl.toString() + "crudObject", objEntity);
        return super._doSaveEntity();
    }
}