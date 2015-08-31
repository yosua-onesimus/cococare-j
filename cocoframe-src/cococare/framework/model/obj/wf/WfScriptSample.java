package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCResponse;
import cococare.database.CCHibernate.Transaction;
import cococare.framework.common.CFViewCtrl;
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

    @WfMethodConfig(scriptName = "transitionVisibilityIsTrue", scriptType = ScriptType.ACTION_VISIBILITY)
    public static boolean transitionVisibilityIsTrue(WfWorkflow workflow) {
        System.out.println("transitionVisibilityIsTrue START");
        System.out.println("workflow: " + workflow);
        System.out.println("transitionVisibilityIsTrue FINISH");
        return true;
    }

    @WfMethodConfig(scriptName = "transitionVisibilityIsFalse", scriptType = ScriptType.ACTION_VISIBILITY)
    public static boolean transitionVisibilityIsFalse(WfWorkflow workflow) {
        System.out.println("transitionVisibilityIsFalse START");
        System.out.println("workflow: " + workflow);
        System.out.println("transitionVisibilityIsFalse FINISH");
        return false;
    }

    @WfMethodConfig(scriptName = "routeValidationIsTrue", scriptType = ScriptType.ROUTE_VALIDATION)
    public static CCResponse routeValidationIsTrue(WfWorkflow workflow) {
        System.out.println("routeValidationIsTrue START");
        System.out.println("workflow: " + workflow);
        System.out.println("routeValidationIsTrue FINISH");
        return CCResponse.newResponseTrue();
    }

    @WfMethodConfig(scriptName = "routeValidationIsFalse", scriptType = ScriptType.ROUTE_VALIDATION)
    public static CCResponse routeValidationIsFalse(WfWorkflow workflow) {
        System.out.println("routeValidationIsFalse START");
        System.out.println("workflow: " + workflow);
        System.out.println("routeValidationIsFalse FINISH");
        return CCResponse.newResponseFalse("ROUTE NOT VALID");
    }

    @WfMethodConfig(scriptName = "routeAvailabilityIsTrue", scriptType = ScriptType.ROUTE_AVAILABILITY)
    public static boolean routeAvailabilityIsTrue(WfWorkflow workflow) {
        System.out.println("routeAvailabilityIsTrue START");
        System.out.println("workflow: " + workflow);
        System.out.println("routeAvailabilityIsTrue FINISH");
        return true;
    }

    @WfMethodConfig(scriptName = "routeAvailabilityIsFalse", scriptType = ScriptType.ROUTE_AVAILABILITY)
    public static boolean routeAvailabilityIsFalse(WfWorkflow workflow) {
        System.out.println("routeAvailabilityIsFalse START");
        System.out.println("workflow: " + workflow);
        System.out.println("routeAvailabilityIsFalse FINISH");
        return false;
    }

    @WfMethodConfig(scriptName = "postRouteProcess", scriptType = ScriptType.POST_ROUTE_PROCESS)
    public static void postRouteProcess(Transaction transaction, WfWorkflow workflow) {
        System.out.println("postRouteProcess START");
        System.out.println("transaction: " + transaction);
        System.out.println("workflow: " + workflow);
        workflow.setUser(null);
        System.out.println("postRouteProcess FINISH");
    }
}