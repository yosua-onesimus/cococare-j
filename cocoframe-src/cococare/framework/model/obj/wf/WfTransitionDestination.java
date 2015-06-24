package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.wf.WfEnum.TransitionRouteType;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "wf_transition_destinations")
@CCTypeConfig(label = "Workflow Transition Extra Destination", uniqueKey = "destination.name")
public class WfTransitionDestination implements CCEntity {

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
    @CCFieldConfig(componentId = "bndTransition", maxLength = 32, uniqueKey = "name", visible = false)
    private WfTransition transition;
    @ManyToOne
    @CCFieldConfig(componentId = "bndRouteAvailability", maxLength = 32, uniqueKey = "name")
    private WfScript routeAvailability;
    @CCFieldConfig(label = "Route Type", componentId = "cmbRouteType", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.wf.WfEnum$TransitionRouteType", optionReflectKey = "routeType", visible = false)
    private Integer routeTypeIndex = TransitionRouteType.MANUAL.ordinal();
    @Column(length = 24)
    @CCFieldConfig(maxLength = 24, visible2 = false)
    private String routeType = TransitionRouteType.MANUAL.toString();
    @ManyToOne
    @CCFieldConfig(componentId = "bndDestination", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private WfActivity destination;
    @ManyToOne
    @CCFieldConfig(componentId = "bndPostRouteProcess", maxLength = 32, uniqueKey = "name")
    private WfScript postRouteProcess;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfTransition getTransition() {
        return transition;
    }

    public void setTransition(WfTransition transition) {
        this.transition = transition;
    }

    public WfScript getRouteAvailability() {
        return routeAvailability;
    }

    public void setRouteAvailability(WfScript routeAvailability) {
        this.routeAvailability = routeAvailability;
    }

    public Integer getRouteTypeIndex() {
        return routeTypeIndex;
    }

    public void setRouteTypeIndex(Integer routeTypeIndex) {
        this.routeTypeIndex = routeTypeIndex;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public TransitionRouteType getTransitionRouteType() {
        return TransitionRouteType.values()[getRouteTypeIndex()];
    }

    public void setTransitionRouteType(TransitionRouteType transitionRouteType) {
        setRouteTypeIndex(transitionRouteType.ordinal());
        setRouteType(transitionRouteType.toString());
    }

    public WfActivity getDestination() {
        return destination;
    }

    public void setDestination(WfActivity destination) {
        this.destination = destination;
    }

    public WfScript getPostRouteProcess() {
        return postRouteProcess;
    }

    public void setPostRouteProcess(WfScript postRouteProcess) {
        this.postRouteProcess = postRouteProcess;
    }
//</editor-fold>
}