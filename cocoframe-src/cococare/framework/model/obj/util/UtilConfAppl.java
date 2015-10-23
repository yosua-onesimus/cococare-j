package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getAssociativeArray;
import static cococare.common.CCClass.getListByAssociativeArray;
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Lob;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@CCTypeConfig(label = "Common/Utility Module", tooltiptext = "Application UI, Company, Company Owner, etc")
public class UtilConfAppl {

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
    @CCFieldConfig(group = "Application Interface", label = "Language", accessible = Accessible.MANDATORY, optionSource = "cococare.common.CCLanguage$LanguagePack", requestFocus = true)
    private Integer applLanguage = 0;
    @CCFieldConfig(group = "Application Interface", label = "Look And Feel", accessible = Accessible.MANDATORY, optionSource = "cococare.swing.CCSwing$LookAndFeel")
    private Integer applLookAndFeel = 0;
    @CCFieldConfig(group = "Application Interface", label = "Menu Position", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.util.UtilConfAppl$MenuPosition")
    private Integer applMenuPosition = 0;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(group = "Application Interface", label = "Wallpaper", type = Type.IMAGE_FILE, optionReflectKey = "applWallpaperName")
    private byte[] applWallpaper;
    private String applWallpaperName;
    //----------------------------------------------------------------------------------------------
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(group = "Company", label = "Logo", type = Type.THUMB_FILE, optionReflectKey = "companyLogoName")
    private byte[] companyLogo;
    private String companyLogoName;
    @CCFieldConfig(group = "Company", label = "Name", accessible = Accessible.MANDATORY)
    private String companyName;
    @CCFieldConfig(group = "Company", label = "Address", accessible = Accessible.MANDATORY)
    private String companyAddress;
    @CCFieldConfig(group = "Company", label = "City", accessible = Accessible.MANDATORY, optionSource = "IndonesiaCities.txt")
    private Integer companyCity = 147;
    @CCFieldConfig(group = "Company", label = "Province", accessible = Accessible.MANDATORY, optionSource = "IndonesiaProvinces.txt")
    private Integer companyProvince = 10;
    @CCFieldConfig(group = "Company", label = "State", accessible = Accessible.MANDATORY_READONLY)
    private String companyState = "Indonesia";
    @CCFieldConfig(group = "Company", label = "Phone", type = Type.PHONE_NUMBER)
    private String companyPhone;
    @CCFieldConfig(group = "Company", label = "Fax")
    private String companyFax;
    @CCFieldConfig(group = "Company", label = "Email", type = Type.EMAIL)
    private String companyEmail;
    @CCFieldConfig(group = "Company", label = "Web")
    private String companyWeb;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(group = "Company Owner", label = "Name", accessible = Accessible.MANDATORY)
    private String ownerName;
    @CCFieldConfig(group = "Company Owner", label = "Position")
    private String ownerPosition;
    @CCFieldConfig(group = "Company Owner", label = "KTP")
    private String ownerKtp;
    @CCFieldConfig(group = "Company Owner", label = "NPWP")
    private String ownerNpwp;
    //----------------------------------------------------------------------------------------------
    private String utilAdditionalTabClass;
    private String utilAdditionalSettingClass;

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

    public List<Class> getUtilAdditionalTabClass() {
        return getListByAssociativeArray(utilAdditionalTabClass);
    }

    public void setUtilAdditionalTabClass(List<String> utilAdditionalTabClass) {
        this.utilAdditionalTabClass = getAssociativeArray(utilAdditionalTabClass, (String) null);
    }

    public List<Class> getUtilAdditionalSettingClass() {
        return getListByAssociativeArray(utilAdditionalSettingClass);
    }

    public void setUtilAdditionalSettingClass(List<String> utilAdditionalSettingClass) {
        this.utilAdditionalSettingClass = getAssociativeArray(utilAdditionalSettingClass, (String) null);
    }
//</editor-fold>
}