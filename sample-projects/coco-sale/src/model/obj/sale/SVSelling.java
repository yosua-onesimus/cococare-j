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
public class SVSelling implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logChangedOn;
    private Integer logSaveTimes = 0;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLogCreatedBy() {
        return logCreatedBy;
    }

    @Override
    public void setLogCreatedBy(String logCreatedBy) {
        this.logCreatedBy = logCreatedBy;
    }

    @Override
    public Date getLogCreatedOn() {
        return logCreatedOn;
    }

    @Override
    public void setLogCreatedOn(Date logCreatedOn) {
        this.logCreatedOn = logCreatedOn;
    }

    @Override
    public String getLogChangedBy() {
        return logChangedBy;
    }

    @Override
    public void setLogChangedBy(String logChangedBy) {
        this.logChangedBy = logChangedBy;
    }

    @Override
    public Date getLogChangedOn() {
        return logChangedOn;
    }

    @Override
    public void setLogChangedOn(Date logChangedOn) {
        this.logChangedOn = logChangedOn;
    }

    @Override
    public Integer getLogSaveTimes() {
        return logSaveTimes;
    }

    @Override
    public void setLogSaveTimes(Integer logSaveTimes) {
        this.logSaveTimes = logSaveTimes;
    }
//</editor-fold>
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 16, sequence = "[yyyy]/[MM]/[dd]/00", unique = true, requestFocus = true)
    private String code;
    @Column(name = "date_")
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpDate", accessible = Accessible.MANDATORY, maxLength = 12)
    private Date date = new Date();
    @ManyToOne
    @CCFieldConfig(componentId = "bndCustomer", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "@name-@phone")
    private SCustomer customer;
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