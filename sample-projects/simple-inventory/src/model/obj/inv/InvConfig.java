package model.obj.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

public class InvConfig implements CCEntity {

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
    @CCFieldConfig(componentId = "txtDefaultSalary", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24)
    private Double defaultSalary = 0d;
    @CCFieldConfig(componentId = "txtDefaultBonus", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float defaultBonus = 0f;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Double getDefaultSalary() {
        return defaultSalary;
    }

    public void setDefaultSalary(Double defaultSalary) {
        this.defaultSalary = defaultSalary;
    }

    public Float getDefaultBonus() {
        return defaultBonus;
    }

    public void setDefaultBonus(Float defaultBonus) {
        this.defaultBonus = defaultBonus;
    }
//</editor-fold>
}