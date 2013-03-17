package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilLogger;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilLoggerDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilLogger.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" logger history ">
    private List<String> _getStrings(String fieldName) {
        hql.start().
                select("DISTINCT " + fieldName).
                orderBy(fieldName + " ASC");
        parameters.start();
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public List<String> getUsernames() {
        return _getStrings("username");
    }

    public List<String> getScreens() {
        return _getStrings("screen");
    }

    public List<String> getActions() {
        return _getStrings("action");
    }
//</editor-fold>
}