package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.InvEmployee;
import model.obj.InvInventory;
import model.obj.InvOwnership;
//</editor-fold>

public class InventoryModule extends CCHibernateModule {

    public static InventoryModule INSTANCE = new InventoryModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(InvEmployee.class);
        hibernate.addAnnotatedClass(InvInventory.class);
        hibernate.addAnnotatedClass(InvOwnership.class);
    }
//</editor-fold>
}