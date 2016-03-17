package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCFormat.getNextDate;
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLogic.coalesce;
import static cococare.common.CCLogic.isNotNull;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.util.UtilUser;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_workflow_histories")
@CCTypeConfig(label = "Workflow History", uniqueKey = "@process.name-@activity.name")
public class WfWorkflowHistory extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndWorkflow", accessible = Accessible.MANDATORY_READONLY, uniqueKey = "@document.number-@id")
    private WfWorkflow workflow;
    @ManyToOne
    @CCFieldConfig(componentId = "bndProcess", accessible = Accessible.MANDATORY_READONLY, maxLength = 48, uniqueKey = "name")
    private WfProcess process;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateAssigned", accessible = Accessible.READONLY, type = Type.DATE)
    private Date dateAssigned;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateClaimed", accessible = Accessible.READONLY, type = Type.DATE)
    private Date dateClaimed;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateDue", accessible = Accessible.READONLY, type = Type.DATE)
    private Date dateDue;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateProcessed", accessible = Accessible.READONLY, type = Type.DATE)
    private Date dateProcessed;
    @ManyToOne
    @CCFieldConfig(componentId = "bndActivity", accessible = Accessible.MANDATORY_READONLY, maxLength = 48, uniqueKey = "name")
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUser", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @ManyToOne
    @CCFieldConfig(componentId = "bndAction", accessible = Accessible.READONLY, maxLength = 48, uniqueKey = "name")
    private WfAction action;

//<editor-fold defaultstate="collapsed" desc=" WfWorkflowHistory ">
    public WfWorkflowHistory() {
    }

    public WfWorkflowHistory(WfWorkflow workflow) {
        setWorkflow(workflow);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfWorkflow getWorkflow() {
        return workflow;
    }

    public final void setWorkflow(WfWorkflow workflow) {
        this.workflow = coalesce(workflow.getMerge(), workflow);
        setProcess(workflow.getProcess());
        setActivity(workflow.getActivity());
        setDateAssigned(new Date());
        setUser(workflow.getUser());
        setDateDue(getNextDate(getDateAssigned(), parseInt(workflow.getActivity().getDayLimit())));
    }

    public WfProcess getProcess() {
        return process;
    }

    public void setProcess(WfProcess process) {
        this.process = process;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public Date getDateClaimed() {
        return dateClaimed;
    }

    public void setDateClaimed(Date dateClaimed) {
        this.dateClaimed = dateClaimed;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public Date getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(Date dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public WfActivity getActivity() {
        return activity;
    }

    public void setActivity(WfActivity activity) {
        this.activity = activity;
    }

    public UtilUser getUser() {
        return user;
    }

    public void setUser(UtilUser user) {
        this.user = user;
        if (isNotNull(user)) {
            setDateClaimed(new Date());
        }
    }

    public WfAction getAction() {
        return action;
    }

    public void setAction(WfAction action) {
        this.action = action;
        if (isNotNull(action)) {
            setDateProcessed(new Date());
        }
    }
//</editor-fold>
}