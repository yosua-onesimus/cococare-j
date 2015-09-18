package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "sale_v_operators")
@CCTypeConfig(label = "Operator", uniqueKey = "@code-@name")
public class SVOperator extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 4, requestFocus = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 16)
    private String name;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "operator")
    @CCFieldConfig(onDelete = OnDelete.RESTRICT)
    private List<SVVoucherType> voucherTypes;
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
//</editor-fold>
}