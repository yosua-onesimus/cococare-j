package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilPrivilege;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserPrivilege;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserPrivilegeDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserPrivilege.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" initialData ">
    public UtilUserPrivilege getBy(UtilUser user, UtilPrivilege privilege) {
        hql.start().
                where("user = :user").
                where("privilege = :privilege");
        parameters.start().
                set("user", user).
                set("privilege", privilege);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" login ">
    public List<UtilUserPrivilege> getListUnlimitedBy(UtilUser user) {
        hql.start().
                where("user = :user");
        parameters.start().
                set("user", user);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}