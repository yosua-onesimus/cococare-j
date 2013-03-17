package cococare.framework.model.mdl.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
import cococare.framework.model.obj.note.NoteBookmark;
import cococare.framework.model.obj.note.NoteObjective;
import cococare.framework.model.obj.note.NoteShortcut;
import cococare.framework.model.obj.note.NoteTracker;
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
        hibernate.addAnnotatedClass(NoteBookmark.class);
        hibernate.addAnnotatedClass(NoteShortcut.class);
        //
        hibernate.addAnnotatedClass(NoteObjective.class);
        hibernate.addAnnotatedClass(NoteTracker.class);
    }
//</editor-fold>
}