package model.obj.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.jasperreports.CCJasper;
import static cococare.datafile.CCFile.getFileSystRepoPath;
import cococare.datafile.CCSetup;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class StkReport extends CCJasper {

//<editor-fold defaultstate="collapsed" desc=" enum Report ">
    public enum Report {

        ITEM_STOCK("Item Stock", "StkItemStock.jasper", "RptHeader.jasper");
        private String string;
        private String jasperFile;
        private String[] reqJasperFiles;

        private Report(String string, String jasperFile, String... reqJasperFiles) {
            this.string = string;
            this.jasperFile = jasperFile;
            this.reqJasperFiles = reqJasperFiles;
        }

        @Override
        public String toString() {
            return string;
        }

        private String getJasperFile() {
            return jasperFile;
        }

        private String[] getReqJasperFiles() {
            return reqJasperFiles;
        }
    }
//</editor-fold>
    //
    @CCFieldConfig(componentId = "cmbReport", accessible = Accessible.MANDATORY, optionSource = "model.obj.stk.StkReport$Report", requestFocus = true)
    private Integer reportIndex = 0;

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public static boolean setupReportFile() {
        CCSetup setup = new CCSetup(StkReport.class);
        setup.setResourcePath("files/system/report/");
        String setupPath = getFileSystRepoPath();
        for (Report report : Report.values()) {
            setup.addSetupMap(report.getJasperFile(), setupPath);
            for (String jasperFile : report.getReqJasperFiles()) {
                setup.addSetupMap(jasperFile, setupPath);
            }
        }
        return setup.execute();
    }

    @Override
    protected void _initDefaultMap() {
        super._initDefaultMap();
    }

    public CCJasper newReport() {
        return newReport(Report.values()[reportIndex].getJasperFile(), map, null);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public Integer getReportIndex() {
        return reportIndex;
    }

    public String getReportName() {
        return Report.values()[reportIndex].toString();
    }

    public void setReportIndex(Integer reportIndex) {
        this.reportIndex = reportIndex;
    }
//</editor-fold>
}