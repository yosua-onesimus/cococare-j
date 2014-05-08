package model.obj.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCLogic.isNull;
import cococare.common.jasperreports.CCJasper;
import static cococare.datafile.CCFile.getFileSystRepoPath;
import cococare.datafile.CCSetup;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class InvReport extends CCJasper {

//<editor-fold defaultstate="collapsed" desc=" enum Report ">
    private enum Report {

        EMPLOYEE("Employee", "InvEmployee.jasper", "RptHeader.jasper");
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
    @CCFieldConfig(componentId = "cmbReport", accessible = Accessible.MANDATORY, optionSource = "model.obj.inv.InvReport$Report", requestFocus = true)
    private Integer reportIndex = 0;
    @CCFieldConfig(componentId = "bndInventory", accessible = Accessible.MANDATORY, uniqueKey = "name")
    private InvInventory inventory;
    @CCFieldConfig(componentId = "bndEmployee", accessible = Accessible.MANDATORY, uniqueKey = "name")
    private InvEmployee employee;

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public static boolean setupReportFile() {
        CCSetup setup = new CCSetup(InvReport.class);
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
        map.put("inventory", isNull(inventory) ? null : inventory.getId());
        map.put("employee", isNull(employee) ? null : employee.getId());
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

    public InvInventory getInventory() {
        return inventory;
    }

    public void setInventory(InvInventory inventory) {
        this.inventory = inventory;
    }

    public InvEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(InvEmployee employee) {
        this.employee = employee;
    }
//</editor-fold>
}