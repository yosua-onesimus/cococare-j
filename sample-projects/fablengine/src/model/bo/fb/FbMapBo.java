package model.bo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.ArrayList;
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
    private FbMap map;
    private List tileses;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized List<FbTileType> getTileTypes() {
        return tileTypeDao.getListUnlimited();
    }

    public synchronized List<FbMapTile> getTilesBy(FbMap map, Integer x) {
        return tileDao.getListUnlimitedBy(map, x);
    }

    /**
     * Initial map, so getMapTile(x, y) can be used.
     *
     * @param map the map
     */
    public synchronized void initMap(FbMap map) {
        this.map = map;
        this.tileses = new ArrayList();
        for (int x = 0; x < map.getSizeX(); x++) {
            this.tileses.add(getTilesBy(map, x));
        }
    }

    /**
     * Returns the map.
     *
     * @return the map.
     */
    public synchronized FbMap getMap() {
        return map;
    }

    /**
     * Call this method after calling initMap(map).
     *
     * @param x the x.
     * @param y the y.
     * @return the FbMapTile.
     */
    public synchronized FbMapTile getMapTile(int x, int y) {
        return ((List<FbMapTile>) tileses.get(x)).get(y);
    }
//</editor-fold>
}