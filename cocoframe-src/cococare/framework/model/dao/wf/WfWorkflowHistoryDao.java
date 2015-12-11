package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.coalesce;
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfWorkflow;
import cococare.framework.model.obj.wf.WfWorkflowHistory;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfWorkflowHistoryDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfWorkflowHistory.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public WfWorkflowHistory getLastBy(WfWorkflow workflow, UtilUserGroup userRole, boolean hasAction) {
        hql.start().
                alias("wh").
                where("wh.workflow = :workflow").
                where("wh.activity.userRole = :userRole").
                where(hasAction ? "wh.action IS NOT NULL" : "wh.action IS NULL").
                orderBy("wh.ID DESC");
        parameters.start().
                set("workflow", coalesce(workflow.getMerge(), workflow)).
                set("userRole", userRole);
        return getBy(hql.value(), parameters.value());
    }

    public WfWorkflowHistory getLastBy(WfWorkflow workflow, WfActivity activity, boolean hasAction) {
        hql.start().
                where("workflow = :workflow").
                where("activity = :activity").
                where(hasAction ? "action IS NOT NULL" : "action IS NULL").
                orderBy("ID DESC");
        parameters.start().
                set("workflow", coalesce(workflow.getMerge(), workflow)).
                set("activity", activity);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}