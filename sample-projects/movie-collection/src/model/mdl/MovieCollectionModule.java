package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.Movie;
//</editor-fold>

public class MovieCollectionModule extends CCHibernateModule {

    public static MovieCollectionModule INSTANCE = new MovieCollectionModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        hibernate.addAnnotatedClass(Movie.class);
    }
//</editor-fold>
}