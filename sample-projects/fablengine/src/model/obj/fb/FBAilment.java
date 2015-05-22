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
@Table(name = "fb_ailments")
@CCTypeConfig(label = "Ailment", uniqueKey = "name", parameter = true)
public class FBAilment implements CCEntity {

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
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 4, requestFocus = true, sequence = "E000", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 16, unique = true)
    private String name;
    //
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Pre", componentId = "txtFormulaPre", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPre;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Main", componentId = "txtFormulaMain", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaMain;
    @Column(length = 255)
    @CCFieldConfig(group = "Formula", label = "Post", componentId = "txtFormulaPost", maxLength = Short.MAX_VALUE, visible = false)
    private String formulaPost;
    //
    @CCFieldConfig(group = "Effect Chance", componentId = "txtA", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer a = 0;
    @CCFieldConfig(group = "Effect Chance", componentId = "txtB", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer b = 20;
    @CCFieldConfig(group = "Effect Chance", componentId = "txtC", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer c = 40;
    @CCFieldConfig(group = "Effect Chance", componentId = "txtD", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer d = 60;
    @CCFieldConfig(group = "Effect Chance", componentId = "txtE", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer e = 80;
    @CCFieldConfig(group = "Effect Chance", componentId = "txtF", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer f = 100;

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
//</editor-fold>
}