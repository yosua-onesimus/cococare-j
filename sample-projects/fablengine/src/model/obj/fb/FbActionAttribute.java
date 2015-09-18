package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_action_attributes")
@CCTypeConfig(label = "Attribute", uniqueKey = "attribute.name")
public class FbActionAttribute extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbAction action;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbAttribute attribute;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public FbAction getAction() {
        return action;
    }

    public void setAction(FbAction action) {
        this.action = action;
    }

    public FbAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(FbAttribute attribute) {
        this.attribute = attribute;
    }
//</editor-fold>
}