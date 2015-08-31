package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.copy;
import static cococare.common.CCClass.extract;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.getErrorMessage;
import cococare.common.CCResponse;
import static cococare.common.CCResponse.newResponse;
import static cococare.common.CCResponse.newResponseFalse;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.dao.util.UtilUserDao;
import cococare.framework.model.dao.wf.*;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfEnum.TransitionRouteType;
import cococare.framework.model.obj.wf.WfEnum.WorkflowStatus;
import cococare.framework.model.obj.wf.*;
import java.util.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfWorkflowBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilUserDao userDao;
    //
    private WfActivityDao activityDao;
    private WfActionDao actionDao;
    private WfTransitionDao transitionDao;
    private WfRoundRobinDao roundRobinDao;
    private WfWorkflowDao workflowDao;
    private WfWorkflowHistoryDao workflowHistoryDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" get user or get role ">
    private synchronized List<UtilUser> getUsers4ManualRoute(WfActivity destination) {
        return userDao.getListUnlimitedBy(destination.getUserRole());
    }

    private synchronized UtilUser getUser4RandomRoute(WfActivity destination) {
        List<UtilUser> users = getUsers4ManualRoute(destination);
        return isEmpty(users) ? null : users.get(new Random().nextInt(users.size()));
    }

    private synchronized UtilUser getUser4WeightageRoute(WfActivity destination) {
        List<UtilUser> users = getUsers4ManualRoute(destination);
        return workflowDao.getUserWhichHasSmallesWeightBy(users);
    }

    private synchronized WfRoundRobin getRoundRobin(WfActivity destination) {
        //prepare round robin user
        List<UtilUser> users = getUsers4ManualRoute(destination);
        List<UtilUser> roundRobinUsers = roundRobinDao.getUsersBy(destination);
        //update round robin table
        if (users.size() != roundRobinUsers.size()) {
            List<Long> ids = extract(users, "id");
            ids.removeAll(extract(roundRobinUsers, "id"));
            for (Long id : ids) {
                WfRoundRobin roundRobin = new WfRoundRobin();
                roundRobin.setActivity(destination);
                UtilUser user = new UtilUser();
                user.setId(id);
                roundRobin.setUser(user);
                roundRobinDao.saveOrUpdate(roundRobin);
            }
        }
        //get round robin which has oldest last task
        return roundRobinDao.getWhichHasOldestLastTaskBy(destination);
    }

    private synchronized UtilUser getUser4ToLastUserRoute(WfWorkflow workflow, WfActivity destination) {
        WfWorkflowHistory workflowHistory = workflowHistoryDao.getLastBy(workflow, destination, true);
        return workflowHistory.getUser();
    }
