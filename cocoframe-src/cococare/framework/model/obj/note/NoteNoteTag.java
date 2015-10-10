package cococare.framework.model.obj.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "note_note_tags")
@CCTypeConfig(label = "Tag", uniqueKey = "tag.name")
public class NoteNoteTag extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndNote", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "title", visible = false)
    private NoteNote note;
    @ManyToOne
    @CCFieldConfig(componentId = "bndTag", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name", requestFocus = true)
    private NoteTag tag;

//<editor-fold defaultstate="collapsed" desc=" NoteNoteTag ">
    public NoteNoteTag() {
    }

    public NoteNoteTag(NoteNote note, NoteTag tag) {
        this.note = note;
        this.tag = tag;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public NoteNote getNote() {
        return note;
    }

    public void setNote(NoteNote note) {
        this.note = note;
    }

    public NoteTag getTag() {
        return tag;
    }

    public void setTag(NoteTag tag) {
        this.tag = tag;
    }
//</editor-fold>
}