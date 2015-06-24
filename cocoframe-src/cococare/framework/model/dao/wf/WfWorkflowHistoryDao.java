package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
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
    public WfWorkflowHistory getLastBy(WfWorkflow workflow) {
        hql.start().
                where("workflow = :workflow").
                orderBy("ID DESC");
        parameters.start().
                set("workflow", workflow);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}