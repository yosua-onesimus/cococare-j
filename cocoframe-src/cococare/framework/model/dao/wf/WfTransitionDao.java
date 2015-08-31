package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfTransition;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfTransitionDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfTransition.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public WfTransition getFirstBy(WfAction action) {
        hql.start().
                where("action = :action").
                orderBy("sequence ASC");
        parameters.start().
                set("action", action);
        return getBy(hql.value(), parameters.value());
    }

    public List<WfTransition> getListBy(WfAction action) {
        return getListByField("action", action, false);
    }
//</editor-fold>
}