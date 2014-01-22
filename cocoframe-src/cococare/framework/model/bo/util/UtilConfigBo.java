package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.UtilConfigDao;
import cococare.framework.model.obj.util.UtilConfAppl;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilConfigBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigDao configDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized UtilConfAppl loadConfAppl() {
        return configDao.loadHash(UtilConfAppl.class);
    }

    public synchronized boolean saveConf(Object object) {
        return configDao.saveHash(object);
    }
//</editor-fold>
}