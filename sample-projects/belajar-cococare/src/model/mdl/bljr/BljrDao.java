package model.mdl.bljr;

import cococare.database.CCHibernate;
import cococare.database.CCHibernateDao;
import cococare.database.CCHibernateFilter;
import java.util.List;

public abstract class BljrDao extends CCHibernateDao {

    @Override
    protected CCHibernate getCCHibernate() {
        return BljrModule.INSTANCE.getCCHibernate();
    }

    @Override
    protected List<CCHibernateFilter> getFilters() {
        return BljrModule.INSTANCE.getFilters();
    }
}