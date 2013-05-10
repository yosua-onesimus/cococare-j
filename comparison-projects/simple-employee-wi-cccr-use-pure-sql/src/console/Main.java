package console;

import cococare.common.CCConfig;
import cococare.common.CCFormat;
import cococare.common.CCMessage;
import cococare.database.CCDatabase;
import cococare.database.CCDatabaseConfig;
import java.util.List;
import model.dao.EmployeeDao;
import model.obj.Employee;

public class Main {

    public static CCDatabase DATABASE;
    private EmployeeDao employeeDao;

    public Main() {
        CCConfig.MSG_SHOW_PRINTLN = true;
        DATABASE = new CCDatabase();
        DATABASE.getConnection(new CCDatabaseConfig().withPassword("1234").withDatabase("test"), false);
        employeeDao = new EmployeeDao();
    }

    public void showMenu() {
        String menu;
        while (true) {
            CCMessage.println(CCFormat.pack("", "-", 45));
            CCMessage.println("1. Show Employee List");
            CCMessage.println("2. Add Employee");
            CCMessage.println("3. Edit Employee");
            CCMessage.println("4. Delete Employee");
            CCMessage.println("X. Exit");
            CCMessage.println("Your choice: ");
            menu = CCMessage.readln().toUpperCase();
            if ("1".equals(menu)) {
                _showMenu1();
            } else if ("2".equals(menu)) {
                _showMenu2();
            } else if ("3".equals(menu)) {
                _showMenu3();
            } else if ("4".equals(menu)) {
                _showMenu4();
            } else if ("X".equals(menu)) {
                System.exit(0);
            }
        }
    }

    private void _showMenu1() {
        CCMessage.println(CCFormat.pack("", "-", 45));
        CCMessage.println(
                CCFormat.pack("Id|", " ", 5)
                + CCFormat.pack("Code|", " ", 20)
                + CCFormat.pack("Name|", " ", 20));
        CCMessage.println(CCFormat.pack("", "-", 45));
        List<Employee> employees = employeeDao.getListObject();
        for (Employee employee : employees) {
            CCMessage.println(
                    CCFormat.pack(employee.getId() + ".|", " ", 5)
                    + CCFormat.pack(employee.getCode() + "|", " ", 20)
                    + CCFormat.pack(employee.getName() + "|", " ", 20));
        }
    }

    private void _showMenu2() {
        CCMessage.println(CCFormat.pack("", "-", 45));
        Employee employee = new Employee();
        CCMessage.println("Code: ");
        employee.setCode(CCMessage.readln());
        CCMessage.println("Name: ");
        employee.setName(CCMessage.readln());
        if (employeeDao.saveOrUpdate(employee)) {
            CCMessage.println("employee has been saved successfully");
            CCMessage.println("employee.getId(): " + employee.getId());
        } else {
            CCMessage.println(CCMessage.getErrorMessage(), true);
        }
    }

    private void _showMenu3() {
        Employee employee = null;
        while (employee == null) {
            CCMessage.println(CCFormat.pack("", "-", 45));
            CCMessage.println("Enter Employee Id: ");
            employee = (Employee) employeeDao.getById(CCFormat.getLong(CCMessage.readln()));
        }
        CCMessage.println("Code: " + employee.getCode());
        CCMessage.println("Name: ");
        employee.setName(CCMessage.readln());
        if (employeeDao.saveOrUpdate(employee)) {
            CCMessage.println("employee has been saved successfully");
            CCMessage.println("employee.getId(): " + employee.getId());
        } else {
            CCMessage.println(CCMessage.getErrorMessage(), true);
        }
    }

    private void _showMenu4() {
        Employee employee = null;
        while (employee == null) {
            CCMessage.println(CCFormat.pack("", "-", 45));
            CCMessage.println("Enter Employee Id: ");
            employee = (Employee) employeeDao.getById(CCFormat.getLong(CCMessage.readln()));
        }
        if (employeeDao.delete(employee)) {
            CCMessage.println("employee has been deleted successfully");
        } else {
            CCMessage.println(CCMessage.getErrorMessage(), true);
        }
    }

    public static void main(String[] args) {
        new Main().showMenu();
    }
}