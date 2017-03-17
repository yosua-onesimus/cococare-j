package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_user_privileges")
@CCTypeConfig(label = "Privilege", uniqueKey = "@privilege.code-@privilege.name")
public class UtilUserPrivilege extends CCEntity {

    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @ManyToOne
    @CCFieldConfig(visible = false)
    private UtilUser user;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, uniqueKey = "name")
    private UtilPrivilege privilege;

//<editor-fold defaultstate="collapsed" desc=" UtilUserPrivilege ">
    public UtilUserPrivilege() {
    }

    public UtilUserPrivilege(UtilUser user, UtilPrivilege privilege) {
        this.user = user;
        this.privilege = privilege;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public UtilUser getUser() {
        return user;
    }

    public void setUser(UtilUser user) {
        this.user = user;
    }

    public UtilPrivilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(UtilPrivilege privilege) {
        this.privilege = privilege;
    }
//</editor-fold>
}