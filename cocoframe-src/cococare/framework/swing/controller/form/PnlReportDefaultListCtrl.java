package cococare.framework.swing.controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.newObject;
import static cococare.common.CCLanguage.Report;
import static cococare.common.CCLogic.isNotNull;
import cococare.common.jasperreports.CCReport;
import static cococare.datafile.CCFile.open;
import static cococare.datafile.CCFile.showSaveDialog;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.framework.swing.CFSwingMap.getControllerForm;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.fillUp;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class PnlReportDefaultListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    protected CCButton _btnView;
    protected CCButton _btnExport;
    protected JComboBox cmbReport;
//</editor-fold>

    @Override
    protected Class _getClass() {
        return PnlReportDefaultListCtrl.class;
    }

    @Override
    protected String _getEntityLabel() {
        return Report;
    }

    protected abstract Class _getReportEnum();

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        _initEditor();
        super._initComponent();
        fillUp(cmbReport, _getReportEnum(), false);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbReport, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doUpdateAccessible();
            }
        });
        addListener(_btnView, alView);
        addListener(_btnExport, alExport);
    }

    @Override
    protected void _doView() {
        if (edtEntity.isValueValid()) {
            CFSwingCtrl reportCtrl = newObject(getControllerForm(_getClass()));
            parameter.put(reportCtrl.toString(), swingView.getTabEntity().getTabCount());
            reportCtrl.with(parameter).with(this).init(edtEntity.getValueFromEditor());
        }
    }

    @Override
    protected void _doExport() {
        if (edtEntity.isValueValid()) {
            CCReport report = edtEntity.getValueFromEditor();
            File file;
            if (isNotNull(file = showSaveDialog(null, new File(report.getReportName() + ".xls"), JFileChooser.FILES_ONLY, "xls"))) {
                if (report.newReport().exportAsXlsFile(file.getPath())) {
                    open(file);
                }
            }
        }
    }

    @Override
    protected void _doUpdateComponent() {
        edtEntity.setValueToEditor(edtEntity.newItem());
    }
}