package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getIds;
import static cococare.common.CCLogic.coalesce;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfWorkflow;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfWorkflowDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfWorkflow.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<WfWorkflow> getChildren(WfWorkflow workflow) {
        return getListByField("parent", workflow, false);
    }

    public UtilUser getUserWhichHasSmallesWeightBy(List<UtilUser> users) {
        String myHql = "SELECT u "
                + "FROM WfWorkflow w "
                + "RIGHT JOIN w.user u "
                + "LEFT JOIN w.activity a "
                + "WHERE u IN (:users) "
                + "GROUP BY u "
                + "ORDER BY SUM(a.weight) ASC ";
        parameters.start().
                set("users", users);
        return getBy(myHql, parameters.value());
    }

    public boolean isMergeable(WfWorkflow workflow) {
        hql.start().
                alias("w").
                where("(w = :allWorkflow OR w.merge = :allWorkflow)").
                where("w != :theWorkflow").
                where("w.activity != :activity");
        parameters.start().
                set("allWorkflow", coalesce(workflow.getMerge(), workflow)).
                set("theWorkflow", workflow).
                set("activity", workflow.getActivity());
        return getListBy(hql.value(), parameters.value()).isEmpty();
    }

    public List<WfWorkflow> getParallelWorkflowsBy(WfWorkflow workflow) {
        return getListByField("merge", coalesce(workflow.getMerge(), workflow), false);
    }

    public List<WfActivity> getActivitiesBy(UtilUserGroup userRole) {
        hql.start().
                alias("w").
                select("w.activity").
                where("w.userRole = :userRole").
                groupBy("w.activity");
        parameters.start().
                set("userRole", userRole);
        return getListBy(hql.value(), parameters.value());
    }

    public List<Long> getDocumentIdsBy(WfActivity activity, UtilUserGroup userRole, UtilUser user) {
        hql.start().
                alias("w").
                select("w.document").
                where("w.activity = :activity").
                where("w.userRole = :userRole");
        parameters.start().
                set("activity", activity).
                set("userRole", userRole);
        if (isNotNull(user)) {
            hql.where("w.user = :user");
            parameters.set("user", user);
        } else {
            hql.where("w.user IS NULL");
        }
        return getIds(getListUnlimitedBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}