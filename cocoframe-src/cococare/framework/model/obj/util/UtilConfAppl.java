package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilConfAppl implements CCEntity {

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

//<editor-fold defaultstate="collapsed" desc=" public enum ">
    public enum MenuPosition {

        LEFT_SIDE("Left Side"), TOP_SIDE("Top Side");
        private String string;

        private MenuPosition(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }
//</editor-fold>
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "cmbApplLanguage", accessible = Accessible.MANDATORY, optionSource = "cococare.common.CCLanguage$LanguagePack", requestFocus = true)
    private Integer applLanguage = 0;
    @CCFieldConfig(componentId = "cmbApplLookAndFeel", accessible = Accessible.MANDATORY, optionSource = "cococare.swing.CCSwing$LookAndFeel")
    private Integer applLookAndFeel = 0;
    @CCFieldConfig(componentId = "cmbApplMenuPosition", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilConfAppl$MenuPosition")
    private Integer applMenuPosition = 0;
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(componentId = "attApplWallpaper", type = Type.IMAGE_FILE, optionReflectKey = "applWallpaperName")
    private byte[] applWallpaper;
    private String applWallpaperName;
    //----------------------------------------------------------------------------------------------
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(componentId = "attCompanyLogo", type = Type.THUMB_FILE, optionReflectKey = "companyLogoName")
    private byte[] companyLogo;
    private String companyLogoName;
    @CCFieldConfig(componentId = "txtCompanyName", accessible = Accessible.MANDATORY)
    private String companyName;
    @CCFieldConfig(componentId = "txtCompanyAddress", accessible = Accessible.MANDATORY)
    private String companyAddress;
    @CCFieldConfig(componentId = "cmbCompanyCity", accessible = Accessible.MANDATORY, optionSource = "IndonesiaCities.txt")
    private Integer companyCity = 147;
    @CCFieldConfig(componentId = "cmbCompanyProvince", accessible = Accessible.MANDATORY, optionSource = "IndonesiaProvinces.txt")
    private Integer companyProvince = 10;
    @CCFieldConfig(componentId = "txtCompanyState", accessible = Accessible.MANDATORY_READONLY)
    private String companyState = "Indonesia";
    @CCFieldConfig(componentId = "txtCompanyPhone", type = Type.PHONE_NUMBER)
    private String companyPhone;
    @CCFieldConfig(componentId = "txtCompanyFax")
    private String companyFax;
    @CCFieldConfig(componentId = "txtCompanyEmail", type = Type.EMAIL)
    private String companyEmail;
    @CCFieldConfig(componentId = "txtCompanyWeb")
    private String companyWeb;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(componentId = "txtOwnerName", accessible = Accessible.MANDATORY)
    private String ownerName;
    @CCFieldConfig(componentId = "txtOwnerPosition")
    private String ownerPosition;
    @CCFieldConfig(componentId = "txtOwnerKtp")
    private String ownerKtp;
    @CCFieldConfig(componentId = "txtOwnerNpwp")
    private String ownerNpwp;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getApplLanguage() {
        return applLanguage;
    }

    public void setApplLanguage(Integer applLanguage) {
        this.applLanguage = applLanguage;
    }

    public Integer getApplLookAndFeel() {
        return applLookAndFeel;
    }

    public void setApplLookAndFeel(Integer applLookAndFeel) {
        this.applLookAndFeel = applLookAndFeel;
    }

    public Integer getApplMenuPosition() {
        return applMenuPosition;
    }

    public void setApplMenuPosition(Integer applMenuPosition) {
        this.applMenuPosition = applMenuPosition;
    }

    public byte[] getApplWallpaper() {
        return applWallpaper;
    }

    public void setApplWallpaper(byte[] applWallpaper) {
        this.applWallpaper = applWallpaper;
    }

    public String getApplWallpaperName() {
        return applWallpaperName;
    }

    public void setApplWallpaperName(String applWallpaperName) {
        this.applWallpaperName = applWallpaperName;
    }

    public byte[] getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(byte[] companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyLogoName() {
        return companyLogoName;
    }

    public void setCompanyLogoName(String companyLogoName) {
        this.companyLogoName = companyLogoName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(Integer companyCity) {
        this.companyCity = companyCity;
    }

    public Integer getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(Integer companyProvince) {
        this.companyProvince = companyProvince;
    }

    public String getCompanyState() {
        return companyState;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyWeb() {
        return companyWeb;
    }

    public void setCompanyWeb(String companyWeb) {
        this.companyWeb = companyWeb;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPosition() {
        return ownerPosition;
    }

    public void setOwnerPosition(String ownerPosition) {
        this.ownerPosition = ownerPosition;
    }

    public String getOwnerKtp() {
        return ownerKtp;
    }

    public void setOwnerKtp(String ownerKtp) {
        this.ownerKtp = ownerKtp;
    }

    public String getOwnerNpwp() {
        return ownerNpwp;
    }

    public void setOwnerNpwp(String ownerNpwp) {
        this.ownerNpwp = ownerNpwp;
    }
//</editor-fold>
}