package model.obj;

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
@Table(name = "dco_dragons")
@CCTypeConfig(label = "Dragon", uniqueKey = "customName", parameter = true, controllerClass = "controller.pseudo.DragonCtrl")
public class Dragon implements CCEntity {

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
    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "D000000", unique = true, requestFocus = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtCustomName", accessible = Accessible.MANDATORY, maxLength = 16)
    private String customName;
    @Column()
    @CCFieldConfig(componentId = "txtSystemName", accessible = Accessible.MANDATORY)
    private String systemName;
    @ManyToOne
    @CCFieldConfig(componentId = "bndHabitatType1", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType1;
    @ManyToOne
    @CCFieldConfig(componentId = "bndHabitatType2", maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType2;
    @ManyToOne
    @CCFieldConfig(componentId = "bndHabitatType3", maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType3;
    @Column(name = "level_")
    @CCFieldConfig(componentId = "txtLevel", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer level = 10;
    @CCFieldConfig(componentId = "txtRevenues", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer revenues;
    @CCFieldConfig(label = "+%", tooltiptext = "Revenues Percent", componentId = "txtRevenuesPercent", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer revenuesPercent;
    @CCFieldConfig(componentId = "txtRevenuesTotal", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 3)
    private Integer revenuesTotal;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public HabitatType getHabitatType1() {
        return habitatType1;
    }

    public void setHabitatType1(HabitatType habitatType1) {
        this.habitatType1 = habitatType1;
    }

    public HabitatType getHabitatType2() {
        return habitatType2;
    }

    public void setHabitatType2(HabitatType habitatType2) {
        this.habitatType2 = habitatType2;
    }

    public HabitatType getHabitatType3() {
        return habitatType3;
    }

    public void setHabitatType3(HabitatType habitatType3) {
        this.habitatType3 = habitatType3;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRevenues() {
        return revenues;
    }

    public void setRevenues(Integer revenues) {
        this.revenues = revenues;
    }

    public Integer getRevenuesPercent() {
        return revenuesPercent;
    }

    public void setRevenuesPercent(Integer revenuesPercent) {
        this.revenuesPercent = revenuesPercent;
    }

    public Integer getRevenuesTotal() {
        return revenuesTotal;
    }

    public void setRevenuesTotal(Integer revenuesTotal) {
        this.revenuesTotal = revenuesTotal;
    }
//</editor-fold>
}