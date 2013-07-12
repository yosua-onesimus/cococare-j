package cococare.framework.swing.controller.form.setup;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import static cococare.common.CCLogic.isNotEmpty;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCMessage.getErrorMessage;
import static cococare.common.CCMessage.showInformation;
import static cococare.datafile.CCFile.getApplPath;
import static cococare.datafile.CCFile.showOpenDialog;
import cococare.datafile.CCSetup;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addActionListener;
import static cococare.swing.CCSwing.newCCTable;
import cococare.swing.CCTable;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlListFilesSetupCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" ListFile ">
    private class ListFile {

//<editor-fold defaultstate="collapsed" desc=" private object ">
        @CCFieldConfig(label = "", visible = false)
        private boolean selected = true;
        @CCFieldConfig(maxLength = 200)
        private String fileName;
        private String description;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" ListFile ">
        public ListFile(String fileName, String description) {
            this.fileName = fileName;
            this.description = description;
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
//</editor-fold>
    }
//</editor-fold>
    private JTextField txtFolder;
    private CCButton btnBrowse;
    private CCButton btnCopy;
    private CCTable tblListFiles;

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        tblListFiles = newCCTable(getContainer(), "tblListFiles", ListFile.class);
        tblListFiles.setMultiple(true);
        tblListFiles.addItem(new ListFile("Currencies.txt", "List of Currencies"));
        tblListFiles.addItem(new ListFile("IndonesiaCities.txt", "List of Indonesia's Cities"));
        tblListFiles.addItem(new ListFile("IndonesiaProvinces.txt", "List of Indonesia's Provinces"));
        tblListFiles.addItem(new ListFile("States.txt", "List of States"));
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addActionListener(btnBrowse, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doBrowse();
            }
        });
        addActionListener(btnCopy, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doCopy();
            }
        });
    }

    private void _doBrowse() {
        File file = showOpenDialog(new File(txtFolder.getText()), JFileChooser.DIRECTORIES_ONLY);
        if (isNotNull(file)) {
            txtFolder.setText(file.getPath());
        }
    }

    private void _doCopy() {
        List<ListFile> listFiles = tblListFiles.getSelectedItems();
        if (isNotEmpty(listFiles)) {
            CCSetup setup = new CCSetup(getClass());
            for (Object object : tblListFiles.getSelectedItems()) {
                ListFile listFile = (ListFile) object;
                setup.addSetupMap(listFile.getFileName(), txtFolder.getText());
            }
            showInformation("Setup " + (setup.execute() ? "success!" : ("failed!\n" + getErrorMessage())));
        }
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        txtFolder.setText(getApplPath());
    }
}