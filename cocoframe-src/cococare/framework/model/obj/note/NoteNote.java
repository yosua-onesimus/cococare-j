package cococare.framework.model.obj.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "note_notes")
@CCTypeConfig(label = "Note", uniqueKey = "title")
public class NoteNote extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "N000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtTitle", accessible = Accessible.MANDATORY, maxLength = 32)
    private String title;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtContent", maxLength = Short.MAX_VALUE, visible = false)
    private String content;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
//</editor-fold>
}