package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.UtilUserGroupDao;
import cococare.framework.model.dao.wf.WfActionDao;
import cococare.framework.model.dao.wf.WfActivityDao;
import cococare.framework.model.dao.wf.WfProcessDao;
import cococare.framework.model.dao.wf.WfTransitionDao;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfEnum.TransitionRouteType;
import cococare.framework.model.obj.wf.WfProcess;
import cococare.framework.model.obj.wf.WfTransition;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfInitInitialDataSampleBo extends CCHibernateBo {

    public static final String DOCMNGM = "DocMngm";
    //
    private UtilUserGroupDao userGroupDao;
    private WfProcessDao processDao;
    private WfActivityDao activityDao;
    private WfActionDao actionDao;
    private WfTransitionDao transitionDao;

    /**
     * @see <a
     * href="http://www.uml-diagrams.org/document-management-uml-activity-diagram-example.html">Document
     * Management Process</a>
     */
    public synchronized boolean initInitialData() {
        Transaction transaction = processDao.newTransaction();

        WfProcess process = processDao.getByCode(DOCMNGM);
        if (process == null) {
            process = new WfProcess();
            process.setCode(DOCMNGM);
            process.setName("Document Management");
            transaction.saveOrUpdate(process);
        }

        UtilUserGroup userGroup = userGroupDao.getByCode("Author");
        if (userGroup == null) {
            userGroup = new UtilUserGroup("Author", "Author", false);
            transaction.saveOrUpdate(userGroup);
        }

        UtilUserGroup userGroup2 = userGroupDao.getByCode("Reviewer");
        if (userGroup2 == null) {
            userGroup2 = new UtilUserGroup("Reviewer", "Reviewer", false);
            transaction.saveOrUpdate(userGroup2);
        }

        UtilUserGroup userGroup3 = userGroupDao.getByCode("Approver");
        if (userGroup3 == null) {
            userGroup3 = new UtilUserGroup("Approver", "Approver", false);
            transaction.saveOrUpdate(userGroup3);
        }

        WfActivity activity = activityDao.getByCode("Act01");
        if (activity == null) {
            activity = new WfActivity();
            activity.setProcess(process);
            activity.setCode("Act01");
            activity.setName("Application Created");
            activity.setUserRole(userGroup);
            activity.setActivityPointType(ActivityPointType.START_POINT);
            transaction.saveOrUpdate(activity);
        }

        WfActivity activity2 = activityDao.getByCode("Act02");
        if (activity2 == null) {
            activity2 = new WfActivity();
            activity2.setProcess(process);
            activity2.setCode("Act02");
            activity2.setName("Application Pending Reviewer");
            activity2.setUserRole(userGroup2);
            transaction.saveOrUpdate(activity2);
        }

        WfActivity activity3 = activityDao.getByCode("Act03");
        if (activity3 == null) {
            activity3 = new WfActivity();
            activity3.setProcess(process);
            activity3.setCode("Act03");
            activity3.setName("Application Pending Approver");
            activity3.setUserRole(userGroup3);
            transaction.saveOrUpdate(activity3);
        }

        WfActivity activity4 = activityDao.getByCode("Act04");
        if (activity4 == null) {
            activity4 = new WfActivity();
            activity4.setProcess(process);
            activity4.setCode("Act04");
            activity4.setName("Application Pending Effective Reviewer");
            activity4.setUserRole(userGroup2);
            transaction.saveOrUpdate(activity4);
        }

        WfAction action = actionDao.getByCode("Act01");
        if (action == null) {
            action = new WfAction();
            action.setActivity(activity);
            action.setCode("Act01");
            action.setName("Submit to Reviewer");
            transaction.saveOrUpdate(action);
        }

        WfAction action2 = actionDao.getByCode("Act02");
        if (action2 == null) {
            action2 = new WfAction();
            action2.setActivity(activity2);
            action2.setCode("Act02");
            action2.setName("Return to Author");
            transaction.saveOrUpdate(action2);
        }

        WfAction action3 = actionDao.getByCode("Act03");
        if (action3 == null) {
            action3 = new WfAction();
            action3.setActivity(activity2);
            action3.setCode("Act03");
            action3.setName("Submit to Approver");
            transaction.saveOrUpdate(action3);
        }

        WfAction action4 = actionDao.getByCode("Act04");
        if (action4 == null) {
            action4 = new WfAction();
            action4.setActivity(activity3);
            action4.setCode("Act04");
            action4.setName("Return to Author");
            transaction.saveOrUpdate(action4);
        }

        WfTransition transition = transitionDao.getByCode("Trans01");
        if (transition == null) {
            transition = new WfTransition();
            transition.setAction(action);
            transition.setCode("Trans01");
            transition.setName("Submit to Reviewer");
            transition.setDestination(activity2);
            transaction.saveOrUpdate(transition);
        }

        WfTransition transition2 = transitionDao.getByCode("Trans02");
        if (transition2 == null) {
            transition2 = new WfTransition();
            transition2.setAction(action2);
            transition2.setCode("Trans02");
            transition2.setName("Return to Author");
            transition2.setTransitionRouteType(TransitionRouteType.TO_LAST_USER);
            transition2.setDestination(activity);
            transaction.saveOrUpdate(transition2);
        }

        WfTransition transition3 = transitionDao.getByCode("Trans03");
        if (transition3 == null) {
            transition3 = new WfTransition();
            transition3.setAction(action3);
            transition3.setCode("Trans03");
            transition3.setName("Submit to Approver");
            transition3.setDestination(activity3);
            transaction.saveOrUpdate(transition3);
        }

        WfTransition transition4 = transitionDao.getByCode("Trans04");
        if (transition4 == null) {
            transition4 = new WfTransition();
            transition4.setAction(action4);
            transition4.setCode("Trans04");
            transition4.setName("Return to Author");
            transition4.setTransitionRouteType(TransitionRouteType.TO_LAST_USER);
            transition4.setDestination(activity);
            transaction.saveOrUpdate(transition4);
        }

        return transaction.execute();
    }
}