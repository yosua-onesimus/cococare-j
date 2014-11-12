package cococare.framework.model.dao.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.note.NotesDao;
import cococare.framework.model.obj.note.NoteNote;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NoteNoteDao extends NotesDao {

    @Override
    protected Class getEntity() {
        return NoteNote.class;
    }
}