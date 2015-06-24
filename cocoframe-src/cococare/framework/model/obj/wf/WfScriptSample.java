package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCResponse;
import cococare.database.CCHibernate.Transaction;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.obj.note.NoteNote;
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfScriptSample {

    @WfMethodConfig(scriptName = "viewCustomization", scriptType = ScriptType.VIEW_CUSTOMIZATION)
    public static void viewCustomization(CFViewCtrl viewCtrl, WfWorkflow workflow) {
        System.out.println("viewCustomization START");
        System.out.println("viewCtrl: " + viewCtrl);
        System.out.println("workflow: " + workflow);
        System.out.println("viewCustomization FINISH");
    }

    @WfMethodConfig(scriptName = "transitionVisibility", scriptType = ScriptType.TRANSITION_VISIBILITY)
    public static boolean transitionVisibility(WfWorkflow workflow) {
        System.out.println("transitionVisibility START");
        System.out.println("workflow: " + workflow);
        System.out.println("transitionVisibility FINISH");
        return false;
    }

    @WfMethodConfig(scriptName = "routeValidation", scriptType = ScriptType.ROUTE_VALIDATION)
    public static CCResponse routeValidation(WfWorkflow workflow) {
        System.out.println("routeValidation START");
        System.out.println("workflow: " + workflow);
        System.out.println("routeValidation FINISH");
        return CCResponse.newResponseTrue();
    }

    @WfMethodConfig(scriptName = "routeAvailability", scriptType = ScriptType.ROUTE_AVAILABILITY)
    public static boolean routeAvailability(WfWorkflow workflow) {
        System.out.println("routeAvailability START");
        System.out.println("workflow: " + workflow);
        System.out.println("routeAvailability FINISH");
        return false;
    }

    @WfMethodConfig(scriptName = "postRouteProcess", scriptType = ScriptType.POST_ROUTE_PROCESS)
    public static void postRouteProcess(Transaction transaction, WfWorkflow workflow) {
        System.out.println("postRouteProcess START");
        System.out.println("transaction: " + transaction);
        System.out.println("workflow: " + workflow);
        NoteNote note = workflow.get(WfWorkflow.KEY_ENTITY);
        note.setContent("onesimus");
        System.out.println("postRouteProcess FINISH");
    }
}