package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.copy;
import static cococare.common.CCClass.getLabel;
import static cococare.common.CCFormat.nextSequence;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.wf.WfTabDao;
import cococare.framework.model.obj.wf.WfTab;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfTabBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfTabDao tabDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    /**
     * Create initial data.
     *
     * @param tabClass the tab class.
     * @return true if success; false if fail.
     */
    public synchronized boolean initInitialData(List<String> tabClass) {
        //
        List<WfTab> tabs = new ArrayList();
        for (String tabClassName : tabClass) {
            Class clazz = CCClass.getClass(tabClassName);
            if (isNotNull(clazz)) {
                tabs.add(new WfTab(getLabel(clazz), tabClassName));
            }
        }
        //
        String code = tabDao.getLastCode();
        for (WfTab tab : tabs) {
            WfTab oldTab = tabDao.getByPath(tab.getPath());
            if (isNull(oldTab)) {
                tab.setCode(code = nextSequence(code));
            } else {
                tab.setId(oldTab.getId());
                tab.setLogSaveTimes(oldTab.getLogSaveTimes());
                copy(oldTab, tab);
            }
        }
        //
        return tabDao.newTransaction().
                saveOrUpdate(tabs).
                execute();
    }
//</editor-fold>
}