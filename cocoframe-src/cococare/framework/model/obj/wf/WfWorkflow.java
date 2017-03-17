package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.util.UtilArea;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfEnum.WorkflowStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_workflows")
@CCTypeConfig(label = "Workflow Module", uniqueKey = "@document.number-@id", tooltiptext = "All about Workflow: Process, Activity, Action, Transition, etc", controllerClass = "cococare.framework.model.mdl.wf.WfWorkflowCtrl")
public class WfWorkflow extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "number")
    private WfDocument document;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, maxLength = 48, uniqueKey = "name")
    private WfProcess process;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, maxLength = 48, uniqueKey = "name")
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "name")
    private UtilArea area;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, maxLength = 32, uniqueKey = "name")
    private UtilUserGroup userRole;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow origin;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow merge;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.READONLY, uniqueKey = "id")
    private WfWorkflow parent;
    @CCFieldConfig(label = "Status", accessible = Accessible.MANDATORY_READONLY, optionSource = "cococare.framework.model.obj.wf.WfEnum$WorkflowStatus", optionReflectKey = "status", visible = false)
    private Integer statusIndex = WorkflowStatus.AVAILABLE.ordinal();
    @Column(length = 12)
    @CCFieldConfig(maxLength = 12, visible2 = false)
    private String status = WorkflowStatus.AVAILABLE.toString();
    //
    transient private WfRouting routing;

//<editor-fold defaultstate="collapsed" desc=" WfWorkflow ">
    public WfWorkflow() {
    }

    public WfWorkflow(WfDocument document, WfProcess process) {
        this.document = document;
        this.process = process;
        this.routing = process.getRouting();
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
            setWorkflowStatus(WorkflowStatus.WAITING);
        } else if (ActivityPointType.FINAL_POINT.equals(activity.getActivityPointType())) {
            setWorkflowStatus(WorkflowStatus.COMPLETED);
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

    public WfRouting getRouting() {
        if (isNull(routing)) {
            routing = new WfRouting();
        }
        return routing;
    }

    public void setRouting(WfRouting routing) {
        this.routing = routing;
    }
//</editor-fold>
}