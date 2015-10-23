package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfProcess;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfActivityDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfActivity.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    public WfActivity getByCode(String code) {
        return getByField("code", code);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<WfActivity> getListBy(WfProcess process) {
        return getListByField("process", process, false);
    }

    public WfActivity getStartPointBy(WfProcess process) {
        hql.start().
                where("pointTypeIndex = :pointTypeIndex").
                where("process = :process");
        parameters.start().
                set("pointTypeIndex", ActivityPointType.START_POINT.ordinal()).
                set("process", process);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}