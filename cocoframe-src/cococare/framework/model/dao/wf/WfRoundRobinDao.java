package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfRoundRobin;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfRoundRobinDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfRoundRobin.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<UtilUser> getUsersBy(WfActivity activity) {
        hql.start().
                alias("rr").
                select("rr.user").
                where("rr.activity = :activity");
        parameters.start().
                set("activity", activity);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public WfRoundRobin getWhichHasOldestLastTaskBy(WfActivity activity) {
        hql.start().
                where("activity = :activity").
                orderBy("lastTask ASC");
        parameters.start().
                set("activity", activity);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}