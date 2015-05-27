package model.bo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.fb.FbMapTileDao;
import model.dao.fb.FbTileTypeDao;
import model.obj.fb.FbMap;
import model.obj.fb.FbMapTile;
import model.obj.fb.FbTileType;
//</editor-fold>

public class FbMapBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private FbTileTypeDao tileTypeDao;
    private FbMapTileDao tileDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized List<FbTileType> getTileTypes() {
        return tileTypeDao.getListUnlimited();
    }

    public synchronized List<FbMapTile> getTilesBy(FbMap map, Integer x) {
        return tileDao.getListUnlimitedBy(map, x);
    }
//</editor-fold>
}