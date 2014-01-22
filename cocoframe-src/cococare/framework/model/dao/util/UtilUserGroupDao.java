package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilUserGroup;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserGroupDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserGroup.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" initialData ">
    public UtilUserGroup getByCode(String code) {
        return getByField("code", code);
    }
//</editor-fold>
}