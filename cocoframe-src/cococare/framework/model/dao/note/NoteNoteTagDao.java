package cococare.framework.model.dao.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.note.NotesDao;
import cococare.framework.model.obj.note.NoteNote;
import cococare.framework.model.obj.note.NoteNoteTag;
import cococare.framework.model.obj.note.NoteTag;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NoteNoteTagDao extends NotesDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return NoteNoteTag.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<NoteTag> getListUnlimitedBy(NoteNote note) {
        hql.start().
                alias("nt").
                select("nt.tag").
                where("nt.note = :note");
        parameters.start().
                set("note", note);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public NoteNoteTag getBy(NoteNote note, NoteTag tag) {
        hql.start().
                where("note = :note").
                where("tag = :tag");
        parameters.start().
                set("note", note).
                set("tag", tag);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}