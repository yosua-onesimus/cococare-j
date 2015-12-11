package cococare.framework.model.job.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCMessage.info;
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
        try {
            info("[1/3] Prepares to delete system temporary files for the domain " + INSTANCE_getDomain());
            delete(new File(getFileSystTempPath()));
            info("[1/3] Successfully deleted system temporary files for the domain " + INSTANCE_getDomain());
            info("[2/3] Prepares to delete user temporary files for the domain " + INSTANCE_getDomain());
            delete(new File(getFileUserTempPath()));
            info("[2/3] Successfully deleted user temporary files for the domain " + INSTANCE_getDomain());
            info("[3/3] Prepares to delete loggers for the domain " + INSTANCE_getDomain());
            CCDatabaseConfig databaseConfig = UtilityModule.INSTANCE.getCCHibernate().getDatabaseConfig(INSTANCE_getDomain());
            if (isNotNull(databaseConfig)) {
            }
            info("[3/3] Successfully deleted loggers for the domain " + INSTANCE_getDomain());
        } catch (Exception exception) {
            logp(exception);
        }
    }
}