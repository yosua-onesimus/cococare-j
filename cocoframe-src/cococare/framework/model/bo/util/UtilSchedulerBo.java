package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.copy;
import static cococare.common.CCClass.getLabel;
import static cococare.common.CCFinal.DOMAIN;
import static cococare.common.CCFormat.nextSequence;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import static cococare.common.quartz.CCQuartz.*;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import static cococare.database.CCLoginInfo.INSTANCE_getDomain;
import cococare.framework.model.dao.util.UtilSchedulerDao;
import cococare.framework.model.job.util.UtilAutoBackup;
import cococare.framework.model.job.util.UtilAutoClean;
import cococare.framework.model.obj.util.UtilScheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilSchedulerBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilSchedulerDao schedulerDao;
    private List<UtilScheduler> schedulers = new ArrayList(Arrays.asList(
            new UtilScheduler(getLabel(UtilAutoBackup.class), UtilAutoBackup.class.getName()),
            new UtilScheduler(getLabel(UtilAutoClean.class), UtilAutoClean.class.getName())));
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    public synchronized void setAdditionalJobClass(List<String> additionalJobClass) {
        for (String jobClassName : additionalJobClass) {
            Class clazz = CCClass.getClass(jobClassName);
            if (isNotNull(clazz)) {
                schedulers.add(new UtilScheduler(getLabel(clazz), clazz.getName()));
            }
        }
    }

    public synchronized boolean initInitialData() {
        String code = schedulerDao.getLastValue("code", "Sch000");
        for (UtilScheduler scheduler : schedulers) {
            UtilScheduler oldScheduler = schedulerDao.getByJobClassName(scheduler.getJobClassName());
            if (isNull(oldScheduler)) {
                scheduler.setCode(code = nextSequence(code));
            } else {
                scheduler.setId(oldScheduler.getId());
                scheduler.setLogSaveTimes(oldScheduler.getLogSaveTimes());
                copy(oldScheduler, scheduler);
            }
        }
        Transaction transaction = schedulerDao.newTransaction();
        return transaction.
                saveOrUpdate(schedulers).
                execute();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized boolean saveOrUpdate(UtilScheduler scheduler) {
        Class jobClass = CCClass.getClass(scheduler.getJobClassName());
        if (checkExists(jobClass)) {
            stop(jobClass);
        }
        if (scheduler.isActive()) {
            HashMap parameter = new HashMap();
            parameter.put(DOMAIN, INSTANCE_getDomain());
            start(jobClass, parameter, scheduler.getCronSchedule());
        }
        return schedulerDao.saveOrUpdate(scheduler);
    }
//</editor-fold>
}