package cococare.framework.model.dao.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.mdl.util.UtilityDao;
import cococare.framework.model.obj.util.UtilScheduler;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilSchedulerDao extends UtilityDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return UtilScheduler.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    public String getLastCode() {
        return getLastValue("code", "Sch000");
    }

    public UtilScheduler getByJobClassName(String jobClassName) {
        hql.start().
                where("jobClassName = :jobClassName");
        parameters.start().
                set("jobClassName", jobClassName);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}