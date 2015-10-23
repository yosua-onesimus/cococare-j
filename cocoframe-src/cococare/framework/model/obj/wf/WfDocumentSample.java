package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import javax.persistence.Column;
import javax.persistence.Entity;
//</editor-fold>

@Entity
@CCTypeConfig(label = "Document", uniqueKey = "number")
public class WfDocumentSample extends WfDocument {

    @Column(length = 32)
    @CCFieldConfig(componentId = "txtTitle", accessible = Accessible.MANDATORY)
    private String title;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtContent", visible = false)
    private String content;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
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