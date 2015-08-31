package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.getMethod;
import static cococare.common.CCClass.newObject;
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.database.CCHibernate.Transaction;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
import java.lang.reflect.Method;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_scripts")
@CCTypeConfig(label = "Workflow Script", uniqueKey = "name")
public class WfScript implements CCEntity {

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
    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY_READONLY, maxLength = 8, sequence = "S000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY_READONLY, maxLength = 32)
    private String name;
    @Column(name = "path_", length = 255)
    @CCFieldConfig(componentId = "txtPath", accessible = Accessible.MANDATORY_READONLY, visible = false)
    private String path;
    @CCFieldConfig(label = "Type", componentId = "cmbType", accessible = Accessible.MANDATORY_READONLY, optionSource = "cococare.framework.model.obj.wf.WfMethodConfig$ScriptType", optionReflectKey = "type", visible = false)
    private Integer typeIndex;
    @Column(length = 24)
    @CCFieldConfig(maxLength = 24, visible = false, visible2 = false)
    private String type;

//<editor-fold defaultstate="collapsed" desc=" WfScript ">
    public WfScript() {
    }

    public WfScript(String name, String path, ScriptType scriptType) {
        this.name = name;
        this.path = path;
        this.typeIndex = scriptType.ordinal();
        this.type = scriptType.toString();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ScriptType getScriptType() {
        return ScriptType.values()[getTypeIndex()];
    }

    public void setScriptType(ScriptType scriptType) {
        setTypeIndex(scriptType.ordinal());
        setType(scriptType.toString());
    }

    public Object invoke(Object... objects) {
        ScriptType scriptType = getScriptType();
        String[] paths = getPath().split(":");
        Class clazz = CCClass.getClass(paths[0]);
        String methodName = paths[1];
        Method method = null;
        if (ScriptType.VIEW_CUSTOMIZATION.equals(scriptType)) {
            method = getMethod(clazz, methodName, CFViewCtrl.class, WfWorkflow.class);
        } else if (ScriptType.ACTION_VISIBILITY.equals(scriptType)) {
            method = getMethod(clazz, methodName, WfWorkflow.class);
        } else if (ScriptType.ROUTE_VALIDATION.equals(scriptType)) {
            method = getMethod(clazz, methodName, WfWorkflow.class);
        } else if (ScriptType.ROUTE_AVAILABILITY.equals(scriptType)) {
            method = getMethod(clazz, methodName, WfWorkflow.class);
        } else if (ScriptType.POST_ROUTE_PROCESS.equals(scriptType)) {
            method = getMethod(clazz, methodName, Transaction.class, WfWorkflow.class);
        }
        return CCClass.invoke(method, newObject(clazz), objects);
    }
//</editor-fold>
}