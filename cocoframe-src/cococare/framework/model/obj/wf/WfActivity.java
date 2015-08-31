package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_activities")
@CCTypeConfig(label = "Workflow Activity", uniqueKey = "name")
public class WfActivity implements CCEntity {

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
    @CCFieldConfig(componentId = "bndProcess", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name", visible = false, visible2 = false)
    private WfProcess process;
    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "A000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;
    @ManyToOne
    @CCFieldConfig(componentId = "bndViewCustomization", maxLength = 32, uniqueKey = "name")
    private WfScript viewCustomization;
    @CCFieldConfig(componentId = "txtDayLimit", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4)
    private Integer dayLimit = 5;
    @ManyToOne
    @CCFieldConfig(componentId = "bndUserRole", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private UtilUserGroup userRole;
    @CCFieldConfig(componentId = "txtWeight", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4)
    private Integer weight = 1;
    @CCFieldConfig(label = "Point Type", componentId = "cmbPointType", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.wf.WfEnum$ActivityPointType", optionReflectKey = "pointType", visible = false)
    private Integer pointTypeIndex = ActivityPointType.PLAIN_POINT.ordinal();
    @Column(length = 12)
    @CCFieldConfig(maxLength = 12, visible2 = false)
    private String pointType = ActivityPointType.PLAIN_POINT.toString();

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfProcess getProcess() {
        return process;
    }

    public void setProcess(WfProcess process) {
        this.process = process;
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

    public WfScript getViewCustomization() {
        return viewCustomization;
    }

    public void setViewCustomization(WfScript viewCustomization) {
        this.viewCustomization = viewCustomization;
    }

    public Integer getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(Integer dayLimit) {
        this.dayLimit = dayLimit;
    }

    public UtilUserGroup getUserRole() {
        return userRole;
    }

    public void setUserRole(UtilUserGroup userRole) {
        this.userRole = userRole;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPointTypeIndex() {
        return pointTypeIndex;
    }

    public void setPointTypeIndex(Integer pointTypeIndex) {
        this.pointTypeIndex = pointTypeIndex;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public ActivityPointType getActivityPointType() {
        return ActivityPointType.values()[getPointTypeIndex()];
    }

    public void setActivityPointType(ActivityPointType activityPointType) {
        setPointTypeIndex(activityPointType.ordinal());
        setPointType(activityPointType.toString());
    }
//</editor-fold>
}