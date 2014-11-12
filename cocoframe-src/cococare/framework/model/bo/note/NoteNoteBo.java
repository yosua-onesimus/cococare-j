package cococare.framework.model.bo.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.*;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.note.NoteNoteDao;
import cococare.framework.model.dao.note.NoteNoteTagDao;
import cococare.framework.model.dao.note.NoteTagDao;
import cococare.framework.model.obj.note.NoteNote;
import cococare.framework.model.obj.note.NoteNoteTag;
import cococare.framework.model.obj.note.NoteTag;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class NoteNoteBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private NoteTagDao tagDao;
    private NoteNoteDao noteDao;
    private NoteNoteTagDao noteTagDao;
    private NoteNote note;
    private List<NoteTag> selectedTags;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized void load(NoteNote note) {
        this.note = note;
        if (isNull(note.getId())) {
            selectedTags = new ArrayList();
        } else {
            selectedTags = noteTagDao.getListUnlimitedBy(note);
        }
    }

    public synchronized List<NoteTag> getSelectedTags() {
        return selectedTags;
    }

    public synchronized void setSelectedTags(List<NoteTag> selectedTags) {
        this.selectedTags = selectedTags;
    }

    public synchronized boolean saveOrUpdate(List entityChilds) {
        Transaction transaction = noteDao.newTransaction();
        transaction.
                saveOrUpdate(note).
                saveOrUpdate(entityChilds);
        List<NoteTag> tags = tagDao.getListUnlimited();
        for (NoteTag tag : tags) {
            NoteNoteTag noteTag = coalesce(noteTagDao.getBy(note, tag), new NoteNoteTag(note, tag));
            boolean selected = false;
            for (NoteTag selectedTag : selectedTags) {
                if (selectedTag.getId().equals(noteTag.getTag().getId())) {
                    selected = true;
                    break;
                }
            }
            if (selected && isNull(noteTag.getId())) {
                transaction.saveOrUpdate(noteTag);
            } else if (!selected && isNotNull(noteTag.getId())) {
                transaction.delete(noteTag);
            }
        }
        return transaction.execute();
    }
//</editor-fold>
}