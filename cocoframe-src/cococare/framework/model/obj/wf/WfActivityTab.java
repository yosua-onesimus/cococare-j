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
@Table(name = "wf_activity_tabs")
@CCTypeConfig(label = "Tab", uniqueKey = "tabName")
public class WfActivityTab extends CCEntity {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name", visible = false, visible2 = false)
    private WfActivity activity;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 48, uniqueKey = "name")
    private WfTab tab;
    @Column(length = 48)
    @CCFieldConfig(accessible = Accessible.MANDATORY)
    private String tabName;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public WfActivity getActivity() {
        return activity;
    }

    public void setActivity(WfActivity activity) {
        this.activity = activity;
    }

    public WfTab getTab() {
        return tab;
    }

    public void setTab(WfTab tab) {
        this.tab = tab;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }
//</editor-fold>
}