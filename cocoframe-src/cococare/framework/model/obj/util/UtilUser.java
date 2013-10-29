package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.CompareRule;
import cococare.common.CCFieldConfig.OnDelete;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_users")
@CCTypeConfig(label = "User", uniqueKey = "username")
public class UtilUser implements CCEntity {

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
    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtUsername", accessible = Accessible.MANDATORY, minLength = 4, maxLength = 32, requestFocus = true, unique = true)
    private String username;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtPassword", accessible = Accessible.MANDATORY, minLength = 4, maxLength = 32, compareRule = CompareRule.EQUAL, compareWith = "txtRetypePassword", visible = false)
    private String password;
    @CCFieldConfig(componentId = "txtNewPassword", accessible = Accessible.MANDATORY, minLength = 4, maxLength = 32, requestFocus = true, compareRule = CompareRule.EQUAL, compareWith = "txtRetypePassword", visible = false)
    transient private String newPassword;
    @CCFieldConfig(componentId = "txtRetypePassword", accessible = Accessible.MANDATORY, minLength = 4, maxLength = 32, visible = false)
    transient private String retypePassword;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFullname")
    private String fullname;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUserGroup", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private UtilUserGroup userGroup;
    @CCFieldConfig(componentId = "chkActive", maxLength = 4)
    private Boolean active = true;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "user")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilUserIp> userIps;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "user")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilUserPrivilege> userPrivileges;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" UtilUser ">
    public UtilUser() {
    }

    public UtilUser(String username, String password, String fullname, UtilUserGroup userGroup) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.userGroup = userGroup;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public UtilUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UtilUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
//</editor-fold>
}