package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCLogic.isNotNullAndNotEmpty;
import static cococare.common.CCMath.manipulate;
import static cococare.common.CCMath.solved;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "fb_actions")
@CCTypeConfig(label = "Action", uniqueKey = "name", parameter = true)
public class FBAction implements CCEntity {

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
    @CCFieldConfig(componentId = "bndActionType", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name", requestFocus = true)
    private FBActionType actionType;
    @Column(length = 4)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 4, sequence = "A000", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 16)
    private String name;
    @Column(length = 64)
    @CCFieldConfig(componentId = "txtDescription", maxLength = 64)
    private String description;
    @CCFieldConfig(label = "AP Cost", componentId = "txtApCost", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer apCost = 1;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFormulaPre", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPre;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFormulaMain", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaMain;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtFormulaPost", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPost;
    transient private FBActor caster;
    transient private FBActor target;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public FBActionType getActionType() {
        return actionType;
    }

    public void setAction(FBActionType actionType) {
        this.actionType = actionType;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getApCost() {
        return apCost;
    }

    public void setApCost(Integer apCost) {
        this.apCost = apCost;
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

    public FBActor getCaster() {
        return caster;
    }

    public void setCaster(FBActor caster) {
        this.caster = caster;
    }

    public FBActor getTarget() {
        return target;
    }

    public void setTarget(FBActor target) {
        this.target = target;
    }

    public void execute(FBActor caster, FBActor target) {
        setCaster(caster);
        setTarget(target);
        boolean conditionMeet = true;
        if (isNotNullAndNotEmpty(getFormulaPre())) {
            conditionMeet = solved(this, getFormulaPre());
        }
        if (conditionMeet) {
            if (isNotNullAndNotEmpty(getFormulaMain())) {
                manipulate(this, getFormulaMain());
            }
            if (isNotNullAndNotEmpty(getFormulaPost())) {
                manipulate(this, getFormulaPost());
            }
        }
    }
//</editor-fold>
}