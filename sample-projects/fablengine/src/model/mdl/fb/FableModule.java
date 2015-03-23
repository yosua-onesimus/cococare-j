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
        hibernate.addAnnotatedClass(FBElement.class);
        hibernate.addAnnotatedClass(FBActionType.class);
        hibernate.addAnnotatedClass(FBAction.class);
        hibernate.addAnnotatedClass(FBItemType.class);
        //
        hibernate.addAnnotatedClass(FBClass.class);
        hibernate.addAnnotatedClass(FBActor.class);
    }
//</editor-fold>
}