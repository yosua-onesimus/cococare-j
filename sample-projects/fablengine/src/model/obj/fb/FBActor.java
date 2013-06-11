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
@Table(name = "fb_actors")
@CCTypeConfig(label = "Actor", uniqueKey = "name")
public class FBActor implements CCEntity {

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
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 16, requestFocus = true, unique = true)
    private String name;
    @CCFieldConfig(componentId = "cmbGender", accessible = Accessible.MANDATORY, optionSource = "model.obj.fb.FBEnum$Gender", optionReflectKey = "gender", visible = false)
    private Integer genderIndex;
    @Column(length = 16)
    @CCFieldConfig(maxLength = 16)
    private String gender;
    @ManyToOne
    @CCFieldConfig(componentId = "bndClass", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FBClass class_;
    @Column(name = "level_")
    @CCFieldConfig(label = "LVL", componentId = "txtLevel", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer level = 1;
    @CCFieldConfig(label = "EXP", componentId = "txtExpoint", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 6)
    private Integer expoint = 0;
    @CCFieldConfig(label = "HPM", componentId = "txtHpMax", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer hpMax = 1;
    @CCFieldConfig(label = "HP", componentId = "txtHp", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer hp = 1;
    @CCFieldConfig(label = "APM", componentId = "txtApMax", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer apMax = 1;
    @CCFieldConfig(label = "AP", componentId = "txtAp", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer ap = 1;
    @CCFieldConfig(label = "OFF", componentId = "txtOffense", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer offense = 1;
    @CCFieldConfig(label = "DEF", componentId = "txtDefense", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer defense = 1;
    @CCFieldConfig(label = "ESS", componentId = "txtEssence", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer essence = 1;
    @CCFieldConfig(label = "VEL", componentId = "txtVelense", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer velense = 1;
    @CCFieldConfig(label = "Hit%", componentId = "txtHitRate", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float hitRate = 90f;
    @CCFieldConfig(label = "Eva%", componentId = "txtEvaRate", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float evaRate = 10f;
    @CCFieldConfig(label = "Crt%", componentId = "txtCrtRate", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float crtRate = 10f;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGenderIndex() {
        return genderIndex;
    }

    public void setGenderIndex(Integer genderIndex) {
        this.genderIndex = genderIndex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FBClass getClass_() {
        return class_;
    }

    public void setClass_(FBClass class_) {
        this.class_ = class_;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExpoint() {
        return expoint;
    }

    public void setExpoint(Integer expoint) {
        this.expoint = expoint;
    }

    public Integer getHpMax() {
        return hpMax;
    }

    public void setHpMax(Integer hpMax) {
        this.hpMax = hpMax;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getApMax() {
        return apMax;
    }

    public void setApMax(Integer apMax) {
        this.apMax = apMax;
    }

    public Integer getAp() {
        return ap;
    }

    public void setAp(Integer ap) {
        this.ap = ap;
    }

    public Integer getOffense() {
        return offense;
    }

    public void setOffense(Integer offense) {
        this.offense = offense;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getEssence() {
        return essence;
    }

    public void setEssence(Integer essence) {
        this.essence = essence;
    }

    public Integer getVelense() {
        return velense;
    }

    public void setVelense(Integer velense) {
        this.velense = velense;
    }

    public Float getHitRate() {
        return hitRate;
    }

    public void setHitRate(Float hitRate) {
        this.hitRate = hitRate;
    }

    public Float getEvaRate() {
        return evaRate;
    }

    public void setEvaRate(Float evaRate) {
        this.evaRate = evaRate;
    }

    public Float getCrtRate() {
        return crtRate;
    }

    public void setCrtRate(Float crtRate) {
        this.crtRate = crtRate;
    }
//</editor-fold>
}