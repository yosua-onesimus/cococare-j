package model.dao.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.fb.FableDao;
import model.obj.fb.FBClass;
//</editor-fold>

public class FBClassDao extends FableDao {

    @Override
    protected Class getEntity() {
        return FBClass.class;
    }
}