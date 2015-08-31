package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.util.UtilArea;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfEnum.WorkflowStatus;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_workflows")
@CCTypeConfig(label = "Workflow Module", uniqueKey = "id", tooltiptext = "All about Workflow: Process, Activity, Action, Transition, etc", controllerClass = "cococare.framework.model.mdl.wf.WfWorkflowCtrl")
public class WfWorkflow implements CCEntity {

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
    @CCFieldConfig(componentId = "bndDocument", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "")
    private WfDocument document;
    @ManyToOne
    @CCFieldConfig(componentId = "bndProcess", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "name")
    private WfProcess process;
    @ManyToOne
    @CCFieldConfig(componentId = "bndActivity", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "name")
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(componentId = "bndArea", accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "name")
    private UtilArea area;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUserRole", accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "name")
    private UtilUserGroup userRole;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUser", accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @ManyToOne
    @CCFieldConfig(componentId = "bndOrigin", accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow origin;
    @ManyToOne
    @CCFieldConfig(componentId = "bndMerge", accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow merge;
    @ManyToOne
    @CCFieldConfig(componentId = "bndParent", accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow parent;
    @CCFieldConfig(label = "Status", componentId = "cmbStatusType", accessible = Accessible.MANDATORY_READONLY, optionSource = "cococare.framework.model.obj.wf.WfEnum$WorkflowStatus", optionReflectKey = "status", visible = false)
    private Integer statusIndex = WorkflowStatus.AVAILABLE.ordinal();
    @Column(length = 12)
    @CCFieldConfig(maxLength = 12, visible2 = false)
    private String status = WorkflowStatus.AVAILABLE.toString();
    //
    transient private HashMap<String, Object> parameter = new HashMap();

//<editor-fold defaultstate="collapsed" desc=" WfWorkflow ">
    public WfWorkflow() {
    }

    public WfWorkflow(WfDocument document, WfProcess process, WfActivity activity) {
        this.document = document;
        this.process = process;
        this.activity = activity;
        this.userRole = activity.getUserRole();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfDocument getDocument() {
        return document;
    }

    public void setDocument(WfDocument document) {
        this.document = document;
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
        setUserRole(activity.getUserRole());
        if (ActivityPointType.MERGE_POINT.equals(activity.getActivityPointType())) {
            setWorkflowStatus(WorkflowStatus.PROCESSING);
        }
    }

    public UtilArea getArea() {
        return area;
    }

    public void setArea(UtilArea area) {
        this.area = area;
    }

    public UtilUserGroup getUserRole() {
        return userRole;
    }

    public void setUserRole(UtilUserGroup userRole) {
        this.userRole = userRole;
    }

    public UtilUser getUser() {
        return user;
    }

    public void setUser(UtilUser user) {
        this.user = user;
    }

    public WfWorkflow getOrigin() {
        return origin;
    }

    public void setOrigin(WfWorkflow origin) {
        this.origin = origin;
    }

    public WfWorkflow getMerge() {
        return merge;
    }

    public void setMerge(WfWorkflow merge) {
        this.merge = merge;
    }

    public WfWorkflow getParent() {
        return parent;
    }

    public void setParent(WfWorkflow parent) {
        this.parent = parent;
    }

    public Integer getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(Integer statusIndex) {
        this.statusIndex = statusIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WorkflowStatus getWorkflowStatus() {
        return WorkflowStatus.values()[getStatusIndex()];
    }

    public void setWorkflowStatus(WorkflowStatus workflowStatus) {
        setStatusIndex(workflowStatus.ordinal());
        setStatus(workflowStatus.toString());
    }

    public <T> T get(String key) {
        return (T) parameter.get(key);
    }

    public Object put(String key, Object value) {
        return parameter.put(key, value);
    }
//</editor-fold>
}