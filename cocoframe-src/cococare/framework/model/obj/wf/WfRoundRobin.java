package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.util.UtilUser;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_round_robins")
@CCTypeConfig(label = "Round Robin", uniqueKey = "@activity.name-@user.username-@lastTask")
public class WfRoundRobin extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name")
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(accessible = Accessible.READONLY, type = Type.DATE)
    private Date lastTask = new Date(0);

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfActivity getActivity() {
        return activity;
    }

    public void setActivity(WfActivity activity) {
        this.activity = activity;
    }

    public UtilUser getUser() {
        return user;
    }

    public void setUser(UtilUser user) {
        this.user = user;
    }

    public Date getLastTask() {
        return lastTask;
    }

    public void setLastTask(Date lastTask) {
        this.lastTask = lastTask;
    }
//</editor-fold>
}