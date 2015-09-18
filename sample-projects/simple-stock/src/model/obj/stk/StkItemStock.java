package model.obj.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.ComponentType;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
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
@Table(name = "stk_item_stocks")
@CCTypeConfig(label = "Item Stock", uniqueKey = "@item.name @quantity @item.unit.name", parameter = true)
public class StkItemStock extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentType = ComponentType.COMBOBOX, accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private StkItem item;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.DECIMAL)
    private Double quantity = 0D;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public StkItem getItem() {
        return item;
    }

    public void setItem(StkItem item) {
        this.item = item;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
//</editor-fold>
}