package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateFilter;
import cococare.database.CCHibernateHashDao;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.obj.util.UtilConfig;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilConfigDao extends CCHibernateHashDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilConfig.class;
    }

    @Override
    protected CCHibernate getCCHibernate() {
        return UtilityModule.INSTANCE.getCCHibernate();
    }

    @Override
    protected List<CCHibernateFilter> getFilters() {
        return UtilityModule.INSTANCE.getFilters();
    }

    public UtilConfig getByKey(String key) {
        return getByField("key", key);
    }
//</editor-fold>
}