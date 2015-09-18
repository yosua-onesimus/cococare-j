package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "dco_dragons")
@CCTypeConfig(label = "Dragon", uniqueKey = "customName", parameter = true, controllerClass = "controller.pseudo.DragonCtrl")
public class Dragon extends CCEntity {

    @Column(length = 9)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 8, sequence = "D000000", unique = true, requestFocus = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(label = "Name", accessible = Accessible.MANDATORY, maxLength = 16)
    private String customName;
    @Column()
    @CCFieldConfig(accessible = Accessible.MANDATORY, visible = false)
    private String systemName;
    @ManyToOne
    @CCFieldConfig(label = "Element1", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType1;
    @ManyToOne
    @CCFieldConfig(label = "Element2", maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType2;
    @ManyToOne
    @CCFieldConfig(label = "Element3", maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType3;
    @ManyToOne
    @CCFieldConfig(label = "Element4", maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType4;
    @Column(name = "level_")
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer level = 10;
    @CCFieldConfig(label = "Rev", tooltiptext = "Revenues", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer revenues = 0;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer revenuesPercent = 0;
    @CCFieldConfig(accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer revenuesTotal = 0;
    //
    @ManyToOne
    @CCFieldConfig(maxLength = 20, uniqueKey = "@habitatType.name #@no", visible2 = false)
    private Habitat habitat;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public HabitatType getHabitatType1() {
        return habitatType1;
    }

    public void setHabitatType1(HabitatType habitatType1) {
        this.habitatType1 = habitatType1;
    }

    public HabitatType getHabitatType2() {
        return habitatType2;
    }

    public void setHabitatType2(HabitatType habitatType2) {
        this.habitatType2 = habitatType2;
    }

    public HabitatType getHabitatType3() {
        return habitatType3;
    }

    public void setHabitatType3(HabitatType habitatType3) {
        this.habitatType3 = habitatType3;
    }

    public HabitatType getHabitatType4() {
        return habitatType4;
    }

    public void setHabitatType4(HabitatType habitatType4) {
        this.habitatType4 = habitatType4;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRevenues() {
        return revenues;
    }

    public void setRevenues(Integer revenues) {
        this.revenues = revenues;
    }

    public Integer getRevenuesPercent() {
        return revenuesPercent;
    }

    public void setRevenuesPercent(Integer revenuesPercent) {
        this.revenuesPercent = revenuesPercent;
    }

    public Integer getRevenuesTotal() {
        return revenuesTotal;
    }

    public void setRevenuesTotal(Integer revenuesTotal) {
        this.revenuesTotal = revenuesTotal;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
//</editor-fold>
}