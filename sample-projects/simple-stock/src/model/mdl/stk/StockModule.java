package model.mdl.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.stk.StkItem;
import model.obj.stk.StkItemStock;
import model.obj.stk.StkItemType;
import model.obj.stk.StkUnit;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class StockModule extends CCHibernateModule {

    public static StockModule INSTANCE = new StockModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //parameter
        hibernate.addAnnotatedClass(StkUnit.class);
        hibernate.addAnnotatedClass(StkItemType.class);
        hibernate.addAnnotatedClass(StkItem.class);
        hibernate.addAnnotatedClass(StkItemStock.class);
    }
//</editor-fold>
}