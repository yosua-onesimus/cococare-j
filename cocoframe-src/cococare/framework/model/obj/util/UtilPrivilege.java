package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.OnDelete;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.isNotNullAndNotEmpty;
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "util_privileges")
public class UtilPrivilege implements CCEntity {

//<editor-fold defaultstate="collapsed" desc=" entity base ">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String logCreatedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logCreatedOn;
    @Column(length = 32)
    private String logChangedBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date logChangedOn;
    private Integer logSaveTimes = 0;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLogCreatedBy() {
        return logCreatedBy;
    }

    @Override
    public void setLogCreatedBy(String logCreatedBy) {
        this.logCreatedBy = logCreatedBy;
    }

    @Override
    public Date getLogCreatedOn() {
        return logCreatedOn;
    }

    @Override
    public void setLogCreatedOn(Date logCreatedOn) {
        this.logCreatedOn = logCreatedOn;
    }

    @Override
    public String getLogChangedBy() {
        return logChangedBy;
    }

    @Override
    public void setLogChangedBy(String logChangedBy) {
        this.logChangedBy = logChangedBy;
    }

    @Override
    public Date getLogChangedOn() {
        return logChangedOn;
    }

    @Override
    public void setLogChangedOn(Date logChangedOn) {
        this.logChangedOn = logChangedOn;
    }

    @Override
    public Integer getLogSaveTimes() {
        return logSaveTimes;
    }

    @Override
    public void setLogSaveTimes(Integer logSaveTimes) {
        this.logSaveTimes = logSaveTimes;
    }
//</editor-fold>
    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @CCFieldConfig(label = "S", tooltiptext = "Selected", maxLength = 2)
    transient private Boolean selected = false;
    @Column(length = 255)
    @CCFieldConfig(visible = false)
    private String comp;
    @Column(length = 255)
    @CCFieldConfig(visible = false)
    private String code;
    @Column(length = 255)
    @CCFieldConfig(label = "Privilege")
    private String name;
    @ManyToOne
    @CCFieldConfig(visible = false)
    private UtilPrivilege parent;
    @CCFieldConfig(visible = false)
    transient private List<UtilPrivilege> childs = new ArrayList();

//<editor-fold defaultstate="collapsed" desc=" UtilPrivilege ">
    public UtilPrivilege() {
    }

    public UtilPrivilege(String comp, String code, String name) {
        this.comp = comp;
        this.code = code;
        this.name = name;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc=" cascade ">
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "parent")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilPrivilege> privileges;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "privilege")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilUserGroupPrivilege> userGroupPrivileges;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "privilege")
    @CCFieldConfig(onDelete = OnDelete.CASCADE)
    private List<UtilUserPrivilege> userPrivileges;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public Boolean getSelected() {
        return selected;
    }

    public boolean isSelected() {
        return getBoolean(selected);
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

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

    public UtilPrivilege getParent() {
        return parent;
    }

    public void setParent(UtilPrivilege parent) {
        this.parent = parent;
    }

    public List<UtilPrivilege> getChilds() {
        return childs;
    }

    public boolean hasChilds() {
        return isNotNullAndNotEmpty(childs);
    }

    public void addChilds(UtilPrivilege privilege) {
        privilege.setParent(this);
        getChilds().add(privilege);
    }

    public void setChilds(List<UtilPrivilege> childs) {
        this.childs = childs;
    }
//</editor-fold>
}