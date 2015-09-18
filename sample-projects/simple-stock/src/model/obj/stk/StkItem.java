package model.obj.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.ComponentType;
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
@Table(name = "stk_items")
@CCTypeConfig(label = "Item", uniqueKey = "name", parameter = true)
public class StkItem extends CCEntity {

    @Column(length = 12)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "I000", unique = true, requestFocus = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @ManyToOne
    @CCFieldConfig(componentType = ComponentType.COMBOBOX, accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private StkItemType itemType;
    @ManyToOne
    @CCFieldConfig(componentType = ComponentType.COMBOBOX, accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private StkUnit unit;

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

    public StkItemType getItemType() {
        return itemType;
    }

    public void setItemType(StkItemType itemType) {
        this.itemType = itemType;
    }

    public StkUnit getUnit() {
        return unit;
    }

    public void setUnit(StkUnit unit) {
        this.unit = unit;
    }
//</editor-fold>
}