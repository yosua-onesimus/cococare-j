package model.bo.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.UtilConfigDao;
import model.obj.inv.InvConfig;
//</editor-fold>

public class InvConfigBo extends CCHibernateBo {

    private UtilConfigDao configDao;

    public synchronized InvConfig loadInvConfig() {
        return configDao.loadHash(InvConfig.class);
    }

    public synchronized boolean saveConf(Object object) {
        return configDao.saveHash(object);
    }
}