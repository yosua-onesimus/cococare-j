package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.coalesce;
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserChild;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserChildDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserChild.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public UtilUserChild getBy(UtilUser user, Class clazz) {
        hql.start().
                where("user = :user").
                where("className = :className");
        parameters.start().
                set("user", user).
                set("className", clazz.getName());
        return coalesce((UtilUserChild) getBy(hql.value(), parameters.value()), new UtilUserChild(user, clazz));
    }
//</editor-fold>
}