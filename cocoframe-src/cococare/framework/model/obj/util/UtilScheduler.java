package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCFormat.getBoolean;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_schedulers")
@CCTypeConfig(label = "Scheduler Module", uniqueKey = "name", tooltiptext = "Scheduler, Batch, Asynchronous, etc", controllerClass = "cococare.framework.model.mdl.util.UtilSchedulerCtrl")
public class UtilScheduler implements CCEntity {

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
    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.READONLY, maxLength = 8, sequence = "Sch000", unique = true)
    private String code;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.READONLY, maxLength = Short.MAX_VALUE)
    private String name;
    @Column(length = 255)
    @CCFieldConfig(visible = false, visible2 = false)
    private String jobClassName;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtCronSchedule", accessible = Accessible.MANDATORY, maxLength = 32, requestFocus = true)
    private String cronSchedule = "0 0 0 * * ?";
    @Column(length = 32)
    @CCFieldConfig(visible2 = false)
    private String lastCheckpointStatus;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CCFieldConfig(visible2 = false)
    private Date lastCheckpointTime;
    @CCFieldConfig(componentId = "chkActive", maxLength = 4)
    private Boolean active = false;

//<editor-fold defaultstate="collapsed" desc=" UtilScheduler ">
    public UtilScheduler() {
    }

    public UtilScheduler(String name, String jobClassName) {
        this.name = name;
        this.jobClassName = jobClassName;
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

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getCronSchedule() {
        return cronSchedule;
    }

    /**
     * Sets the cronSchedule.
     *
     * @param cronSchedule the cronSchedule.
     * @see <a
     * href="http://www.quartz-scheduler.org/documentation/quartz-1.x/tutorials/crontrigger">CronTrigger
     * Tutorial</a>
     */
    public void setCronSchedule(String cronSchedule) {
        this.cronSchedule = cronSchedule;
    }

    public String getLastCheckpointStatus() {
        return lastCheckpointStatus;
    }

    public void setLastCheckpointStatus(String lastCheckpointStatus) {
        this.lastCheckpointStatus = lastCheckpointStatus;
    }

    public Date getLastCheckpointTime() {
        return lastCheckpointTime;
    }

    public void setLastCheckpointTime(Date lastCheckpointTime) {
        this.lastCheckpointTime = lastCheckpointTime;
    }

    public Boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return getBoolean(active);
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
//</editor-fold>
}