package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.wf.WfProcess;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfProcessDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfProcess.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    public WfProcess getByCode(String code) {
        return getByField("code", code);
    }
//</editor-fold>
}