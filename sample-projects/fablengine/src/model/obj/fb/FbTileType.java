package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCFormat.getBoolean;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_tile_types")
@CCTypeConfig(label = "Tile Type", uniqueKey = "name", parameter = true)
public class FbTileType extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true, sequence = "TT00", unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @CCFieldConfig(maxLength = 4)
    private Boolean walkable = true;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer movementCost = 1;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(type = Type.IMAGE_FILE, optionReflectKey = "imageName", visible = false)
    private byte[] image;
    @Column(length = 255)
    @CCFieldConfig(visible = false, visible2 = false)
    private String imageName;

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

    public Boolean getWalkable() {
        return walkable;
    }

    public boolean isWalkable() {
        return getBoolean(walkable);
    }

    public void setWalkable(Boolean walkable) {
        this.walkable = walkable;
    }

    public Integer getMovementCost() {
        return movementCost;
    }

    public void setMovementCost(Integer movementCost) {
        this.movementCost = movementCost;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
//</editor-fold>
}