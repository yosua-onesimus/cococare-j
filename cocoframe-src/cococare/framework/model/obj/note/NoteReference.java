package cococare.framework.model.obj.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import cococare.framework.model.obj.note.NoteEnum.ReferenceType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "note_references")
@CCTypeConfig(label = "Reference", uniqueKey = "name")
public class NoteReference extends CCEntity {

    @Column(length = 8)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 8, sequence = "R000", requestFocus = true, unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtName", accessible = Accessible.MANDATORY, maxLength = 32)
    private String name;
    @CCFieldConfig(componentId = "cmbType", accessible = Accessible.MANDATORY, optionSource = "cococare.framework.model.obj.note.NoteEnum$ReferenceType", optionReflectKey = "type", visible = false)
    private Integer typeIndex = ReferenceType.ATTACHMENT.ordinal();
    @Column(length = 16)
    @CCFieldConfig(maxLength = 16, visible = false, visible2 = false)
    private String type = ReferenceType.ATTACHMENT.toString();
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(componentId = "attByteA", type = Type.COMMON_FILE, optionReflectKey = "value", visible = false)
    transient private byte[] byteA;
    @Column(name = "value_", length = 255)
    @CCFieldConfig(componentId = "txtValue", visible = false, visible2 = false)
    private String value;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
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

    public Integer getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(Integer typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ReferenceType getReferenceType() {
        return ReferenceType.values()[getTypeIndex()];
    }

    public void setReferenceType(ReferenceType referenceType) {
        setTypeIndex(referenceType.ordinal());
        setType(referenceType.toString());
    }

    public byte[] getByteA() {
        return byteA;
    }

    public void setByteA(byte[] byteA) {
        this.byteA = byteA;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
//</editor-fold>
}