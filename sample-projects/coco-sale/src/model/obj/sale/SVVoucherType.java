package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "sale_v_voucher_types")
@CCTypeConfig(label = "Voucher Type", uniqueKey = "@operator.name-@nominal")
public class SVVoucherType extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndOperator", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name", requestFocus = true)
    private SVOperator operator;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtNominal", accessible = Accessible.MANDATORY, maxLength = 16)
    private String nominal;
    @CCFieldConfig(componentId = "txtPurchasePrice", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double purchasePrice = 0d;
    @CCFieldConfig(componentId = "txtSalePrice", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double salePrice = 0d;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "voucherType")
    @CCFieldConfig(onDelete = OnDelete.RESTRICT)
    private List<SVSelling> sellings;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public SVOperator getOperator() {
        return operator;
    }

    public void setOperator(SVOperator operator) {
        this.operator = operator;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
//</editor-fold>
}