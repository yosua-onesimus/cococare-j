package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import cococare.framework.model.obj.note.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NotesModule extends CCHibernateModule {

    public static NotesModule INSTANCE = new NotesModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(NoteTag.class);
        hibernate.addAnnotatedClass(NoteReference.class);
        hibernate.addAnnotatedClass(NoteNote.class);
        hibernate.addAnnotatedClass(NoteNoteTag.class);
        hibernate.addAnnotatedClass(NoteNoteReference.class);
    }
//</editor-fold>
}