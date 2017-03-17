package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
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
@Table(name = "util_zip_codes")
@CCTypeConfig(label = "Kode Pos", uniqueKey = "code", parameter = true)
public class UtilZipCode extends CCEntity {

    @Column(length = 5)
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMBER_ONLY, unique = true)
    private String code;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name", visible = false)
    private UtilVillage village;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UtilVillage getVillage() {
        return village;
    }

    public void setVillage(UtilVillage village) {
        this.village = village;
    }
//</editor-fold>
}