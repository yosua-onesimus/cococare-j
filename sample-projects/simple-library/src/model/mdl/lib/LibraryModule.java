package model.mdl.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import model.obj.lib.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class LibraryModule extends CCHibernateModule {

    public static LibraryModule INSTANCE = new LibraryModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //parameter
        hibernate.addAnnotatedClass(LibBookType.class);
        hibernate.addAnnotatedClass(LibAuthor.class);
        hibernate.addAnnotatedClass(LibPublisher.class);
        //archive
        hibernate.addAnnotatedClass(LibBook.class);
        hibernate.addAnnotatedClass(LibMember.class);
        //transaction
        hibernate.addAnnotatedClass(LibBorrowing.class);
        hibernate.addAnnotatedClass(LibBorrowingItem.class);
    }
//</editor-fold>
}