package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_persons")
@CCTypeConfig(label = "Person", uniqueKey = "fullName")
public class UtilPerson extends CCEntity {

//<editor-fold defaultstate="collapsed" desc=" public enum ">
    public enum Gender {

        MALE("Male"), FEMALE("Female");
        private String string;

        private Gender(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum BloodType {

        UNKNOWN("~"), A("A"), B("B"), AB("AB"), O("O");
        private String string;

        private BloodType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum Nationality {

        WNI("WNI"), WNA("WNA");
        private String string;

        private Nationality(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum Religion {

        UNKNOWN("~"), ISLAM("Islam"), PROTESTANTISM("Protestantism"), CATHOLICISM("Catholicism"), HINDUISM("Hinduism"), BUDDHISM("Buddhism"), CONFUCIANISM("Confucianism");
        private String string;

        private Religion(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
//</editor-fold>
    //----------------------------------------------------------------------------------------------
    @Column(length = 12)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "[yyMMdd]/000", unique = true, visible = false)
    private String number;
    //----------------------------------------------------------------------------------------------
    @Column(length = 32)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true)
    private String fullName;
    @Column(length = 16)
    @CCFieldConfig(visible = false)
    private String nickName;
    //----------------------------------------------------------------------------------------------
    @Column(length = 48)
    @CCFieldConfig(accessible = Accessible.MANDATORY, optionSource = "IndonesiaCities.txt", optionReflectKey = "birthPlace")
    private String birthPlace;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.DATE_PAST)
    private Date birthDate;
    @CCFieldConfig(accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$Gender", optionReflectKey = "gender", visible = false)
    private Integer genderIndex;
    @Column(length = 8)
    @CCFieldConfig(visible2 = false)
    private String gender;
    @CCFieldConfig(accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$BloodType", optionReflectKey = "bloodType", visible = false)
    private Integer bloodTypeIndex;
    @Column(length = 4)
    @CCFieldConfig(visible2 = false)
    private String bloodType;
    @CCFieldConfig(accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$Nationality", optionReflectKey = "nationality", visible = false)
    private Integer nationalityIndex;
    @Column(length = 4)
    @CCFieldConfig(visible2 = false)
    private String nationality;
    @CCFieldConfig(accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilPerson$Religion", optionReflectKey = "religion", visible = false)
    private Integer religionIndex;
    @Column(length = 16)
    @CCFieldConfig(visible2 = false)
    private String religion;
    @Column(length = 16, name = "work_")
    @CCFieldConfig(visible = false)
    private String work;
    //----------------------------------------------------------------------------------------------
    @Column(length = 255)
    @CCFieldConfig(maxLength = Short.MAX_VALUE, visible = false)
    private String address;
    @Column(length = 16)
    @CCFieldConfig(tooltiptext = "RT/RW", visible = false)
    private String neighborhood;
    @Column(length = 48)
    @CCFieldConfig(tooltiptext = "Kelurahan", visible = false)
    private String village;
    @Column(length = 48)
    @CCFieldConfig(tooltiptext = "Kecamatan", visible = false)
    private String subDistrict;
    @Column(length = 48)
    @CCFieldConfig(tooltiptext = "Kabupaten", optionSource = "IndonesiaCities.txt", optionReflectKey = "regency", visible = false)
    private String regency;
    @Column(length = 48)
    @CCFieldConfig(tooltiptext = "Propinsi", optionSource = "IndonesiaProvinces.txt", optionReflectKey = "province", visible = false)
    private String province;
    @Column(length = 5)
    @CCFieldConfig(minLength = 5, type = Type.NUMBER_ONLY, visible = false)
    private String zipCode;
    //----------------------------------------------------------------------------------------------
    @Column(length = 16)
    @CCFieldConfig(type = Type.PHONE_NUMBER, visible = false)
    private String phone;
    @Column(length = 16)
    @CCFieldConfig(type = Type.PHONE_NUMBER, visible = false)
    private String fax;
    @Column(length = 16)
    @CCFieldConfig(type = Type.PHONE_NUMBER, visible = false)
    private String handPhone;
    @Column(length = 32)
    @CCFieldConfig(type = Type.EMAIL, visible = false)
    private String email;
    @Column(length = 48)
    @CCFieldConfig(visible = false)
    private String website;
    //----------------------------------------------------------------------------------------------
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(type = Type.THUMB_FILE, optionReflectKey = "photoName", visible = false)
    private byte[] photo;
    @Column(length = 255)
    @CCFieldConfig(visible = false, visible2 = false)
    private String photoName;
    //selfEvident-----------------------------------------------------------------------------------
    @Column(length = 16)
    @CCFieldConfig(label = "KTP", visible = false)
    private String ktp;
    @Column(length = 20)
    @CCFieldConfig(label = "NPWP", visible = false)
    private String npwp;
    @Column(length = 12)
    @CCFieldConfig(visible = false)
    private String passport;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Integer getNationalityIndex() {
        return nationalityIndex;
    }

    public void setNationalityIndex(Integer nationalityIndex) {
        this.nationalityIndex = nationalityIndex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getReligionIndex() {
        return religionIndex;
    }

    public void setReligionIndex(Integer religionIndex) {
        this.religionIndex = religionIndex;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getRegency() {
        return regency;
    }

    public void setRegency(String regency) {
        this.regency = regency;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHandPhone() {
        return handPhone;
    }

    public void setHandPhone(String handPhone) {
        this.handPhone = handPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
//</editor-fold>
}