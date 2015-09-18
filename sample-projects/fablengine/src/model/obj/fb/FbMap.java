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
@Table(name = "fb_maps")
@CCTypeConfig(label = "Map", uniqueKey = "name", parameter = true, controllerClass = "controller.form.fb.PnlMapCtrl")
public class FbMap extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "M00", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer sizeX = 1;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer sizeY = 1;

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

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }
//</editor-fold>
}