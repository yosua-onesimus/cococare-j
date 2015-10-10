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
@Table(name = "note_note_references")
@CCTypeConfig(label = "Reference", uniqueKey = "reference.name")
public class NoteNoteReference extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndNote", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "title", visible = false)
    private NoteNote note;
    @ManyToOne
    @CCFieldConfig(componentId = "bndReference", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name", requestFocus = true)
    private NoteReference reference;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public NoteNote getNote() {
        return note;
    }

    public void setNote(NoteNote note) {
        this.note = note;
    }

    public NoteReference getReference() {
        return reference;
    }

    public void setReference(NoteReference reference) {
        this.reference = reference;
    }
//</editor-fold>
}