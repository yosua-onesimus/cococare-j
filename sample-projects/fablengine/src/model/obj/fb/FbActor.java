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
@CCTypeConfig(label = "Actor", uniqueKey = "name", parameter = true, controllerClass = "controller.pseudo.fb.FbActorCtrl")
public class FbActor extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "A000", unique = true)
    private String code;
    //
    @Column(length = 32)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY)
    private String name;
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, visible = false)
    private String nickName;
    @Column(length = 32)
    @CCFieldConfig(group = "General", visible = false)
    private String birthPlace;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(group = "General", type = Type.DATE_PAST, visible = false)
    private Date birthDate;
    @CCFieldConfig(group = "General", label = "Gender", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$Gender", optionReflectKey = "gender", visible = false)
    private Integer genderIndex;
    @Column(length = 8)
    @CCFieldConfig(visible = false, visible2 = false)
    private String gender;
    @CCFieldConfig(group = "General", label = "Blood Type", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$BloodType", optionReflectKey = "bloodType", visible = false)
    private Integer bloodTypeIndex;
    @Column(length = 4)
    @CCFieldConfig(visible = false, visible2 = false)
    private String bloodType;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(group = "General", type = Type.THUMB_FILE, optionReflectKey = "photoName", visible = false)
    private byte[] photo;
    @Column(length = 255)
    @CCFieldConfig(visible = false, visible2 = false)
    private String photoName;
    //
    @Column(length = 32)
    @CCFieldConfig(group = "Actor Attribute", accessible = Accessible.MANDATORY, visible = false)
    private String title;
    @Column(length = 255)
    @CCFieldConfig(group = "Actor Attribute", maxLength = Short.MAX_VALUE, visible = false)
    private String description;
    @ManyToOne
    @CCFieldConfig(group = "Actor Attribute", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbAttribute attribute;
    @CCFieldConfig(group = "Actor Attribute", label = "HP", tooltiptext = "Health Point", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer hp = 1;
    @CCFieldConfig(group = "Actor Attribute", label = "AP", tooltiptext = "Action Point", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer ap = 1;
    @CCFieldConfig(group = "Actor Attribute", label = "LP", tooltiptext = "Lethal Point", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer lp = 10;
    @CCFieldConfig(group = "Actor Attribute", label = "EP", tooltiptext = "Energy Point", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer ep = 100;
    @CCFieldConfig(group = "Actor Attribute", label = "EXP", tooltiptext = "Experience Point", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 6, visible = false)
    private Integer exp = 0;
    @Column(name = "level_")
    @CCFieldConfig(group = "Actor Attribute", label = "LVL", tooltiptext = "Level", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer level = 1;
    //
    @ManyToOne
    @CCFieldConfig(group = "Class Attribute", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbClass class_;
    @CCFieldConfig(group = "Class Attribute", label = "HPM", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer hpMax = 1;
    @CCFieldConfig(group = "Class Attribute", label = "APM", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer apMax = 1;
    @CCFieldConfig(group = "Class Attribute", label = "OFF", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer offense = 1;
    @CCFieldConfig(group = "Class Attribute", label = "DEF", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer defense = 1;
    @CCFieldConfig(group = "Class Attribute", label = "ESS", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer essence = 1;
    @CCFieldConfig(group = "Class Attribute", label = "VEL", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer velense = 1;
    @CCFieldConfig(group = "Class Attribute", label = "Hit%", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float hitRate = 90f;
    @CCFieldConfig(group = "Class Attribute", label = "Eva%", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
    private Float evaRate = 10f;
    @CCFieldConfig(group = "Class Attribute", label = "Crt%", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6)
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

    public FbAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(FbAttribute attribute) {
        this.attribute = attribute;
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

    public Integer getLp() {
        return lp;
    }

    public void setLp(Integer lp) {
        this.lp = lp;
    }

    public Integer getEp() {
        return ep;
    }

    public void setEp(Integer ep) {
        this.ep = ep;
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

    public FbClass getClass_() {
        return class_;
    }

    public void setClass_(FbClass class_) {
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