package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.Dragon;
import model.obj.Habitat;
import model.obj.HabitatType;
//</editor-fold>

public class DragonCityOrganizerModule extends CCHibernateModule {

    public static DragonCityOrganizerModule INSTANCE = new DragonCityOrganizerModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        hibernate.addAnnotatedClass(HabitatType.class);
        hibernate.addAnnotatedClass(Habitat.class);
        hibernate.addAnnotatedClass(Dragon.class);
    }
//</editor-fold>
}