package model.obj.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "inv_employees")
@CCTypeConfig(label = "Employee", uniqueKey = "name")
public class InvEmployee implements CCEntity {

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
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 16, sequence = "EMP/[yyMMdd]/000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY)
    private String name;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtBirthPlace", maxLength = 32, visible = false)
    private String birthPlace;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "dtpBirthDate", type = Type.DATE_PAST, maxLength = 12)
    private Date birthDate;
    @CCFieldConfig(componentId = "cmbGender", accessible = Accessible.MANDATORY, optionSource = "model.obj.inv.InvEnum$Gender", optionReflectKey = "gender", visible = false)
    private Integer genderIndex;
    @Column(length = 8)
    @CCFieldConfig(maxLength = 8)
    private String gender;
    @CCFieldConfig(componentId = "cmbBloodType", accessible = Accessible.MANDATORY, optionSource = "model.obj.inv.InvEnum$BloodType", optionReflectKey = "bloodType", visible = false)
    private Integer bloodTypeIndex;
    @Column(length = 8)
    @CCFieldConfig(maxLength = 8)
    private String bloodType;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtPhone", maxLength = 16, type = Type.PHONE_NUMBER)
    private String phone;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtEmail", maxLength = 32, type = Type.EMAIL)
    private String email;
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(componentId = "attPhoto", type = Type.THUMB_FILE, optionReflectKey = "photoName", visible = false)
    private byte[] photo;
    @Column(length = 255)
    @CCFieldConfig(visible = false)
    private String photoName;
    //
    @CCFieldConfig(componentId = "txtSalary", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double salary = 0d;
    @CCFieldConfig(componentId = "txtBonusPercent", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6, visible = false)
    private Float bonusPercent = 0f;
    @CCFieldConfig(componentId = "txtBonusAmount", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double bonusAmount = 0d;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "employee")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<InvOwnership> ownerships;
//</editor-fold>

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Float getBonusPercent() {
        return bonusPercent;
    }

    public void setBonusPercent(Float bonusPercent) {
        this.bonusPercent = bonusPercent;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
//</editor-fold>
}