package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.wf.WfScript;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfScriptDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfScript.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    public String getLastCode() {
        return getLastValue("code", "S000");
    }

    public WfScript getByPath(String path) {
        return getByField("path", path);
    }
//</editor-fold>
}