package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCLogic.isNull;
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
@Table(name = "wf_processes")
@CCTypeConfig(label = "Workflow Process", uniqueKey = "name")
public class WfProcess extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "P000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 48)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String name;
    @CCFieldConfig(label = "FP", tooltiptext = "First Process", componentId = "chkFirstProcess", maxLength = 4)
    private Boolean firstProcess = true;
    @ManyToOne
    @CCFieldConfig(componentId = "bndAdditionalInput", maxLength = 64, uniqueKey = "name")
    private WfScript additionalInput;
    @ManyToOne
    @CCFieldConfig(componentId = "bndRouteValidation", maxLength = 64, uniqueKey = "name")
    private WfScript routeValidation;
    @ManyToOne
    @CCFieldConfig(componentId = "bndPostRouteProcess", maxLength = 64, uniqueKey = "name")
    private WfScript postRouteProcess;
    @ManyToOne
    @CCFieldConfig(componentId = "bndPostCommitProcess", maxLength = 64, uniqueKey = "name")
    private WfScript postCommitProcess;
    //
    transient private WfRouting routing;

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

    public Boolean getFirstProcess() {
        return firstProcess;
    }

    public void setFirstProcess(Boolean firstProcess) {
        this.firstProcess = firstProcess;
    }

    public WfScript getAdditionalInput() {
        return additionalInput;
    }

    public void setAdditionalInput(WfScript additionalInput) {
        this.additionalInput = additionalInput;
    }

    public WfScript getRouteValidation() {
        return routeValidation;
    }

    public void setRouteValidation(WfScript routeValidation) {
        this.routeValidation = routeValidation;
    }

    public WfScript getPostRouteProcess() {
        return postRouteProcess;
    }

    public void setPostRouteProcess(WfScript postRouteProcess) {
        this.postRouteProcess = postRouteProcess;
    }

    public WfScript getPostCommitProcess() {
        return postCommitProcess;
    }

    public void setPostCommitProcess(WfScript postCommitProcess) {
        this.postCommitProcess = postCommitProcess;
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