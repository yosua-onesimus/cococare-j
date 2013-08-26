package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.*;
import cococare.datafile.CCDom;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class Ex5_Xml {

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
        //write employees to xml
        List<InvEmployee> employees = new ArrayList();
        employees.add(newEmployee("E001", "Onesimus", "Tegal", CCFormat.getDate("19840606", CCFinal.FORMAT_yyyyMMdd)));
        employees.add(newEmployee("E002", "Euodia", "Jakarta", CCFormat.getDate("19890616", CCFinal.FORMAT_yyyyMMdd)));
        employees.add(newEmployee("E003", "Angela", "Ungaran", CCFormat.getDate("19920927", CCFinal.FORMAT_yyyyMMdd)));
        employees.add(newEmployee("E004", "Heriati", "Surakarta", CCFormat.getDate("19840317", CCFinal.FORMAT_yyyyMMdd)));
        CCDom domWrite = new CCDom();
        domWrite.writeList("root", InvEmployee.class, employees);
        domWrite.transform(new File("employee.xml"));

        //read employees from xml
        CCDom domRead = new CCDom();
        domRead.read(new File("employee.xml"));
        employees = domRead.readList(InvEmployee.class);
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