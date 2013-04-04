package model.mdl.sch;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.sch.SchPerson;
import model.obj.sch.SchSchedule;
//</editor-fold>

public class ScheduleModule extends CCHibernateModule {

    public static ScheduleModule INSTANCE = new ScheduleModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(SchPerson.class);
        hibernate.addAnnotatedClass(SchSchedule.class);
    }
//</editor-fold>
}