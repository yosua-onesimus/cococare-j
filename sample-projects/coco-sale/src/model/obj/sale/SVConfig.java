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
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtBalanceDebit", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double balanceDebit = 0d;
    @CCFieldConfig(componentId = "txtBalanceCredit", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double balanceCredit = 0d;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtMinimalProfit", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double minimalProfit = 500d;
    @CCFieldConfig(componentId = "txtSalePriceRound", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double salePriceRound = 1000d;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Double getBalanceDebit() {
        return balanceDebit;
    }

    public void setBalanceDebit(Double balanceDebit) {
        this.balanceDebit = balanceDebit;
    }

    public Double getBalanceCredit() {
        return balanceCredit;
    }

    public void setBalanceCredit(Double balanceCredit) {
        this.balanceCredit = balanceCredit;
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
//</editor-fold>
}