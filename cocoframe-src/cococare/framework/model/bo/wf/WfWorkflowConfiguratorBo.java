package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getUniqueKeyValue;
import cococare.database.CCEntity;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.wf.WfActionDao;
import cococare.framework.model.dao.wf.WfActivityDao;
import cococare.framework.model.dao.wf.WfProcessDao;
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfProcess;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfWorkflowConfiguratorBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfProcessDao processDao;
    private WfActivityDao activityDao;
    private WfActionDao actionDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized List<WfProcess> getProcesses() {
        return processDao.getList();
    }

    public synchronized List<WfActivity> getActivitesBy(WfProcess process) {
        return activityDao.getListBy(process);
    }

    public synchronized List<WfAction> getActionsBy(WfActivity activity) {
        return actionDao.getListBy(activity);
    }

    public synchronized String newBreadcrumbsTitle(Object object) {
        String title = "";
        if (object instanceof WfActivity) {
            title += newBreadcrumbsTitle(((WfActivity) object).getProcess());
        } else if (object instanceof WfAction) {
            title += newBreadcrumbsTitle(((WfAction) object).getActivity());
        }
        if (object instanceof CCEntity) {
            title += getUniqueKeyValue(object) + "  >  ";
        }
        return title;
    }
//</editor-fold>
}