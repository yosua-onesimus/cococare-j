package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.wf.WfEnum.TransitionRouteType;
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
@Table(name = "wf_transitions")
@CCTypeConfig(label = "Workflow Transition", uniqueKey = "name")
public class WfTransition extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name", visible = false, visible2 = false)
    private WfAction action;
    @Column(name = "sequence_")
    @CCFieldConfig(label = "#", tooltiptext = "Sequence", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 2)
    private Integer sequence = 0;
    @Column(length = 8)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "T000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 48)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String name;
    @ManyToOne
    @CCFieldConfig(maxLength = 64, uniqueKey = "name")
    private WfScript routeAvailability;
    @CCFieldConfig(label = "Route Type", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.wf.WfEnum$TransitionRouteType", optionReflectKey = "routeType", visible = false)
    private Integer routeTypeIndex = TransitionRouteType.MANUAL.ordinal();
    @Column(length = 24)
    @CCFieldConfig(visible2 = false)
    private String routeType = TransitionRouteType.MANUAL.toString();
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name")
    private WfActivity destination;
    @ManyToOne
    @CCFieldConfig(maxLength = 64, uniqueKey = "name")
    private WfScript postRouteProcess;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfAction getAction() {
        return action;
    }

    public void setAction(WfAction action) {
        this.action = action;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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