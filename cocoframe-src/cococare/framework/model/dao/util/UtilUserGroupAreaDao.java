package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilArea;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.util.UtilUserGroupArea;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserGroupAreaDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilUserGroupArea.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public UtilUserGroupArea getBy(UtilUserGroup userGroup, UtilArea area) {
        hql.start().
                where("userGroup = :userGroup").
                where("area = :area");
        parameters.start().
                set("userGroup", userGroup).
                set("area", area);
        return getBy(hql.value(), parameters.value());
    }

    public List<UtilUserGroupArea> getListUnlimitedBy(UtilUserGroup userGroup) {
        hql.start().
                where("userGroup = :userGroup");
        parameters.start().
                set("userGroup", userGroup);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
//</editor-fold>
}