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
@Table(name = "fb_item_types")
@CCTypeConfig(label = "Item Type", uniqueKey = "name", parameter = true)
public class FbItemType extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "IT00", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @ManyToOne
    @CCFieldConfig(maxLength = 16, uniqueKey = "name")
    private FbItemType parent;

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

    public FbItemType getParent() {
        return parent;
    }

    public void setParent(FbItemType parent) {
        this.parent = parent;
    }
//</editor-fold>
}