package model.obj.fb;

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
@Table(name = "fb_maps")
@CCTypeConfig(label = "Map", uniqueKey = "name", parameter = true, controllerClass = "controller.form.fb.PnlMapCtrl")
public class FbMap implements CCEntity {

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
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "M00", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer sizeX = 1;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer sizeY = 1;

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

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }
//</editor-fold>
}