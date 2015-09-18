package model.obj.stk;

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
@Table(name = "stk_units")
@CCTypeConfig(label = "Unit", uniqueKey = "name", parameter = true)
public class StkUnit extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 8, unique = true, requestFocus = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;

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
//</editor-fold>
}