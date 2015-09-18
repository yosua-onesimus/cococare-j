package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_map_tiles")
@CCTypeConfig(label = "Map Tile", uniqueKey = "@map(@x,@y)")
public class FbMapTile extends CCEntity {

    @ManyToOne
    private FbMap map;
    private Integer x = 0;
    private Integer y = 0;
    @ManyToOne
    private FbTileType tileType;
    //
    transient private Object tileView;
    transient private Integer cost = 0;
    transient private Integer estimatedCost = 0;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public FbMap getMap() {
        return map;
    }

    public void setMap(FbMap map) {
        this.map = map;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public FbTileType getTileType() {
        return tileType;
    }

    public void setTileType(FbTileType tileType) {
        this.tileType = tileType;
    }

    public <T> T getTileView() {
        return (T) tileView;
    }

    public void setTileView(Object tileView) {
        this.tileView = tileView;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Integer estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
//</editor-fold>
}