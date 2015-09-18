package model.obj.lib;

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
@Table(name = "lib_publishers")
@CCTypeConfig(label = "Publisher", uniqueKey = "name", parameter = true)
public class LibPublisher extends CCEntity {

    @Column(length = 6)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 6, sequence = "P000", unique = true, requestFocus = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtRemarks")
    private String remarks;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
//</editor-fold>
}