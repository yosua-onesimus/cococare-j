package model.dao.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.fb.FableDao;
import model.obj.fb.FbTileType;
//</editor-fold>

public class FbTileTypeDao extends FableDao {

    @Override
    protected Class getEntity() {
        return FbTileType.class;
    }
}