package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "sale_v_sellings")
@CCTypeConfig(label = "Selling", uniqueKey = "code")
public class SVSelling extends CCEntity {

    @Column(length = 16)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 16, sequence = "[yyyy]/[MM]/[dd]/00", unique = true, requestFocus = true)
    private String code;
    @Column(name = "date_")
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDate", accessible = Accessible.MANDATORY, maxLength = 12)
    private Date date = new Date();
    @ManyToOne
    @CCFieldConfig(componentId = "bndCustomer", accessible = Accessible.NORMAL, maxLength = 32, uniqueKey = "@name-@phone", visible = false)
    private SCustomer customer;
    @ManyToOne
    @CCFieldConfig(componentId = "bndCustomerPhone", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "@customer.name-@phone")
    private SCustomerPhone customerPhone;
    @ManyToOne
    @CCFieldConfig(componentId = "bndVoucherType", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "@operator.name-@nominal")
    private SVVoucherType voucherType;
    @CCFieldConfig(componentId = "txtPurchasePrice", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double purchasePrice = 0d;
    @CCFieldConfig(componentId = "txtSalePrice", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double salePrice = 0d;
    @CCFieldConfig(componentId = "txtAmountPaid", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double amountPaid = 0d;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SCustomer customer) {
        this.customer = customer;
    }

    public SCustomerPhone getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(SCustomerPhone customerPhone) {
        this.customerPhone = customerPhone;
    }

    public SVVoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(SVVoucherType voucherType) {
        this.voucherType = voucherType;
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

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
//</editor-fold>
}