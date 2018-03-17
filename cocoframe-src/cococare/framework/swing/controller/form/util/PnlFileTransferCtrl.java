package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import cococare.common.ftp.CCFtp;
import static cococare.datafile.CCFile.open;
import static cococare.datafile.CCFile.showSaveDialog;
import cococare.framework.model.bo.util.UtilConfigBo;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.newCCTable;
import cococare.swing.CCTable;
import cococare.swing.component.CCAttachment;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import org.apache.commons.net.ftp.FTPFile;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlFileTransferCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigBo configBo;
    private CCFtp ftp;
    private CCAttachment attFileTransfer;
    private CCButton btnStoreFile;
    private CCButton btnRetrieveFile;
    private CCTable tblFileTransfer;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.DIALOG_MODE;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        ftp = new CCFtp();
        ftp.connect(configBo.getConfServ().getFileTransferHostname(), configBo.getConfServ().getFileTransferPort());
        ftp.login(configBo.getConfServ().getFileTransferUsername(), configBo.getConfServ().getFileTransferPassword());
        ftp.changeWorkingDirectory(configBo.getConfServ().getFileTransferDirectory());
        tblFileTransfer = newCCTable(getContainer(), "tblFileTransfer", "File Name", "File Size", "Date");
        tblFileTransfer.setColumnHorizontalAlignment(SwingConstants.LEFT, SwingConstants.RIGHT, SwingConstants.CENTER);
        tblFileTransfer.setColumnWidth(null, 100, 100);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(btnStoreFile, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doStoreFile();
            }
        });
        addListener(btnRetrieveFile, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doRetrieveFile();
            }
        });
    }

    private void _doStoreFile() {
        if (isNotNull(attFileTransfer.getInputStream())) {
            ftp.storeFile(attFileTransfer.getFileName(), attFileTransfer.getInputStream());
            doUpdateTable();
        }
    }

    private void _doRetrieveFile() {
        if (tblFileTransfer.isSelected()) {
            String fileName = tblFileTransfer.getTable().getValueAt(tblFileTransfer.getSelectedRow(), 0).toString();
            File file;
            if (isNotNull(file = showSaveDialog(null, new File(fileName), JFileChooser.FILES_ONLY))
                    && ftp.retrieveFile(file)) {
                open(file);
            }
        }
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        doUpdateTable();
    }

    @Override
    public void doUpdateTable() {
        tblFileTransfer.removeRows();
        for (FTPFile fTPFile : ftp.listFiles()) {
            if (fTPFile.isFile()) {
                tblFileTransfer.addRow(fTPFile.getName(), fTPFile.getSize(), fTPFile.getTimestamp().getTime());
            }
        }
    }
}