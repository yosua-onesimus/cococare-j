package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUser.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" initialData ">
    public UtilUser getByUsername(String username) {
        return (UtilUser) getByField("username", username);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<UtilUser> getListUnlimitedBy(UtilUserGroup userGroup) {
        return getListUnlimitedByField("userGroup", userGroup, false);
    }
//</editor-fold>
}