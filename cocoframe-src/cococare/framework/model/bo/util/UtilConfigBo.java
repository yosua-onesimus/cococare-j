package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.UtilConfigDao;
import cococare.framework.model.obj.util.UtilConfAppl;
import cococare.framework.model.obj.util.UtilConfServ;
import cococare.framework.model.obj.util.UtilConfig;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilConfigBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigDao configDao;
    private UtilConfAppl confAppl = loadConfAppl();
    private UtilConfServ confServ = loadConfServ();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized <T> T loadHash(Class setting) {
        return configDao.loadHash(setting);
    }

    public synchronized UtilConfAppl loadConfAppl() {
        return loadHash(UtilConfAppl.class);
    }

    public synchronized UtilConfServ loadConfServ() {
        return loadHash(UtilConfServ.class);
    }

    public synchronized boolean saveConf(Object object) {
        return configDao.saveHash(object);
    }

    public synchronized UtilConfAppl getConfAppl() {
        return confAppl;
    }

    public synchronized UtilConfServ getConfServ() {
        return confServ;
    }

    public synchronized UtilConfig getByKey(String key) {
        return configDao.getByKey(key);
    }
//</editor-fold>
}