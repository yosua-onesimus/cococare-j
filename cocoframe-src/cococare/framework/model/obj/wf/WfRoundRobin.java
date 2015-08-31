package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
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
public class WfRoundRobin implements CCEntity {

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
    @ManyToOne
    @CCFieldConfig(componentId = "bndActivity", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUser", accessible = Accessible.READONLY, maxLength = 32, uniqueKey = "username")
    private UtilUser user;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(componentId = "dtpLastTask", accessible = Accessible.READONLY, maxLength = 12)
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