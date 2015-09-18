package model.obj.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
//</editor-fold>

@CCTypeConfig(label = "Voucher Module", tooltiptext = "Minimal Profit, Sale Price Round, Agent Service, etc", controllerClass = "controller.pseudo.sale.SVConfigCtrl")
public class SVConfig extends CCEntity {

    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtSaldo", accessible = Accessible.READONLY, type = Type.NUMBER_FORMAT, maxLength = 24, visible2 = false)
    private Double saldo = 0d;
    @CCFieldConfig(componentId = "txtProfit", accessible = Accessible.READONLY, type = Type.NUMBER_FORMAT, maxLength = 24, visible2 = false)
    private Double profit = 0d;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(group = "Sale", componentId = "txtMinimalProfit", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double minimalProfit = 500d;
    @CCFieldConfig(group = "Sale", componentId = "txtSalePriceRound", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double salePriceRound = 1000d;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(group = "Agent Service", componentId = "txtPin", accessible = Accessible.MANDATORY, maxLength = 4)
    private String pin = "1234";
    @CCFieldConfig(group = "Agent Service", componentId = "txtFormatChangePin", accessible = Accessible.MANDATORY)
    private String formatChangePin = "GP.PIN0.PIN1.PIN1";
    @CCFieldConfig(group = "Agent Service", componentId = "txtFormatCheckSaldo", accessible = Accessible.MANDATORY)
    private String formatCheckSaldo = "SAL.PIN";
    @CCFieldConfig(group = "Agent Service", componentId = "txtFormatCheckVoucherPrice", accessible = Accessible.MANDATORY)
    private String formatCheckVoucherPrice = "HP.CD1,CD2,CDX.PIN";
    @CCFieldConfig(group = "Agent Service", componentId = "txtFormatVoucherSelling", accessible = Accessible.MANDATORY)
    private String formatVoucherSelling = "NOMINAL.PHONE.PIN";
    @CCFieldConfig(group = "Agent Service", componentId = "txtFormatComplain", accessible = Accessible.MANDATORY)
    private String formatComplain = "C.COMPLAIN";
    @CCFieldConfig(group = "Agent Service", componentId = "txtCenterPhone", accessible = Accessible.MANDATORY, type = Type.PHONE_NUMBER, maxLength = 16)
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