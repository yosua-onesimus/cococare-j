package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.util.UtilFilter.isIdNotId;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import static cococare.framework.model.obj.wf.WfFilter.*;
import cococare.framework.model.obj.wf.WfTransition;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCBandBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlTransitionCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JTabbedPane tabTransition;
    private JPanel pnlDestination;
    private CCBandBox bndTransitionVisibility;
    private CCBandBox bndRouteValidation;
    private CCBandBox bndDestination;
    private CCBandBox bndPostRouteProcess;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfTransition.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        ActivityPointType activityPointType = ((WfTransition) objEntity).getOrigin().getActivityPointType();
        if (ActivityPointType.ASIDE_POINT.equals(activityPointType)
                || ActivityPointType.SPLIT_POINT.equals(activityPointType)) {
            _addChildScreen("transition", new PnlDestinationListCtrl(), "pnlDestination");
        } else {
            tabTransition.remove(pnlDestination);
        }
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndTransitionVisibility.getTable().setHqlFilters(isTypeIsTransitionVisibility);
        bndRouteValidation.getTable().setHqlFilters(isTypeIsRouteValidation);
        bndDestination.getTable().setHqlFilters(new isIdNotId() {
            @Override
            public Object getFieldValue() {
                return ((WfTransition) objEntity).getOrigin().getId();
            }
        });
        bndPostRouteProcess.getTable().setHqlFilters(isTypeIsPostRouteProcess);
    }
}