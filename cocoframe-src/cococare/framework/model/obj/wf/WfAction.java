package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCFormat.getBoolean;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
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
@Table(name = "wf_actions")
@CCTypeConfig(label = "Workflow Action", uniqueKey = "name")
public class WfAction extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndActivity", accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name", visible = false, visible2 = false)
    private WfActivity activity;
    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "A000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;
    @ManyToOne
    @CCFieldConfig(componentId = "bndActionVisibility", maxLength = 32, uniqueKey = "name")
    private WfScript actionVisibility;
    @ManyToOne
    @CCFieldConfig(componentId = "bndRouteValidation", maxLength = 32, uniqueKey = "name")
    private WfScript routeValidation;
    @CCFieldConfig(componentId = "chkMergeable", maxLength = 4, visible = false)
    private Boolean mergeable = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfActivity getActivity() {
        return activity;
    }

    public void setActivity(WfActivity activity) {
        this.activity = activity;
    }

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

    public WfScript getActionVisibility() {
        return actionVisibility;
    }

    public void setActionVisibility(WfScript actionVisibility) {
        this.actionVisibility = actionVisibility;
    }

    public WfScript getRouteValidation() {
        return routeValidation;
    }

    public void setRouteValidation(WfScript routeValidation) {
        this.routeValidation = routeValidation;
    }

    public Boolean getMergeable() {
        return mergeable;
    }

    public boolean isMergeable() {
        return getBoolean(mergeable);
    }

    public void setMergeable(Boolean mergeable) {
        this.mergeable = mergeable;
    }
//</editor-fold>
}