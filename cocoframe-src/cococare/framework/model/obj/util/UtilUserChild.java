package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCEntity;
import cococare.framework.common.CFApplCtrl;
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
@Table(name = "util_user_childs")
public class UtilUserChild extends CCEntity {

    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;
    @ManyToOne
    private UtilUser user;
    @Column(length = 255)
    private String className;
    @Column(length = 255)
    private String associativeArray;

//<editor-fold defaultstate="collapsed" desc=" UtilUserChild ">
    public UtilUserChild() {
    }

    public UtilUserChild(UtilUser user, Class clazz) {
        this.user = user;
        this.className = clazz.getName();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }

    public UtilUser getUser() {
        return user;
    }

    public void setUser(UtilUser user) {
        this.user = user;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAssociativeArray() {
        return associativeArray;
    }

    public void setAssociativeArray(String associativeArray) {
        this.associativeArray = associativeArray;
    }
//</editor-fold>
}