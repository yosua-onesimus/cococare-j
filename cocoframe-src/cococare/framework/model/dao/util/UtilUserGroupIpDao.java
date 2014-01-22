package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.util.UtilUserGroupIp;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserGroupIpDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserGroupIp.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public UtilUserGroupIp getBy(UtilUserGroup userGroup, String ip) {
        hql.start().
                where("userGroup = :userGroup").
                where("ip = :ip");
        parameters.start().
                set("userGroup", userGroup).
                set("ip", ip);
        return getBy(hql.value(), parameters.value());
    }

    public List<UtilUserGroupIp> getListUnlimitedBy(UtilUserGroup userGroup) {
        hql.start().
                where("userGroup = :userGroup");
        parameters.start().
                set("userGroup", userGroup);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}