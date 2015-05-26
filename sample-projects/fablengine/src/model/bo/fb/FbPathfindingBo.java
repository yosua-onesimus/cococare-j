package model.bo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCMessage.logp;
import java.util.ArrayList;
import java.util.List;
import model.obj.fb.FbMapTile;
//</editor-fold>

public class FbPathfindingBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private List<List<FbMapTile>> mapTiles;
    private FbMapTile originTile;
    private FbMapTile destinationTile;
    private FbMapTile currentTile;
    private List<FbMapTile> nextTile;
    private List<FbMapTile> pastTile;
//</editor-fold>

    public synchronized void init(List<List<FbMapTile>> mapTiles, FbMapTile origin, FbMapTile destination) {
        this.mapTiles = mapTiles;
        this.originTile = origin;
        this.destinationTile = destination;
        this.currentTile = null;
        this.nextTile = new ArrayList();
        this.pastTile = new ArrayList();
        //
        move();
    }

    private synchronized int _countEstimatedCost(FbMapTile origin, FbMapTile destination) {
        return Math.abs(parseInt(origin.getX()) - parseInt(destination.getX()))
                + Math.abs(parseInt(origin.getY()) - parseInt(destination.getY()));
    }

    private synchronized void __determinesNextTile(FbMapTile current, int nextX, int nextY) {
        try {
            FbMapTile tile = (current == null)
                    ? originTile
                    : mapTiles.get(current.getX() + nextX).get(current.getY() + nextY);
            if (!pastTile.contains(tile) && !nextTile.contains(tile)) {
                if (tile.getTileType().isWalkable()) {
                    tile.setCost((current == null) ? 0 : (current.getCost() + 1));
                    tile.setEstimatedCost(_countEstimatedCost(tile, destinationTile));
                    nextTile.add(tile);
                }
            }
        } catch (Exception exception) {
            logp(exception.toString());
        }
    }

    private synchronized void _determinesNextTile() {
        __determinesNextTile(currentTile, 0, +1);
        __determinesNextTile(currentTile, 0, - 1);
        __determinesNextTile(currentTile, - 1, 0);
        __determinesNextTile(currentTile, +1, 0);
    }

    private synchronized FbMapTile _getMinEstimatedCostTile() {
        FbMapTile minEstimatedCostTile = null;
        for (FbMapTile tile : nextTile) {
            if (minEstimatedCostTile == null
                    || (minEstimatedCostTile.getEstimatedCost() > tile.getEstimatedCost())) {
                minEstimatedCostTile = tile;
            }
        }
        return minEstimatedCostTile;
    }

    public synchronized void move() {
        _determinesNextTile();
        currentTile = _getMinEstimatedCostTile();
        nextTile.remove(currentTile);
        pastTile.add(currentTile);
        System.out.println(currentTile.getX() + "," + currentTile.getY());
    }

    public synchronized void moveToDestination() {
        while (currentTile != destinationTile) {
            move();
        }
    }
}