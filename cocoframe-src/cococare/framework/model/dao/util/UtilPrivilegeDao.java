package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilPrivilege;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilPrivilegeDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilPrivilege.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" initialData ">
    public UtilPrivilege getByComp(String comp) {
        return (UtilPrivilege) getByField("comp", comp);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    @Override
    public List<UtilPrivilege> getListUnlimited() {
        hql.start().
                orderBy("code ASC");
        parameters.start();
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public List<Boolean> getListSelectedUnlimitedBy(UtilUserGroup userGroup) {
        hql.start().
                select("CASE WHEN id IN ( "
                + "SELECT privilege.id "
                + "FROM UtilUserGroupPrivilege "
                + "WHERE userGroup = :userGroup) "
                + "THEN TRUE ELSE FALSE END").
                orderBy("code ASC");
        parameters.start().
                set("userGroup", userGroup);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public List<Boolean> getListSelectedUnlimitedBy(UtilUser user) {
        hql.start().
                select("CASE WHEN id IN ( "
                + "SELECT privilege.id "
                + "FROM UtilUserPrivilege "
                + "WHERE user = :user) "
                + "THEN TRUE ELSE FALSE END").
                orderBy("code ASC");
        parameters.start().
                set("user", user);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}