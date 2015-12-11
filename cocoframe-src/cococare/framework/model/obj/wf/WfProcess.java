package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
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
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "P000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;
    @CCFieldConfig(label = "FP", tooltiptext = "First Process", componentId = "chkFirstProcess", maxLength = 4)
    private Boolean firstProcess = true;
    @ManyToOne
    @CCFieldConfig(componentId = "bndPostRouteProcess", maxLength = 32, uniqueKey = "name")
    private WfScript postRouteProcess;

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

    public WfScript getPostRouteProcess() {
        return postRouteProcess;
    }

    public void setPostRouteProcess(WfScript postRouteProcess) {
        this.postRouteProcess = postRouteProcess;
    }
//</editor-fold>
}