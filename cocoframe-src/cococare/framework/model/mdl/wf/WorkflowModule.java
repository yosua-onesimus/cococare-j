package cococare.framework.model.mdl.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateModule;
import cococare.framework.model.obj.wf.*;
import java.util.Arrays;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WorkflowModule extends CCHibernateModule {

    public static WorkflowModule INSTANCE = new WorkflowModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    protected List<Class> _getAnnotatedClasses() {
        return (List) Arrays.asList(
                WfScript.class,
                WfTab.class,
                //
                WfProcess.class,
                WfActivity.class,
                WfActivityTab.class,
                WfAction.class,
                WfTransition.class,
                //
                WfRoundRobin.class,
                //
                WfDocument.class,
                WfWorkflow.class,
                WfWorkflowHistory.class);
    }
//</editor-fold>
}