package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
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
public class WfWorkflowHistory implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logChangedOn;
    @Version
    private Integer logSaveTimes = 0;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLogCreatedBy() {
        return logCreatedBy;
    }

    @Override
    public void setLogCreatedBy(String logCreatedBy) {
        this.logCreatedBy = logCreatedBy;
    }

    @Override
    public Date getLogCreatedOn() {
        return logCreatedOn;
    }

    @Override
    public void setLogCreatedOn(Date logCreatedOn) {
        this.logCreatedOn = logCreatedOn;
    }

    @Override
    public String getLogChangedBy() {
        return logChangedBy;
    }

    @Override
    public void setLogChangedBy(String logChangedBy) {
        this.logChangedBy = logChangedBy;
    }

    @Override
    public Date getLogChangedOn() {
        return logChangedOn;
    }

    @Override
    public void setLogChangedOn(Date logChangedOn) {
        this.logChangedOn = logChangedOn;
    }

    @Override
    public Integer getLogSaveTimes() {
        return logSaveTimes;
    }

    @Override
    public void setLogSaveTimes(Integer logSaveTimes) {
        this.logSaveTimes = logSaveTimes;
    }
//</editor-fold>
    @ManyToOne
    @CCFieldConfig(componentId = "bndWorkflow", accessible = Accessible.MANDATORY_READONLY, uniqueKey = "id")
    private WfWorkflow workflow;
    @ManyToOne
    @CCFieldConfig(componentId = "bndProcess", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "name")
    private WfProcess process;
    @ManyToOne
    @CCFieldConfig(componentId = "bndActivity", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "name")
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUser", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateAssigned", accessible = Accessible.READONLY, maxLength = 12)
    private Date dateAssigned;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateClaimed", accessible = Accessible.READONLY, maxLength = 12)
    private Date dateClaimed;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateDue", accessible = Accessible.READONLY, maxLength = 12)
    private Date dateDue;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDateProcessed", accessible = Accessible.READONLY, maxLength = 12)
    private Date dateProcessed;
    @ManyToOne
    @CCFieldConfig(componentId = "bndTransition", accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "name")
    private WfTransition transition;

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
        this.workflow = workflow;
        setProcess(workflow.getProcess());
        setActivity(workflow.getActivity());
        setUser(workflow.getUser());
        setDateAssigned(new Date());
    }

    public WfProcess getProcess() {
        return process;
    }

    public void setProcess(WfProcess process) {
        this.process = process;
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

    public WfTransition getTransition() {
        return transition;
    }

    public void setTransition(WfTransition transition) {
        this.transition = transition;
        setDateProcessed(new Date());
    }
//</editor-fold>
}