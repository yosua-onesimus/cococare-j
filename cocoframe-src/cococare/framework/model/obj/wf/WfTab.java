package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
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
@Table(name = "wf_tabs")
@CCTypeConfig(label = "Workflow Tab", uniqueKey = "name")
public class WfTab extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, sequence = "T000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 48)
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY)
    private String name;
    @Column(name = "path_", length = 255)
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, visible = false)
    private String path;

//<editor-fold defaultstate="collapsed" desc=" WfTab ">
    public WfTab() {
    }

    public WfTab(String name, String path) {
        this.name = name;
        this.path = path;
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
//</editor-fold>
}