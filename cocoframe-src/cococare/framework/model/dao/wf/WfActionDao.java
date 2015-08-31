package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfActivity;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfActionDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfAction.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<WfAction> getListBy(WfActivity activity) {
        return getListByField("activity", activity, false);
    }
//</editor-fold>
}