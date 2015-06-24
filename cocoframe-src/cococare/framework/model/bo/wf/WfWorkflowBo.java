package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.copy;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCMessage.getErrorMessage;
import cococare.common.CCResponse;
import cococare.database.CCEntity;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.dao.wf.*;
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
import cococare.framework.model.obj.wf.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfWorkflowBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfActivityDao activityDao;
    private WfTransitionDao transitionDao;
    private WfTransitionDestinationDao transitionDestinationDao;
    private WfWorkflowDao workflowDao;
    private WfWorkflowHistoryDao workflowHistoryDao;
//</editor-fold>

    public synchronized CCResponse createNewWorkflow(CCEntity entity, WfProcess process, WfScript postRouteProcessScript) {
        Transaction transaction = workflowDao.newTransaction();
        //create new workflow
        WfWorkflow workflow = new WfWorkflow();
        workflow.setEntityClassName(entity.getClass().getName());
        workflow.setEntityId(entity.getId());
        workflow.setProcess(process);
        workflow.setActivity(activityDao.getStartPointBy(process));
//        transaction.saveOrUpdate(workflow);
        //create new workflow history
        transaction.saveOrUpdate(new WfWorkflowHistory(workflow));
        //post route process
        if (isNotNull(postRouteProcessScript)
                && ScriptType.POST_ROUTE_PROCESS.equals(postRouteProcessScript.getScriptType())) {
            workflow.put(WfWorkflow.KEY_ENTITY, entity);
            postRouteProcessScript.invoke(transaction, workflow);
        }
        //
//        return CCResponse.newResponse(transaction.execute(), workflow, getErrorMessage());
        return CCResponse.newResponse(true, workflow, getErrorMessage());
    }

    public synchronized void customizeView(WfActivity origin, CFViewCtrl viewCtrl, WfWorkflow workflow) {
        if (isNotNull(origin.getViewCustomization())) {
            origin.getViewCustomization().invoke(viewCtrl, workflow);
        }
    }

    public synchronized List<WfTransition> getTransitions(WfActivity origin, WfWorkflow workflow) {
        List<WfTransition> transitions = transitionDao.getListBy(origin);
        List<WfTransition> transitionsVisible = new ArrayList();
        for (WfTransition transition : transitions) {
            if (isNotNull(transition.getTransitionVisibility())) {
                if (getBoolean(transition.getTransitionVisibility().invoke(workflow))) {
                    transitionsVisible.add(transition);
                }
            }
        }
        return transitionsVisible;
    }

    public synchronized CCResponse route(WfTransition transition, WfWorkflow workflow) {
        //route validation
        if (isNotNull(transition.getRouteValidation())) {
            CCResponse response = (CCResponse) transition.getRouteValidation().invoke(workflow);
            if (!response.isTrue()) {
                return response;
            }
        }
        //
        Transaction transaction = workflowDao.newTransaction();
        //change old workflow history
//        WfWorkflowHistory oldWorkflowHistory = workflowHistoryDao.getLastBy(workflow);
//        oldWorkflowHistory.setTransition(transition);
//        transaction.saveOrUpdate(oldWorkflowHistory);
        //route process I
        HashMap<WfWorkflow, WfScript> workflow_postRouteProcessScript = new HashMap();
        workflow.setActivity(transition.getDestination());
        workflow_postRouteProcessScript.put(workflow, transition.getPostRouteProcess());
        for (WfTransitionDestination extraDestination : transitionDestinationDao.getListBy(transition)) {
            if (isNotNull(extraDestination.getRouteAvailability())) {
                if (!getBoolean(extraDestination.getRouteAvailability().invoke(workflow))) {
                    continue;
                }
            }
            WfWorkflow parallelWorkflow = new WfWorkflow();
            copy(workflow, parallelWorkflow);
            parallelWorkflow.setActivity(extraDestination.getDestination());
            workflow_postRouteProcessScript.put(parallelWorkflow, extraDestination.getPostRouteProcess());
        }
        //route process II
        for (WfWorkflow w : workflow_postRouteProcessScript.keySet()) {
            transaction.saveOrUpdate(w);
            //create new workflow history
            transaction.saveOrUpdate(new WfWorkflowHistory(w));
            //post route process
            if (isNotNull(workflow_postRouteProcessScript.get(w))) {
                workflow_postRouteProcessScript.get(w).invoke(transaction, workflow);
            }
        }
        //
//        return CCResponse.newResponse(transaction.execute(), workflow, getErrorMessage());
        return CCResponse.newResponse(true, workflow, getErrorMessage());
    }
}