package cococare.framework.model.obj.wf;

import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import javax.persistence.Column;
import javax.persistence.Entity;

@Deprecated
@Entity
@CCTypeConfig(label = "Document", uniqueKey = "@code-@name")
public class WfDocumentSample extends WfDocument {

    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "P000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}