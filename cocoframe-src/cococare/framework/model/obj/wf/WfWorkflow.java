package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.util.UtilArea;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
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
@CCTypeConfig(label = "Workflow Module", uniqueKey = "id", tooltiptext = "All about Workflow: Process, Activity, Transition, etc", controllerClass = "cococare.framework.model.mdl.wf.WfWorkflowCtrl")
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
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtEntityClassName", accessible = Accessible.MANDATORY_READONLY)
    private String entityClassName;
    @CCFieldConfig(componentId = "txtEntityId", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC)
    private Long entityId;
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
    @CCFieldConfig(componentId = "bndUserGroup", accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "name")
    private UtilUserGroup userGroup;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUser", accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @ManyToOne
    @CCFieldConfig(componentId = "bndOrigin", accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow origin;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtMergeId", accessible = Accessible.READONLY)
    private String mergeId;
    @CCFieldConfig(label = "Status", componentId = "cmbStatusType", accessible = Accessible.MANDATORY_READONLY, optionSource = "cococare.framework.model.obj.wf.WfEnum$WorkflowStatus", optionReflectKey = "status", visible = false)
    private Integer statusIndex = WorkflowStatus.AVAILABLE.ordinal();
    @Column(length = 12)
    @CCFieldConfig(maxLength = 12, visible2 = false)
    private String status = WorkflowStatus.AVAILABLE.toString();
    //
    transient private HashMap<String, Object> parameter = new HashMap();
    //
    transient public static final String KEY_ENTITY = "ENTITY";

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getEntityClassName() {
        return entityClassName;
    }

    public void setEntityClassName(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
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

    public UtilArea getArea() {
        return area;
    }

    public void setArea(UtilArea area) {
        this.area = area;
    }

    public UtilUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UtilUserGroup userGroup) {
        this.userGroup = userGroup;
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

    public String getMergeId() {
        return mergeId;
    }

    public void setMergeId(String mergeId) {
        this.mergeId = mergeId;
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