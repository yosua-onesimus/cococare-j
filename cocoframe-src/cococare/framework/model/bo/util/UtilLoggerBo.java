package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNull;
import cococare.database.CCHibernateBo;
import static cococare.database.CCLoginInfo.*;
import cococare.framework.model.dao.util.UtilLoggerDao;
import cococare.framework.model.obj.util.UtilLogger;
import cococare.framework.model.obj.util.UtilUser;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilLoggerBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilLoggerDao loggerDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" logger ">
    public synchronized void logger(String screen, String action, String note) {
        UtilLogger logger = new UtilLogger(
                INSTANCE_getUserLoginIp(),
                isNull(INSTANCE_getUserLogin()) ? null : ((UtilUser) INSTANCE_getUserLogin()).getUserGroup().getName(),
                INSTANCE_getLogUser(),
                screen, action, note);
        loggerDao.saveOrUpdate(logger);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" logger history ">
    public synchronized List<String> getUsernames() {
        return loggerDao.getUsernames();
    }

    public synchronized List<String> getScreens() {
        return loggerDao.getScreens();
    }

    public synchronized List<String> getActions() {
        return loggerDao.getActions();
    }
//</editor-fold>
}