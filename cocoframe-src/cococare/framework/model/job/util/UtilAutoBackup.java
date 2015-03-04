package cococare.framework.model.job.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.MSG_SHOW_LOG_INFO;
import static cococare.common.CCMessage.logp;
import cococare.common.CCTypeConfig;
import cococare.common.quartz.CCJob;
import static cococare.database.CCLoginInfo.INSTANCE_getDomain;
import static cococare.database.CCLoginInfo.INSTANCE_setDomain;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@CCTypeConfig(label = "Auto Backup Archive Files and Config Files")
public class UtilAutoBackup extends CCJob {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        INSTANCE_setDomain(getDomain(jobExecutionContext));
        boolean showLogInfo = MSG_SHOW_LOG_INFO;
        try {
            MSG_SHOW_LOG_INFO = true;
            logp("[1/1] Prepares to backup files for the domain " + INSTANCE_getDomain());
            logp("[1/1] Successfully backup files for the domain " + INSTANCE_getDomain());
        } catch (Exception exception) {
            logp(exception);
        } finally {
            MSG_SHOW_LOG_INFO = showLogInfo;
        }
    }
}