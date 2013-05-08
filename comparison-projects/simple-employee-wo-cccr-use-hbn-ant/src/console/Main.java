package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import model.dao.EmployeeDao;
import model.obj.Employee;

public class Main {

    private EmployeeDao employeeDao;

    public Main() {
        employeeDao = new EmployeeDao();
    }

    public void println(Object message) {
        System.out.println(message);
    }

    public String readln() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            return bufferedReader.readLine();
        } catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public String pack(String string, String filler, int length) {
        try {
            return String.format("%" + length + "s", string).replace(" ", filler);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public void showMenu() {
        String menu;
        while (true) {
            println(pack("", "-", 45));
            println("1. Show Employee List");
            println("2. Add Employee");
            println("3. Edit Employee");
            println("4. Delete Employee");
            println("X. Exit");
            println("Your choice: ");
            menu = readln().toUpperCase();
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
        println(pack("", "-", 45));
        println(
                pack("Id|", " ", 5)
                + pack("Code|", " ", 20)
                + pack("Name|", " ", 20));
        println(pack("", "-", 45));
        List<Employee> employees = employeeDao.getList();
        for (Employee employee : employees) {
            println(
                    pack(employee.getId() + ".|", " ", 5)
                    + pack(employee.getCode() + "|", " ", 20)
                    + pack(employee.getName() + "|", " ", 20));
        }
    }

    private void _showMenu2() {
        println(pack("", "-", 45));
        Employee employee = (Employee) new Employee();
        println("Code: ");
        employee.setCode(readln());
        println("Name: ");
        employee.setName(readln());
        if (employeeDao.saveOrUpdate(employee)) {
            println("employee has been saved successfully");
            println("employee.getId(): " + employee.getId());
        } else {
            println("Error");
        }
    }

    private void _showMenu3() {
        Employee employee = null;
        while (employee == null) {
            println(pack("", "-", 45));
            println("Enter Employee Id: ");
            employee = (Employee) employeeDao.getById(Long.parseLong(readln()));
        }
        println("Code: " + employee.getCode());
        println("Name: ");
        employee.setName(readln());
        if (employeeDao.saveOrUpdate(employee)) {
            println("employee has been saved successfully");
            println("employee.getId(): " + employee.getId());
        } else {
            println("Error");
        }
    }

    private void _showMenu4() {
        Employee employee = null;
        while (employee == null) {
            println(pack("", "-", 45));
            println("Enter Employee Id: ");
            employee = (Employee) employeeDao.getById(Long.parseLong(readln()));
        }
        if (employeeDao.delete(employee)) {
            println("employee has been deleted successfully");
        } else {
            println("Error");
        }
    }

    public static void main(String[] args) {
        new Main().showMenu();
    }
}