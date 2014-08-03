package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilArea;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserArea;
import java.util.List;
//</editor-fold>

public class UtilUserAreaDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserArea.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public UtilUserArea getBy(UtilUser user, UtilArea area) {
        hql.start().
                where("user = :user").
                where("area = :area");
        parameters.start().
                set("user", user).
                set("area", area);
        return getBy(hql.value(), parameters.value());
    }

    public List<UtilUserArea> getListUnlimitedBy(UtilUser user) {
        hql.start().
                where("user = :user");
        parameters.start().
                set("user", user);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}