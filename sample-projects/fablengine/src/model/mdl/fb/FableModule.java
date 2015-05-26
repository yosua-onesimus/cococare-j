package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.fb.*;
//</editor-fold>

public class FableModule extends CCHibernateModule {

    public static FableModule INSTANCE = new FableModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(FbAttribute.class);
        hibernate.addAnnotatedClass(FbCondition.class);
        hibernate.addAnnotatedClass(FbActionType.class);
        hibernate.addAnnotatedClass(FbAction.class);
        hibernate.addAnnotatedClass(FbItemType.class);
        //
        hibernate.addAnnotatedClass(FbClass.class);
        hibernate.addAnnotatedClass(FbActor.class);
        //
        hibernate.addAnnotatedClass(FbTileType.class);
    }
//</editor-fold>
}