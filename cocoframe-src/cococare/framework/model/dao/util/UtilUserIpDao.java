package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseLong;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserIp;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserIpDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserIp.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public UtilUserIp getBy(UtilUser user, String ip) {
        hql.start().
                where("user = :user").
                where("ip = :ip");
        parameters.start().
                set("user", user).
                set("ip", ip);
        return getBy(hql.value(), parameters.value());
    }

    public List<UtilUserIp> getListUnlimitedBy(UtilUser user) {
        hql.start().
                where("user = :user");
        parameters.start().
                set("user", user);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" login ">
    public boolean hasRestriction(UtilUser user) {
        hql.start().
                select("COUNT(*)").
                where("user = :user");
        parameters.start().
                set("user", user);
        return parseLong(getBy(hql.value(), parameters.value())) > 0;
    }

    public boolean isValid(UtilUser user, String ip) {
        hql.start().
                where("user = :user").
                where("ip = :ip");
        parameters.start().
                set("user", user).
                set("ip", ip);
        return isNotNull(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}