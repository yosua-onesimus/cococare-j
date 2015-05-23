package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
//</editor-fold>

@Entity
@Table(name = "fb_conditions")
@CCTypeConfig(label = "Condition", uniqueKey = "name", parameter = true)
public class FBCondition implements CCEntity {

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
    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "E000", unique = true)
    private String code;
    //
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, unique = true)
    private String name;
    //
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Pre", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPre;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Main", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaMain;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Post", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPost;
    @CCFieldConfig(group = "Formula", visible = false)
    private Boolean canCauseDeath = false;
    //
    @CCFieldConfig(group = "Effect", visible = false)
    private Boolean atkAlliesRnd = false;
    @CCFieldConfig(group = "Effect", visible = false)
    private Boolean atkEnemiesRnd = false;
    @CCFieldConfig(group = "Effect", visible = false)
    private Boolean noGeneralAct = false;
    @CCFieldConfig(group = "Effect", visible = false)
    private Boolean noPsychicAct = false;
    @CCFieldConfig(group = "Effect", visible = false)
    private Boolean noPsionicAct = false;
    @CCFieldConfig(group = "Effect", visible = false)
    private Boolean noChangeEquip = false;
    @CCFieldConfig(group = "Effect", label = "", visible = false)
    private Boolean nullifyDamage = false;
    @CCFieldConfig(group = "Effect", label = "", visible = false)
    private Boolean counterDamage = false;
    @CCFieldConfig(group = "Effect", label = "", visible = false)
    private Boolean reflectDamage = false;
    //
    @CCFieldConfig(group = "Effect Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer a = 0;
    @CCFieldConfig(group = "Effect Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer b = 20;
    @CCFieldConfig(group = "Effect Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer c = 40;
    @CCFieldConfig(group = "Effect Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer d = 60;
    @CCFieldConfig(group = "Effect Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer e = 80;
    @CCFieldConfig(group = "Effect Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer f = 100;
    //
    @CCFieldConfig(group = "Cancel Chance", label = "By Damage (%)", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer cancelByDamage = 0;
    @CCFieldConfig(group = "Cancel Chance", label = "After ? Turn", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer cancelAfterTurn = 0;
    @CCFieldConfig(group = "Cancel Chance", label = "By Turn (%)", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer cancelByTurn = 0;
    @CCFieldConfig(group = "Cancel Chance", label = "At Battle End", visible = false)
    private Boolean cancelAtBattleEnd = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
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

    public Boolean getCanCauseDeath() {
        return canCauseDeath;
    }

    public void setCanCauseDeath(Boolean canCauseDeath) {
        this.canCauseDeath = canCauseDeath;
    }

    public Boolean getAtkAlliesRnd() {
        return atkAlliesRnd;
    }

    public void setAtkAlliesRnd(Boolean atkAlliesRnd) {
        this.atkAlliesRnd = atkAlliesRnd;
    }

    public Boolean getAtkEnemiesRnd() {
        return atkEnemiesRnd;
    }

    public void setAtkEnemiesRnd(Boolean atkEnemiesRnd) {
        this.atkEnemiesRnd = atkEnemiesRnd;
    }

    public Boolean getNoGeneralAct() {
        return noGeneralAct;
    }

    public void setNoGeneralAct(Boolean noGeneralAct) {
        this.noGeneralAct = noGeneralAct;
    }

    public Boolean getNoPsychicAct() {
        return noPsychicAct;
    }

    public void setNoPsychicAct(Boolean noPsychicAct) {
        this.noPsychicAct = noPsychicAct;
    }

    public Boolean getNoPsionicAct() {
        return noPsionicAct;
    }

    public void setNoPsionicAct(Boolean noPsionicAct) {
        this.noPsionicAct = noPsionicAct;
    }

    public Boolean getNoChangeEquip() {
        return noChangeEquip;
    }

    public void setNoChangeEquip(Boolean noChangeEquip) {
        this.noChangeEquip = noChangeEquip;
    }

    public Boolean getNullifyDamage() {
        return nullifyDamage;
    }

    public void setNullifyDamage(Boolean nullifyDamage) {
        this.nullifyDamage = nullifyDamage;
    }

    public Boolean getCounterDamage() {
        return counterDamage;
    }

    public void setCounterDamage(Boolean counterDamage) {
        this.counterDamage = counterDamage;
    }

    public Boolean getReflectDamage() {
        return reflectDamage;
    }

    public void setReflectDamage(Boolean reflectDamage) {
        this.reflectDamage = reflectDamage;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public Integer getCancelByDamage() {
        return cancelByDamage;
    }

    public void setCancelByDamage(Integer cancelByDamage) {
        this.cancelByDamage = cancelByDamage;
    }

    public Integer getCancelAfterTurn() {
        return cancelAfterTurn;
    }

    public void setCancelAfterTurn(Integer cancelAfterTurn) {
        this.cancelAfterTurn = cancelAfterTurn;
    }

    public Integer getCancelByTurn() {
        return cancelByTurn;
    }

    public void setCancelByTurn(Integer cancelByTurn) {
        this.cancelByTurn = cancelByTurn;
    }

    public Boolean getCancelAtBattleEnd() {
        return cancelAtBattleEnd;
    }

    public void setCancelAtBattleEnd(Boolean cancelAtBattleEnd) {
        this.cancelAtBattleEnd = cancelAtBattleEnd;
    }
//</editor-fold>
}