package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.model.obj.util.UtilFilter.isIdNotId;
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfEnum.TransitionRouteType;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsPostRouteProcess;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsRouteAvailability;
import cococare.framework.model.obj.wf.WfTransition;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.CCTable;
import cococare.swing.component.CCBandBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlTransitionCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCBandBox bndRouteAvailability;
    private JComboBox cmbRouteType;
    private CCBandBox bndDestination;
    private CCBandBox bndPostRouteProcess;
//</editor-fold>

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndRouteAvailability.getTable().setHqlFilters(isTypeIsRouteAvailability);
        bndDestination.getTable().setHqlFilters(new isIdNotId() {
            @Override
            public Object getFieldValue() {
                return ((WfTransition) objEntity).getAction().getActivity().getId();
            }
        });
        bndPostRouteProcess.getTable().setHqlFilters(isTypeIsPostRouteProcess);
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        WfTransition transition = (WfTransition) objEntity;
        transition.setAction((WfAction) parameter.get(callerCtrl.toString() + "selectedObject"));
        transition.setSequence(((CCTable) parameter.get(callerCtrl.toString() + "tblEntity")).getRowCount());
        transition.setName(transition.getAction().getName());
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(bndDestination, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doDestination();
            }
        });
    }

    private void _doDestination() {
        WfActivity destination = bndDestination.getObject();
        boolean isFinalPoint = isNotNull(destination) && ActivityPointType.FINAL_POINT.equals(destination.getActivityPointType());
        edtEntity.setAccessible(cmbRouteType, isFinalPoint ? Accessible.READONLY_SET_NULL : Accessible.MANDATORY);
        if (isFinalPoint) {
            cmbRouteType.setSelectedIndex(TransitionRouteType.POOLING.ordinal());
        }
    }

    @Override
    protected boolean _doSaveEntity() {
        parameter.put(callerCtrl.toString() + "crudObject", objEntity);
        return super._doSaveEntity();
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        _doDestination();
    }
}