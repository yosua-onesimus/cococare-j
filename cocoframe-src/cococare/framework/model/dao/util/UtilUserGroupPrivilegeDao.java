package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilPrivilege;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.util.UtilUserGroupPrivilege;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserGroupPrivilegeDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserGroupPrivilege.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" initialData ">
    public UtilUserGroupPrivilege getBy(UtilUserGroup userGroup, UtilPrivilege privilege) {
        hql.start().
                where("userGroup = :userGroup").
                where("privilege = :privilege");
        parameters.start().
                set("userGroup", userGroup).
                set("privilege", privilege);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}