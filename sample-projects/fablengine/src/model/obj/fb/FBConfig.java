package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
//</editor-fold>

@CCTypeConfig(label = "FaBlEngine Module", tooltiptext = "Exp Curve, etc")
public class FBConfig {

    @CCFieldConfig(group = "Exp Curve", label = "Base Value", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer expCurveBaseValue = 10;
    @CCFieldConfig(group = "Exp Curve", label = "Extra Value", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer expCurveExtraValue = 10;
    @CCFieldConfig(group = "Exp Curve", label = "Accel A", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer expCurveAccelA = 10;
    @CCFieldConfig(group = "Exp Curve", label = "Accel B", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer expCurveAccelB = 10;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getExpCurveBaseValue() {
        return expCurveBaseValue;
    }

    public void setExpCurveBaseValue(Integer expCurveBaseValue) {
        this.expCurveBaseValue = expCurveBaseValue;
    }

    public Integer getExpCurveExtraValue() {
        return expCurveExtraValue;
    }

    public void setExpCurveExtraValue(Integer expCurveExtraValue) {
        this.expCurveExtraValue = expCurveExtraValue;
    }

    public Integer getExpCurveAccelA() {
        return expCurveAccelA;
    }

    public void setExpCurveAccelA(Integer expCurveAccelA) {
        this.expCurveAccelA = expCurveAccelA;
    }

    public Integer getExpCurveAccelB() {
        return expCurveAccelB;
    }

    public void setExpCurveAccelB(Integer expCurveAccelB) {
        this.expCurveAccelB = expCurveAccelB;
    }
//</editor-fold>
}