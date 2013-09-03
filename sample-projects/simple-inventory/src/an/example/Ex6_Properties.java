package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.*;
import cococare.datafile.CCProperties;
import java.io.File;
import java.util.Date;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class Ex6_Properties {

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
        //write employee to properties
        InvEmployee employee = newEmployee("E001", "Onesimus", "Tegal", CCFormat.getDate("19840606", CCFinal.FORMAT_yyyyMMdd));
        CCProperties propertiesWrite = new CCProperties();
        propertiesWrite.setValue(employee, false);
        propertiesWrite.storeExtern(new File("employee.prop"));

        //read employee from properties
        CCProperties propertiesRead = new CCProperties();
        propertiesRead.loadExtern(new File("employee.prop"));
        employee = (InvEmployee) propertiesRead.getValue(InvEmployee.class, false);
        CCMessage.println(CCClass.getAssociativeArray(employee, null));
        /**
         * output: code:E001;name:Onesimus;birthDate:06-Jun-1984;
         */
    }
}