package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.framework.model.obj.wf.WfFilter.*;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import cococare.swing.component.CCBandBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlProcessCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCBandBox txtAdditionalInput;
    private CCBandBox txtRouteValidation;
    private CCBandBox txtPostRouteProcess;
    private CCBandBox txtPostCommitProcess;
//</editor-fold>

    @Override
    protected void _initEditor() {
        super._initEditor();
        txtAdditionalInput.getTable().setHqlFilters(isTypeIsAdditionalInput);
        txtRouteValidation.getTable().setHqlFilters(isTypeIsRouteValidation);
        txtPostRouteProcess.getTable().setHqlFilters(isTypeIsPostRouteProcess);
        txtPostCommitProcess.getTable().setHqlFilters(isTypeIsPostRouteProcess);
    }

    @Override
    protected boolean _doSaveEntity() {
        parameter.put(callerCtrl.toString() + "crudObject", objEntity);
        return super._doSaveEntity();
    }
}