package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.newObject;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.bo.wf.WfWorkflowBo;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfActivityTab;
import cococare.framework.model.obj.wf.WfDocumentSample;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCComboBox;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfWorkflowBo workflowBo;
    private CCComboBox cmbActivity;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfDocumentSample.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        cmbActivity = (CCComboBox) parameter.get(callerCtrl.toString() + "cmbActivity");
        List<WfActivityTab> activityTabs = workflowBo.getActivityTabsBy((WfActivity) cmbActivity.getSelectedObject());
        for (WfActivityTab activityTab : activityTabs) {
            Class viewCtrlClass = CCClass.getClass(activityTab.getTab().getPath());
            _addChildScreen(activityTab.getTabName(), "document", (CFViewCtrl) newObject(viewCtrlClass), viewCtrlClass.getSimpleName());
        }
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        edtEntity.setAccessible2Readonly();
    }
}