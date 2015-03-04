package cococare.framework.model.job.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.MSG_SHOW_LOG_INFO;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCMessage.logp;
import cococare.common.CCTypeConfig;
import cococare.common.quartz.CCJob;
import cococare.database.CCDatabaseConfig;
import static cococare.database.CCLoginInfo.INSTANCE_getDomain;
import static cococare.database.CCLoginInfo.INSTANCE_setDomain;
import static cococare.datafile.CCFile.*;
import cococare.framework.model.mdl.util.UtilityModule;
import java.io.File;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@CCTypeConfig(label = "Auto Clean Temporary Files and Loggers")
public class UtilAutoClean extends CCJob {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        INSTANCE_setDomain(getDomain(jobExecutionContext));
        boolean showLogInfo = MSG_SHOW_LOG_INFO;
        try {
            MSG_SHOW_LOG_INFO = true;
            logp("[1/3] Prepares to delete temporary files for the domain " + INSTANCE_getDomain());
            File tempDirectory = new File(getFileSystTempPath());
            if (tempDirectory.isDirectory()) {
                for (File tempFile : tempDirectory.listFiles()) {
                    delete(tempFile);
                }
            }
            logp("[1/3] Successfully deleted temporary files for the domain " + INSTANCE_getDomain());
            logp("[2/3] Prepares to delete temporary files for the domain " + INSTANCE_getDomain());
            tempDirectory = new File(getFileUserTempPath());
            if (tempDirectory.isDirectory()) {
                for (File tempFile : tempDirectory.listFiles()) {
                    delete(tempFile);
                }
            }
            logp("[2/3] Successfully deleted temporary files for the domain " + INSTANCE_getDomain());
            logp("[3/3] Prepares to delete loggers for the domain " + INSTANCE_getDomain());
            CCDatabaseConfig databaseConfig = UtilityModule.INSTANCE.getCCHibernate().getDatabaseConfig(INSTANCE_getDomain());
            if (isNotNull(databaseConfig)) {
            }
            logp("[3/3] Successfully deleted loggers for the domain " + INSTANCE_getDomain());
        } catch (Exception exception) {
            logp(exception);
        } finally {
            MSG_SHOW_LOG_INFO = showLogInfo;
        }
    }
}