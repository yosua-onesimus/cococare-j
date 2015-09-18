package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_attributes")
@CCTypeConfig(label = "Attribute", uniqueKey = "name", parameter = true)
public class FbAttribute extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "E000", unique = true)
    private String code;
    //
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, unique = true)
    private String name;
    //
    @CCFieldConfig(group = "Power Multiplier", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer a = -50;
    @CCFieldConfig(group = "Power Multiplier", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer b = 0;
    @CCFieldConfig(group = "Power Multiplier", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer c = 50;
    @CCFieldConfig(group = "Power Multiplier", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer d = 100;
    @CCFieldConfig(group = "Power Multiplier", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer e = 200;
    @CCFieldConfig(group = "Power Multiplier", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer f = 400;

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