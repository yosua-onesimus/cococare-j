package model.bo.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCMath;
import cococare.database.CCHibernateBo;
import model.dao.fb.FBClassDao;
import model.obj.fb.FBClass;
//</editor-fold>

public class FBClassBo extends CCHibernateBo {

    //Dao
    private FBClassDao classDao;
    //Collection & Object
    private FBClass class_;

    public synchronized void load(FBClass class_) {
        //
        this.class_ = class_;
    }

    public synchronized boolean save() {
        CCMath.manipulate(class_, "balance=hp+ap+offense+defense+essence+velense");
        return classDao.saveOrUpdate(class_);
    }
}