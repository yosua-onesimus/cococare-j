package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCMath.manipulate;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "fb_actions")
@CCTypeConfig(label = "Action", uniqueKey = "name")
public class FBAction implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logChangedOn;
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
    @CCFieldConfig(componentId = "cmbActionType", accessible = Accessible.MANDATORY, optionSource = "model.obj.fb.FBEnum$ActionType", optionReflectKey = "actionType", requestFocus = true, visible = false)
    private Integer actionTypeIndex;
    @Column(length = 16)
    @CCFieldConfig(label = "Type", maxLength = 16)
    private String actionType;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 16)
    private String name;
    @Column(length = 64)
    @CCFieldConfig(componentId = "txtDescription", maxLength = 64)
    private String description;
    @Column(name = "condition_", length = 255)
    @CCFieldConfig(componentId = "txtCondition")
    private String condition;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFormulaPre")
    private String formulaPre;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFormulaMain")
    private String formulaMain;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFormulaPost")
    private String formulaPost;
    transient private FBActor caster;
    transient private FBActor target;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getActionTypeIndex() {
        return actionTypeIndex;
    }

    public void setActionTypeIndex(Integer actionTypeIndex) {
        this.actionTypeIndex = actionTypeIndex;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFormulaPre() {
        return formulaPre;
    }

    public void setFormulaPre(String formulaPre) {
        this.formulaPre = formulaPre;
    }

    public String getFormulaMain() {
        return formulaMain;
    }

    public void setFormulaMain(String formulaMain) {
        this.formulaMain = formulaMain;
    }

    public String getFormulaPost() {
        return formulaPost;
    }

    public void setFormulaPost(String formulaPost) {
        this.formulaPost = formulaPost;
    }

    private void setCaster(FBActor caster) {
        this.caster = caster;
    }

    private void setTarget(FBActor target) {
        this.target = target;
    }

    public void execute(FBActor caster, FBActor target) {
        setCaster(caster);
        setTarget(target);
        manipulate(this, formulaMain);
    }
//</editor-fold>
}