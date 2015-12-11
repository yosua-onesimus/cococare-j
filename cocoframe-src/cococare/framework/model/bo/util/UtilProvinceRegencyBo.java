package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.datafile.CCDom;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.obj.util.UtilProvince;
import cococare.framework.model.obj.util.UtilRegency;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilProvinceRegencyBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized boolean initInitialData() {
        CCDom dom = new CCDom();
        dom.read(getClass().getResourceAsStream("/files/system/archive/ProvinceAndRegency.xml"));
        List restorableDatas = new ArrayList();
        restorableDatas.addAll(dom.readEntity(UtilProvince.class));
        restorableDatas.addAll(dom.readEntity(UtilRegency.class));
        return UtilityModule.INSTANCE.getCCHibernate().restore(restorableDatas);
    }
//</editor-fold>
}