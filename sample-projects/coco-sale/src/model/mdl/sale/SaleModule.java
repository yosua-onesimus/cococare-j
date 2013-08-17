package model.mdl.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.sale.SCustomer;
import model.obj.sale.SCustomerPhone;
import model.obj.sale.SVDeposit;
import model.obj.sale.SVOperator;
import model.obj.sale.SVSelling;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class SaleModule extends CCHibernateModule {

    public static SaleModule INSTANCE = new SaleModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(SCustomer.class);
        hibernate.addAnnotatedClass(SCustomerPhone.class);
        //
        hibernate.addAnnotatedClass(SVOperator.class);
        hibernate.addAnnotatedClass(SVVoucherType.class);
        hibernate.addAnnotatedClass(SVDeposit.class);
        hibernate.addAnnotatedClass(SVSelling.class);
    }
//</editor-fold>
}