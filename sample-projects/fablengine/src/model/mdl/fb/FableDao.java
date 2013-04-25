package model.mdl.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateDao;
import cococare.database.CCHibernateFilter;
import java.util.List;
//</editor-fold>

public abstract class FableDao extends CCHibernateDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected CCHibernate getCCHibernate() {
        return FableModule.INSTANCE.getCCHibernate();
    }

    @Override
    protected List<CCHibernateFilter> getFilters() {
        return FableModule.INSTANCE.getFilters();
    }
//</editor-fold>
}