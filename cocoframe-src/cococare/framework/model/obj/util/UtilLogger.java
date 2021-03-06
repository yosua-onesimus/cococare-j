package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_loggers")
@CCTypeConfig(label = "Logger", uniqueKey = "id")
public class UtilLogger extends CCEntity {

    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @Column(length = 40)
    @CCFieldConfig(label = "IP", maxLength = 40)
    private String ip;
    @Column(length = 32)
    @CCFieldConfig(label = "Group Name", maxLength = 32)
    private String userGroupName;
    @Column(length = 32)
    @CCFieldConfig(maxLength = 32)
    private String username;
    @Column(length = 32)
    @CCFieldConfig(maxLength = 32)
    private String screen;
    @Column(length = 32, name = "action_")
    @CCFieldConfig(maxLength = 32)
    private String action;
    @Column(length = 255)
    @CCFieldConfig(maxLength = Short.MAX_VALUE)
    private String note;

//<editor-fold defaultstate="collapsed" desc=" UtilLogger ">
    public UtilLogger() {
    }

    public UtilLogger(String ip, String userGroupName, String username, String screen, String action, String note) {
        this.ip = ip;
        this.userGroupName = userGroupName;
        this.username = username;
        this.screen = screen;
        this.action = action;
        this.note = note;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
//</editor-fold>
}