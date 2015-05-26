package model.dao.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.List;
import model.mdl.fb.FableDao;
import model.obj.fb.FbMap;
import model.obj.fb.FbMapTile;
//</editor-fold>

public class FbMapTileDao extends FableDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return FbMapTile.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public List<FbMapTile> getListUnlimitedBy(FbMap map, Integer x) {
        hql.start().
                where("map = :map").
                where("x = :x").
                orderBy("y ASC");
        parameters.start().
                set("map", map).
                set("x", x);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}