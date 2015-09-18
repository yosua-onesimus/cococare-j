package model.obj.fb;

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

@Entity
@Table(name = "fb_action_types")
@CCTypeConfig(label = "Action Type", uniqueKey = "name", parameter = true)
public class FbActionType extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "AT00", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @ManyToOne
    @CCFieldConfig(maxLength = 16, uniqueKey = "name")
    private FbActionType parent;

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

    public FbActionType getParent() {
        return parent;
    }

    public void setParent(FbActionType parent) {
        this.parent = parent;
    }
//</editor-fold>
}