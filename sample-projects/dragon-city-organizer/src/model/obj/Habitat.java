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
@Table(name = "dco_habitats")
@CCTypeConfig(label = "Habitat", uniqueKey = "@habitatType.name #@no", parameter = true)
public class Habitat implements CCEntity {

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
    @Column(length = 4)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 4, sequence = "H000", unique = true, requestFocus = true)
    private String code;
    @ManyToOne
    @CCFieldConfig(componentId = "bndHabitatType", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType;
    @Column(name = "no_")
    @CCFieldConfig(componentId = "txtNo", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer no;
    @CCFieldConfig(componentId = "txtRevenuesTotal", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 3)
    private Integer revenuesTotal;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HabitatType getHabitatType() {
        return habitatType;
    }

    public void setHabitatType(HabitatType habitatType) {
        this.habitatType = habitatType;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getRevenuesTotal() {
        return revenuesTotal;
    }

    public void setRevenuesTotal(Integer revenuesTotal) {
        this.revenuesTotal = revenuesTotal;
    }
//</editor-fold>
}