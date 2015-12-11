package cococare.framework.model.mdl.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import cococare.framework.model.obj.wf.*;
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
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(WfScript.class);
        hibernate.addAnnotatedClass(WfTab.class);
        //
        hibernate.addAnnotatedClass(WfProcess.class);
        hibernate.addAnnotatedClass(WfActivity.class);
        hibernate.addAnnotatedClass(WfActivityTab.class);
        hibernate.addAnnotatedClass(WfAction.class);
        hibernate.addAnnotatedClass(WfTransition.class);
        //
        hibernate.addAnnotatedClass(WfRoundRobin.class);
        //
        hibernate.addAnnotatedClass(WfDocument.class);
        hibernate.addAnnotatedClass(WfWorkflow.class);
        hibernate.addAnnotatedClass(WfWorkflowHistory.class);
    }
//</editor-fold>
}