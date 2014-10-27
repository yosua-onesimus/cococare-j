package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.coalesce;
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.util.UtilUserGroupChild;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserGroupChildDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserGroupChild.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public UtilUserGroupChild getBy(UtilUserGroup userGroup, Class clazz) {
        hql.start().
                where("userGroup = :userGroup").
                where("className = :className");
        parameters.start().
                set("userGroup", userGroup).
                set("className", clazz.getName());
        return coalesce((UtilUserGroupChild) getBy(hql.value(), parameters.value()), new UtilUserGroupChild(userGroup, clazz));
    }
//</editor-fold>
}