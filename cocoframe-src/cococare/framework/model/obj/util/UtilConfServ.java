package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import static cococare.datafile.CCSystem.USER_HOME;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@CCTypeConfig(label = "Common/Service Module", tooltiptext = "Backup Service, File Transfer Service, Mail Service, etc")
public class UtilConfServ {

    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(group = "Backup Service", label = "Directory", accessible = Accessible.MANDATORY)
    private String backupDirectory = USER_HOME;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(group = "File Transfer Service", label = "File Transfer?")
    private Boolean fileTransferEnable = false;
    @CCFieldConfig(group = "File Transfer Service", label = "Hostname", maxLength = 32)
    private String fileTransferHostname;
    @CCFieldConfig(group = "File Transfer Service", label = "Port", type = Type.NUMBER_ONLY, maxLength = 4)
    private Integer fileTransferPort = 21;
    @CCFieldConfig(group = "File Transfer Service", label = "Username", maxLength = 32)
    private String fileTransferUsername;
    @CCFieldConfig(group = "File Transfer Service", label = "Password", maxLength = 32)
    private String fileTransferPassword;
    @CCFieldConfig(group = "File Transfer Service", label = "Directory")
    private String fileTransferDirectory;
    //----------------------------------------------------------------------------------------------
    @CCFieldConfig(group = "Mail Service", label = "Send Mail?")
    private Boolean mailSendMailEnable = false;
    @CCFieldConfig(group = "Mail Service", label = "Bug Report?")
    private Boolean mailBugReportEnable = false;
    @CCFieldConfig(group = "Mail Service", label = "Mail Smtp Host", maxLength = 32)
    private String mailMailSmtpHost;
    @CCFieldConfig(group = "Mail Service", label = "Gmail Username", maxLength = 32)
    private String mailGmailUsername;
    @CCFieldConfig(group = "Mail Service", label = "Gmail Password", maxLength = 32)
    private String mailGmailPassword;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getBackupDirectory() {
        return backupDirectory;
    }

    public void setBackupDirectory(String backupDirectory) {
        this.backupDirectory = backupDirectory;
    }

    public Boolean getFileTransferEnable() {
        return fileTransferEnable;
    }

    public void setFileTransferEnable(Boolean fileTransferEnable) {
        this.fileTransferEnable = fileTransferEnable;
    }

    public String getFileTransferHostname() {
        return fileTransferHostname;
    }

    public void setFileTransferHostname(String fileTransferHostname) {
        this.fileTransferHostname = fileTransferHostname;
    }

    public Integer getFileTransferPort() {
        return fileTransferPort;
    }

    public void setFileTransferPort(Integer fileTransferPort) {
        this.fileTransferPort = fileTransferPort;
    }

    public String getFileTransferUsername() {
        return fileTransferUsername;
    }

    public void setFileTransferUsername(String fileTransferUsername) {
        this.fileTransferUsername = fileTransferUsername;
    }

    public String getFileTransferPassword() {
        return fileTransferPassword;
    }

    public void setFileTransferPassword(String fileTransferPassword) {
        this.fileTransferPassword = fileTransferPassword;
    }

    public String getFileTransferDirectory() {
        return fileTransferDirectory;
    }

    public void setFileTransferDirectory(String fileTransferDirectory) {
        this.fileTransferDirectory = fileTransferDirectory;
    }

    public Boolean getMailSendMailEnable() {
        return mailSendMailEnable;
    }

    public void setMailSendMailEnable(Boolean mailSendMailEnable) {
        this.mailSendMailEnable = mailSendMailEnable;
    }

    public Boolean getMailBugReportEnable() {
        return mailBugReportEnable;
    }

    public void setMailBugReportEnable(Boolean mailBugReportEnable) {
        this.mailBugReportEnable = mailBugReportEnable;
    }

    public String getMailMailSmtpHost() {
        return mailMailSmtpHost;
    }

    public void setMailMailSmtpHost(String mailMailSmtpHost) {
        this.mailMailSmtpHost = mailMailSmtpHost;
    }

    public String getMailGmailUsername() {
        return mailGmailUsername;
    }

    public void setMailGmailUsername(String mailGmailUsername) {
        this.mailGmailUsername = mailGmailUsername;
    }

    public String getMailGmailPassword() {
        return mailGmailPassword;
    }

    public void setMailGmailPassword(String mailGmailPassword) {
        this.mailGmailPassword = mailGmailPassword;
    }
//</editor-fold>
}