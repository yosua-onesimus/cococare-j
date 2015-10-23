package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
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
@Table(name = "wf_document_attachments")
@CCTypeConfig(label = "Attachment", uniqueKey = "name")
public class WfDocumentSampleAttachment extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "number", visible = false, visible2 = false)
    private WfDocument document;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, requestFocus = true)
    private String name;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtDescription")
    private String description;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfDocument getDocument() {
        return document;
    }

    public void setDocument(WfDocument document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//</editor-fold>
}