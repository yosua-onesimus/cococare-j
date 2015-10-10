package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.OnDelete;
import static cococare.common.CCFormat.getBoolean;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_user_groups")
@CCTypeConfig(label = "User Group", uniqueKey = "code")
public class UtilUserGroup extends CCEntity {

    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, minLength = 4, maxLength = 8, requestFocus = true, sequence = "UG000", unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, minLength = 4, maxLength = 32)
    private String name;
    @CCFieldConfig(visible = false)
    private Boolean root = false;
    @CCFieldConfig(componentId = "chkApplyToUser", visible = false)
    transient private boolean applyToUser = false;
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "userGroup")
    @CCFieldConfig(onDelete = OnDelete.RESTRICT)
    private List<UtilUser> users;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "userGroup")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilUserGroupIp> userGroupIps;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "userGroup")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilUserGroupPrivilege> userGroupPrivileges;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" UtilUserGroup ">
    public UtilUserGroup() {
    }

    public UtilUserGroup(String code, String name, boolean root) {
        this.code = code;
        this.name = name;
        this.root = root;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

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

    public boolean isRoot() {
        return getBoolean(root);
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public boolean isApplyToUser() {
        return applyToUser;
    }

    public void setApplyToUser(boolean applyToUser) {
        this.applyToUser = applyToUser;
    }
//</editor-fold>
}