package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.newObject;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.bo.wf.WfWorkflowBo;
import cococare.framework.model.obj.wf.WfActivityTab;
import cococare.framework.model.obj.wf.WfDocument;
import cococare.framework.model.obj.wf.WfEnum.DocumentStatus;
import cococare.framework.swing.controller.form.PnlDefaultWithChildCtrl;
import static cococare.swing.CCSwing.execute;
import static cococare.swing.CCSwing.setVisible;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationCtrl extends PnlDefaultWithChildCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfWorkflowBo workflowBo;
//</editor-fold>

    @Override
    protected void _initComponent() {
        super._initComponent();
        setVisible(false, swingView.getBtnSave());
        WfDocument document = (WfDocument) objEntity;
        List<WfActivityTab> activityTabs = workflowBo.getActivityTabsBy(document.getWorkflow().getActivity());
        for (WfActivityTab activityTab : activityTabs) {
            Class viewCtrlClass = CCClass.getClass(activityTab.getTab().getPath());
            _addChildScreen2(activityTab.getTabName(), "document", (CFViewCtrl) newObject(viewCtrlClass));
        }
        if (!DocumentStatus.PORTFOLIO.equals(document.getDocumentStatus())) {
            _addChildScreen2("Workflow History", "workflow.document", new PnlWorkflowHistoryListCtrl());
        }
        if (DocumentStatus.ACTIVE.equals(document.getDocumentStatus())) {
            ActionListener alCloseOnSuccess = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    updateCaller = true;//update caller
                    newEntity = true;//reload all rows
                    execute(alClose, actionEvent);
                }
            };
            parameter.put(toString() + "alCloseOnSuccess", alCloseOnSuccess);
            parameter.put(toString() + "workflow", workflowBo.prepareRouting(document.getWorkflow()));
            _addChildScreen2("Routing", "", new PnlRoutingCtrl());
        }
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        edtEntity.setAccessible2Readonly();
    }
}