//</editor-fold>

    public synchronized CCResponse createNewWorkflow(WfProcess process, WfDocument... documents) {
        //prepare to create new workflow
        WfActivity activity = activityDao.getStartPointBy(process);
        if (isNull(activity)) {
            return newResponseFalse(No_Activity_Available);
        }
        Transaction transaction = workflowDao.newTransaction();
        //create new workflow for each document
        WfWorkflow parent = null;
        for (WfDocument document : documents) {
            //save document
            transaction.saveOrUpdate(document);
            //create new workflow
            WfWorkflow workflow = new WfWorkflow(document, process, activity);
            if (isNull(parent)) {
                parent = workflow;
            } else {
                workflow.setParent(parent);
            }
            transaction.saveOrUpdate(workflow);
            //create new workflow history
            transaction.saveOrUpdate(new WfWorkflowHistory(workflow));
            //execute post route process
            if (isNotNull(process.getPostRouteProcess())) {
                process.getPostRouteProcess().invoke(transaction, workflow);
            }
        }
        //
        return newResponse(transaction.execute(), documents, getErrorMessage());
    }

    public synchronized List<WfActivity> getActivitiesBy(UtilUserGroup userRole) {
        return workflowDao.getActivitiesBy(userRole);
    }

    public synchronized List<Long> getDocumentIdsBy(WfActivity activity, UtilUserGroup userRole, UtilUser user) {
        return workflowDao.getDocumentIdsBy(activity, userRole, user);
    }

    public synchronized WfRouting prepareRouting(WfWorkflow workflow) {
        //prepare to routing
        WfRouting routing = new WfRouting();
        for (WfAction action : actionDao.getListBy(workflow.getActivity())) {
            if (isNotNull(action.getActionVisibility())
                    && !getBoolean(action.getActionVisibility().invoke(workflow))) {
                continue;
            }
            routing.getActions().add(action);
            WfTransition transition = transitionDao.getFirstBy(action);
            if (isNotNull(transition) && TransitionRouteType.MANUAL.equals(transition.getTransitionRouteType())) {
                routing.getAction_users().put(action, getUsers4ManualRoute(transition.getDestination()));
            }
        }
        //
        return routing;
    }

    public synchronized void customizeView(CFViewCtrl viewCtrl, WfWorkflow workflow) {
        if (isNotNull(workflow.getActivity().getViewCustomization())) {
            workflow.getActivity().getViewCustomization().invoke(viewCtrl, workflow);
        }
    }

    public synchronized CCResponse route(WfAction action, WfWorkflow workflow) {
        //prepare workflow children
        List<WfWorkflow> workflows = new ArrayList();
        workflows.add(workflow);
        workflows.addAll(workflowDao.getChildren(workflow));
        //route validation
        for (WfWorkflow w : workflows) {
            if (isNotNull(action.getRouteValidation())) {
                CCResponse response = (CCResponse) action.getRouteValidation().invoke(w);
                if (!response.isTrue()) {
                    return response;
                }
            }
        }
        //prepare transitions
        HashMap<WfWorkflow, WfTransition> workflow_transition = new LinkedHashMap();
        HashMap<WfTransition, WfWorkflow> transition_parent = new LinkedHashMap();
        List<WfTransition> transitions = transitionDao.getListBy(action);
        for (WfWorkflow w : workflows) {
            for (WfTransition transition : transitions) {
                if (isNotNull(transition.getRouteAvailability())
                        && !getBoolean(transition.getRouteAvailability().invoke(w))) {
                    continue;
                }
                if (!workflow_transition.containsKey(w)) {
                    workflow_transition.put(w, transition);
                } else {
                    WfWorkflow parallelWorkflow = new WfWorkflow();
                    copy(w, parallelWorkflow);
                    if (action.isMergeable()) {
                        parallelWorkflow.setMerge(w);
                    }
                    if (isNull(parallelWorkflow.getParent())) {
                        transition_parent.put(transition, parallelWorkflow);
                    } else {
                        parallelWorkflow.setParent(transition_parent.get(transition));
                    }
                    workflow_transition.put(parallelWorkflow, transition);
                }
            }
        }
        if (isEmpty(workflow_transition)) {
            return newResponseFalse(No_Transition_Available);
        }
        Transaction transaction = workflowDao.newTransaction();
        //change old workflow history
        for (WfWorkflow w : workflows) {
            WfWorkflowHistory oldWorkflowHistory = workflowHistoryDao.getLastBy(w, w.getActivity(), false);
            if (isNotNull(oldWorkflowHistory)) {
                oldWorkflowHistory.setAction(action);
                transaction.saveOrUpdate(oldWorkflowHistory);
            }
        }
        //update workflow information, create new workflow history, execute post route process
        List<WfWorkflow> deletedWorkflow = new ArrayList();
        for (WfWorkflow w : workflow_transition.keySet()) {
            //update workflow information
            w.setActivity(workflow_transition.get(w).getDestination());
            //
            if (ActivityPointType.MERGE_POINT.equals(w.getActivity().getActivityPointType())
                    && workflowDao.isMergeable(w)) {
                //merge workflow, delete unused parallel workflows
                deletedWorkflow.addAll(0, workflowDao.getParallelWorkflowsBy(w));
                //update workflow information
                WfWorkflow mainWorkflow = coalesce(w.getMerge(), w);
                mainWorkflow.setWorkflowStatus(WorkflowStatus.AVAILABLE);
                transaction.saveOrUpdate(mainWorkflow);
            } else {
                //update workflow information
                TransitionRouteType routeType = workflow_transition.get(w).getTransitionRouteType();
                if (TransitionRouteType.POOLING.equals(routeType)) {
                    w.setUser(null);
                } else if (TransitionRouteType.RANDOM.equals(routeType)) {
                    w.setUser(getUser4RandomRoute(w.getActivity()));
                } else if (TransitionRouteType.WEIGHTAGE.equals(routeType)) {
                    w.setUser(getUser4WeightageRoute(w.getActivity()));
                } else if (TransitionRouteType.ROUND_ROBIN.equals(routeType)) {
                    //get round robin data
                    WfRoundRobin roundRobin = getRoundRobin(w.getActivity());
                    w.setUser(roundRobin.getUser());
                    //update round robin data
                    roundRobin.setLastTask(new Date());
                    transaction.saveOrUpdate(roundRobin);
                } else if (TransitionRouteType.TO_LAST_USER.equals(routeType)) {
                    w.setUser(getUser4ToLastUserRoute(w, w.getActivity()));
                }
                if (isNull(w.getUser()) && isNull(w.getUserRole())) {
                    return newResponseFalse(No_User_Available);
                }
                transaction.saveOrUpdate(w);
                //create new workflow history
                if (isNull(workflowHistoryDao.getLastBy(w, w.getActivity(), false))) {
                    transaction.saveOrUpdate(new WfWorkflowHistory(w));
                }
            }
            //execute post route process
            if (isNotNull(workflow_transition.get(w).getPostRouteProcess())) {
                workflow_transition.get(w).getPostRouteProcess().invoke(transaction, w);
            }
        }
        transaction.delete(deletedWorkflow);
        //
        return newResponse(transaction.execute(), workflow, getErrorMessage());
    }
}