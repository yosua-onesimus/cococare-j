package cococare.framework.model.dao.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.wf.WorkflowDao;
import cococare.framework.model.obj.wf.WfTab;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfTabDao extends WorkflowDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return WfTab.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    public String getLastCode() {
        return getLastValue("code", "T000");
    }

    public WfTab getByPath(String path) {
        return getByField("path", path);
    }
//</editor-fold>
}