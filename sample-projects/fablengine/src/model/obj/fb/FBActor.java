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
@CCTypeConfig(label = "Actor", uniqueKey = "name", parameter = true, controllerClass = "controller.pseudo.fb.FBActorCtrl")
public class FBActor implements CCEntity {

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
    @CCFieldConfig(group = "General", componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 4, requestFocus = true, sequence = "A000", unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(group = "General", componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32, requestFocus = true)
    private String name;
    @Column(length = 16)
    @CCFieldConfig(group = "General", componentId = "txtCallName", accessible = Accessible.MANDATORY, maxLength = 16, visible = false)
    private String nickName;
    @Column(length = 32)
    @CCFieldConfig(group = "General", componentId = "txtBirthPlace", maxLength = 32, visible = false)
    private String birthPlace;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(group = "General", componentId = "dtpBirthDate", maxLength = 12, visible = false)
    private Date birthDate;
    @CCFieldConfig(group = "General", label = "Gender", componentId = "cmbGender", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$Gender", optionReflectKey = "gender", visible = false)
    private Integer genderIndex;
    @Column(length = 8)
    @CCFieldConfig(maxLength = 8, visible = false, visible2 = false)
    private String gender;
    @CCFieldConfig(group = "General", label = "Blood Type", componentId = "cmbBloodType", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$BloodType", optionReflectKey = "bloodType", visible = false)
    private Integer bloodTypeIndex;
    @Column(length = 4)
    @CCFieldConfig(maxLength = 8, visible = false, visible2 = false)
    private String bloodType;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(group = "General", componentId = "attPhoto", type = Type.THUMB_FILE, optionReflectKey = "photoName", visible = false)
    private byte[] photo;
    @Column(length = 255)
    @CCFieldConfig(visible = false, visible2 = false)
    private String photoName;
    @Column(length = 32)
    @CCFieldConfig(group = "Actor Parameter", componentId = "txtTitle", accessible = Accessible.MANDATORY, maxLength = 32, visible = false)
    private String title;
    @Column(length = 255)
    @CCFieldConfig(group = "Actor Parameter", componentId = "txtDescription", maxLength = Short.MAX_VALUE, visible = false)
    private String description;
    @ManyToOne
    @CCFieldConfig(group = "Actor Parameter", componentId = "bndElement", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FBElement element;
    @CCFieldConfig(group = "Actor Parameter", label = "HP", tooltiptext = "Health Point", componentId = "txtHp", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer hp = 1;
    @CCFieldConfig(group = "Actor Parameter", label = "AP", tooltiptext = "Health Point", componentId = "txtAp", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer ap = 1;
    @CCFieldConfig(group = "Actor Parameter", label = "ExP", tooltiptext = "Experience Point", componentId = "txtExp", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 6, visible = false)
    private Integer exp = 0;
    @Column(name = "level_")
    @CCFieldConfig(group = "Actor Parameter", label = "LVL", tooltiptext = "Level", componentId = "txtLevel", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer level = 1;
    @ManyToOne
    @CCFieldConfig(group = "Class Parameter", componentId = "bndClass", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FBClass class_;
    @CCFieldConfig(group = "Class Parameter", label = "HPM", componentId = "txtHpMax", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer hpMax = 1;
    @CCFieldConfig(group = "Class Parameter", label = "APM", componentId = "txtApMax", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer apMax = 1;
    @CCFieldConfig(group = "Class Parameter", label = "OFF", componentId = "txtOffense", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer offense = 1;
    @CCFieldConfig(group = "Class Parameter", label = "DEF", componentId = "txtDefense", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer defense = 1;
    @CCFieldConfig(group = "Class Parameter", label = "ESS", componentId = "txtEssence", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer essence = 1;
    @CCFieldConfig(group = "Class Parameter", label = "VEL", componentId = "txtVelense", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer velense = 1;
    @CCFieldConfig(group = "Class Parameter", label = "Hit%", componentId = "txtHitRate", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float hitRate = 90f;
    @CCFieldConfig(group = "Class Parameter", label = "Eva%", componentId = "txtEvaRate", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float evaRate = 10f;
    @CCFieldConfig(group = "Class Parameter", label = "Crt%", componentId = "txtCrtRate", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float crtRate = 10f;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Integer getBloodTypeIndex() {
        return bloodTypeIndex;
    }

    public void setBloodTypeIndex(Integer bloodTypeIndex) {
        this.bloodTypeIndex = bloodTypeIndex;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FBElement getElement() {
        return element;
    }

    public void setElement(FBElement element) {
        this.element = element;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAp() {
        return ap;
    }

    public void setAp(Integer ap) {
        this.ap = ap;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public FBClass getClass_() {
        return class_;
    }

    public void setClass_(FBClass class_) {
        this.class_ = class_;
    }

    public Integer getHpMax() {
        return hpMax;
    }

    public void setHpMax(Integer hpMax) {
        this.hpMax = hpMax;
    }

    public Integer getApMax() {
        return apMax;
    }

    public void setApMax(Integer apMax) {
        this.apMax = apMax;
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