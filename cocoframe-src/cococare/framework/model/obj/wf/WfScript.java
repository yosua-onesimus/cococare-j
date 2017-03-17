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
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
import java.lang.reflect.Method;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_scripts")
@CCTypeConfig(label = "Workflow Script", uniqueKey = "name")
public class WfScript extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, sequence = "S000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 64)
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY)
    private String name;
    @Column(name = "path_", length = 255)
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, visible = false)
    private String path;
    @CCFieldConfig(label = "Type", accessible = Accessible.MANDATORY_READONLY, optionSource = "cococare.framework.model.obj.wf.WfMethodConfig$ScriptType", optionReflectKey = "type", visible = false)
    private Integer typeIndex;
    @Column(length = 24)
    @CCFieldConfig(visible = false, visible2 = false)
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

    public Class getAdditionalInputClass() {
        if (ScriptType.ADDITIONAL_INPUT.equals(getScriptType())) {
            return CCClass.getClass(getPath());
        } else {
            return null;
        }
    }

    public Object invoke(Object... objects) {
        ScriptType scriptType = getScriptType();
        String[] paths = getPath().split(":");
        Class clazz = CCClass.getClass(paths[0]);
        String methodName = paths[1];
        Method method = null;
        if (ScriptType.ACTION_VISIBILITY.equals(scriptType)) {
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