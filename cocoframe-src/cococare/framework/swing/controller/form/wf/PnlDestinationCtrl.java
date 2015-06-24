package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.util.UtilFilter.isIdNotId;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsPostRouteProcess;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsRouteAvailability;
import cococare.framework.model.obj.wf.WfTransitionDestination;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCBandBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDestinationCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCBandBox bndRouteAvailability;
    private CCBandBox bndDestination;
    private CCBandBox bndPostRouteProcess;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfTransitionDestination.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndRouteAvailability.getTable().setHqlFilters(isTypeIsRouteAvailability);
        bndDestination.getTable().setHqlFilters(new isIdNotId() {
            @Override
            public Object getFieldValue() {
                return ((WfTransitionDestination) objEntity).getTransition().getOrigin().getId();
            }
        });
        bndPostRouteProcess.getTable().setHqlFilters(isTypeIsPostRouteProcess);
    }
}