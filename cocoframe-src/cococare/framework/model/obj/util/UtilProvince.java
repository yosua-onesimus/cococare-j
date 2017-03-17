package cococare.framework.model.obj.util;

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
@Table(name = "util_provinces")
@CCTypeConfig(label = "Propinsi", uniqueKey = "name", parameter = true)
public class UtilProvince extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "P000", unique = true, visible = false)
    private String code;
    @Column(length = 48)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true)
    private String name;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name", visible = false)
    private UtilCountry country;

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

    public UtilCountry getCountry() {
        return country;
    }

    public void setCountry(UtilCountry country) {
        this.country = country;
    }
//</editor-fold>
}