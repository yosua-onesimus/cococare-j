package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

public class SVConfig implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logChangedOn;
    @Version
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
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtSaldo", accessible = Accessible.READONLY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double saldo = 0d;
    @CCFieldConfig(componentId = "txtProfit", accessible = Accessible.READONLY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double profit = 0d;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtMinimalProfit", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double minimalProfit = 500d;
    @CCFieldConfig(componentId = "txtSalePriceRound", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double salePriceRound = 1000d;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtPin", accessible = Accessible.MANDATORY, maxLength = 4)
    private String pin = "1234";
    @CCFieldConfig(componentId = "txtFormatChangePin", accessible = Accessible.MANDATORY)
    private String formatChangePin = "GP.PIN0.PIN1.PIN1";
    @CCFieldConfig(componentId = "txtFormatCheckSaldo", accessible = Accessible.MANDATORY)
    private String formatCheckSaldo = "SAL.PIN";
    @CCFieldConfig(componentId = "txtFormatCheckVoucherPrice", accessible = Accessible.MANDATORY)
    private String formatCheckVoucherPrice = "HP.CD1,CD2,CDX.PIN";
    @CCFieldConfig(componentId = "txtFormatVoucherSelling", accessible = Accessible.MANDATORY)
    private String formatVoucherSelling = "NOMINAL.PHONE.PIN";
    @CCFieldConfig(componentId = "txtFormatComplain", accessible = Accessible.MANDATORY)
    private String formatComplain = "C.COMPLAIN";
    @CCFieldConfig(componentId = "txtCenterPhone", accessible = Accessible.MANDATORY, type = Type.PHONE_NUMBER, maxLength = 16)
    private String centerPhone = "085642258782";

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getMinimalProfit() {
        return minimalProfit;
    }

    public void setMinimalProfit(Double minimalProfit) {
        this.minimalProfit = minimalProfit;
    }

    public Double getSalePriceRound() {
        return salePriceRound;
    }

    public void setSalePriceRound(Double salePriceRound) {
        this.salePriceRound = salePriceRound;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFormatChangePin() {
        return formatChangePin;
    }

    public void setFormatChangePin(String formatChangePin) {
        this.formatChangePin = formatChangePin;
    }

    public String getFormatCheckSaldo() {
        return formatCheckSaldo;
    }

    public void setFormatCheckSaldo(String formatCheckSaldo) {
        this.formatCheckSaldo = formatCheckSaldo;
    }

    public String getFormatCheckVoucherPrice() {
        return formatCheckVoucherPrice;
    }

    public void setFormatCheckVoucherPrice(String formatCheckVoucherPrice) {
        this.formatCheckVoucherPrice = formatCheckVoucherPrice;
    }

    public String getFormatVoucherSelling() {
        return formatVoucherSelling;
    }

    public void setFormatVoucherSelling(String formatVoucherSelling) {
        this.formatVoucherSelling = formatVoucherSelling;
    }

    public String getFormatComplain() {
        return formatComplain;
    }

    public void setFormatComplain(String formatComplain) {
        this.formatComplain = formatComplain;
    }

    public String getCenterPhone() {
        return centerPhone;
    }

    public void setCenterPhone(String centerPhone) {
        this.centerPhone = centerPhone;
    }
//</editor-fold>
}