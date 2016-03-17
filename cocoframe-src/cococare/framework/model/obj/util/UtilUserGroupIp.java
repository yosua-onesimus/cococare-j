package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
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
@Table(name = "util_user_group_ips")
@CCTypeConfig(label = "IP", uniqueKey = "ip")
public class UtilUserGroupIp extends CCEntity {

    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @ManyToOne
    @CCFieldConfig(visible = false)
    private UtilUserGroup userGroup;
    @Column(length = 40)
    @CCFieldConfig(label = "IP", accessible = Accessible.MANDATORY, type = Type.IP)
    private String ip;

//<editor-fold defaultstate="collapsed" desc=" UtilUserGroupIp ">
    public UtilUserGroupIp() {
    }

    public UtilUserGroupIp(UtilUserGroup userGroup, String ip) {
        this.userGroup = userGroup;
        this.ip = ip;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public UtilUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UtilUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
//</editor-fold>
}