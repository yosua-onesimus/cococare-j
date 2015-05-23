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
    @Column(length = 6)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "A000", unique = true)
    private String code;
    //
    @ManyToOne
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FBActionType actionType;
    @ManyToOne
    @CCFieldConfig(group = "General", maxLength = 16, uniqueKey = "name")
    private FBAttribute attribute;
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY)
    private String name;
    @Column(length = 255)
    @CCFieldConfig(group = "General", maxLength = Short.MAX_VALUE)
    private String description;
    @CCFieldConfig(group = "General", label = "AP Cost", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer apCost = 1;
    //
    @CCFieldConfig(group = "Attribute", label = "Hit%", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6, visible = false)
    private Float hitRate = 90f;
    @CCFieldConfig(group = "Attribute", label = "Var%", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6, visible = false)
    private Float variance = 10f;
    @CCFieldConfig(group = "Attribute", label = "Crt%", accessible = Accessible.MANDATORY, type = Type.DECIMAL, maxLength = 6, visible = false)
    private Float crtRate = 10f;
    //
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Pre", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPre;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Power", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPower;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Main", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaMain;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Post", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPost;
    //
    transient private FBActor caster;
    transient private FBActor target;
    transient private Integer power;
    transient private Integer temp;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public FBActionType getActionType() {
        return actionType;
    }

    public void setActionType(FBActionType actionType) {
        this.actionType = actionType;
    }

    public FBAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(FBAttribute attribute) {
        this.attribute = attribute;
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

    public Float getHitRate() {
        return hitRate;
    }

    public void setHitRate(Float hitRate) {
        this.hitRate = hitRate;
    }

    public Float getVariance() {
        return variance;
    }

    public void setVariance(Float variance) {
        this.variance = variance;
    }

    public Float getCrtRate() {
        return crtRate;
    }

    public void setCrtRate(Float crtRate) {
        this.crtRate = crtRate;
    }

    public String getFormulaPre() {
        return formulaPre;
    }

    public void setFormulaPre(String formulaPre) {
        this.formulaPre = formulaPre;
    }

    public String getFormulaPower() {
        return formulaPower;
    }

    public void setFormulaPower(String formulaPower) {
        this.formulaPower = formulaPower;
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public void execute(FBActor caster, FBActor target) {
        setCaster(caster);
        setTarget(target);
        boolean conditionMeet = true;
        if (isNotNullAndNotEmpty(getFormulaPre())) {
            conditionMeet = solved(this, getFormulaPre());
        }
        if (conditionMeet) {
            setPower(0);
            if (isNotNullAndNotEmpty(getFormulaPower())) {
                manipulate(this, getFormulaPower());
                //insert code here: variance, critical, and multiplier calculation
            }
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