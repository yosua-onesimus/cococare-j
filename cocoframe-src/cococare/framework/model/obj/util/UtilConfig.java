package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCTypeConfig;
import cococare.database.CCEntityHash;
import cococare.framework.common.CFApplCtrl;
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
@Table(name = "util_configs")
@CCTypeConfig(label = "Config", uniqueKey = "key")
public class UtilConfig extends CCEntityHash {

    @Column(length = 32)
    private String appl = CFApplCtrl.APPL_CODE;

//<editor-fold defaultstate="collapsed" desc=" UtilConfig ">
    public UtilConfig() {
    }

    public UtilConfig(String key) {
        setKey(key);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getAppl() {
        return appl;
    }

    public void setAppl(String appl) {
        this.appl = appl;
    }
//</editor-fold>
}