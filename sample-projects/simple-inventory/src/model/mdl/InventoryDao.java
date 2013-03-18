package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateDao;
import cococare.database.CCHibernateFilter;
import java.util.List;
//</editor-fold>

public abstract class InventoryDao extends CCHibernateDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected CCHibernate getCCHibernate() {
        return InventoryModule.INSTANCE.getCCHibernate();
    }

    @Override
    protected List<CCHibernateFilter> getFilters() {
        return InventoryModule.INSTANCE.getFilters();
    }
//</editor-fold>
}