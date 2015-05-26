package test;

import cococare.common.CCClass;
import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import cococare.framework.model.mdl.util.UtilityModule;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.dao.fb.FbMapTileDao;
import model.mdl.fb.FableModule;
import model.obj.fb.FbMap;
import model.obj.fb.FbMapTile;
import model.obj.fb.FbTileType;

public class Test2 {

    public static void sample() {
        Integer[][] xyss = new Integer[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        for (Integer[] xys : xyss) {
            for (Integer xy : xys) {
            }
        }
    }

    public static CCHibernate newHibernate() {
        CCHibernate hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(new File(CCFile.getFileSystConfPath(), "dtbs.conf"));
        UtilityModule.INSTANCE.init(hibernate);
        FableModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();
        return hibernate;
    }

    public static void generateMapTile() {
        CCHibernate hibernate = newHibernate();
        FbMap map = hibernate.get(FbMap.class, 1L);
        FbTileType jalan = hibernate.get(FbTileType.class, 1L);
        FbTileType tembok = hibernate.get(FbTileType.class, 2L);
        System.out.println(CCClass.getAssociativeArray(map, null));
        System.out.println(CCClass.getAssociativeArray(jalan, null));
        System.out.println(CCClass.getAssociativeArray(tembok, null));
        for (int x = 0; x < map.getSizeX(); x++) {
            for (int y = 0; y < map.getSizeY(); y++) {
                FbMapTile tile = new FbMapTile();
                tile.setMap(map);
                tile.setX(x);
                tile.setY(y);
                if ((x == 1 && y == 1)
                        || (x == 3 && (y >= 1 && y <= 4))) {
                    tile.setTileType(tembok);
                } else {
                    tile.setTileType(jalan);
                }
                hibernate.saveOrUpdate(tile);
            }
        }
    }

    public static void loadMapTile() {
        CCHibernate hibernate = newHibernate();
        FbMapTileDao tileDao = new FbMapTileDao();
        FbMap map = hibernate.get(FbMap.class, 1L);
        List<List<FbMapTile>> tileses = new ArrayList();
        for (int x = 0; x < map.getSizeX(); x++) {
            tileses.add(tileDao.getListUnlimitedBy(map, x));
        }
    }

    public static void main(String[] args) {
//        generateMapTile();
    }
}