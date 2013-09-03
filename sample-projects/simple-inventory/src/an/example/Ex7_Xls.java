package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.*;
import cococare.datafile.jxl.CCExcel;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class Ex7_Xls {

    public static InvEmployee newEmployee(String code, String name, String birthPlace, Date birthDate) {
        InvEmployee employee = new InvEmployee();
        employee.setCode(code);
        employee.setName(name);
        employee.setBirthPlace(birthPlace);
        employee.setBirthDate(birthDate);
        return employee;
    }

    public static void main(String[] args) {
        CCConfig.MSG_SHOW_PRINTLN = true;
        //write employees to xls
        List<InvEmployee> employees = new ArrayList();
        employees.add(newEmployee("E001", "Onesimus", "Tegal", CCFormat.getDate("19840606", CCFinal.FORMAT_yyyyMMdd)));
        employees.add(newEmployee("E002", "Euodia", "Jakarta", CCFormat.getDate("19890616", CCFinal.FORMAT_yyyyMMdd)));
        employees.add(newEmployee("E003", "Angela", "Ungaran", CCFormat.getDate("19920927", CCFinal.FORMAT_yyyyMMdd)));
        employees.add(newEmployee("E004", "Heriati", "Surakarta", CCFormat.getDate("19840317", CCFinal.FORMAT_yyyyMMdd)));
        CCExcel excelWrite = new CCExcel();
        excelWrite.newWorkbook();
        excelWrite.newSheet("employee");
        excelWrite.initEntity(InvEmployee.class, true);
        excelWrite.writeRowEntityHeader();
        excelWrite.writeRowEntity(employees);
        excelWrite.saveAndCloseWorkbook(new File("employee.xls"));

        //read employees from xls
        CCExcel excelRead = new CCExcel();
        excelRead.openWorkbook(new File("employee.xls"));
        excelRead.getSheet("employee");
        excelRead.initEntity(InvEmployee.class, true);
        employees = excelRead.readRowEntity(1, excelRead.getRowCount() - 1);
        for (InvEmployee employee : employees) {
            CCMessage.println(CCClass.getAssociativeArray(employee, null));
        }
        /**
         * output: code:E001;name:Onesimus;birthDate:06-Jun-1984;
         * code:E002;name:Euodia;birthDate:16-Jun-1989;
         * code:E003;name:Angela;birthDate:27-Sep-1992;
         * code:E004;name:Heriati;birthDate:17-Mar-1984;
         */
    }
}