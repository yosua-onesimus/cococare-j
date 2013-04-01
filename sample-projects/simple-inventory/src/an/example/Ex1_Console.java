package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.common.CCFormat;
import cococare.common.CCMessage;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import java.util.List;
import model.dao.inv.InvEmployeeDao;
import model.mdl.inv.InventoryModule;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class Ex1_Console {

    private CCHibernate hibernate;
    private InvEmployeeDao employeeDao;

    public Ex1_Console() {
        //basic config
        CCConfig.MSG_SHOW_PRINTLN = true;
        CCConfig.MSG_SHOW_LOG_INFO = false;
        CCConfig.MSG_SHOW_LOG_SEVERE = true;
        CCConfig.HBN_SHOW_HQL = "false";
        //initial hibernate
        hibernate = new CCHibernate();
        //add annotated class
        InventoryModule.INSTANCE.init(hibernate);
        //add database config
        hibernate.addDatabaseConfig(new CCDatabaseConfig().withPassword("1234").withDatabase("test"));
        //initial dao
        employeeDao = new InvEmployeeDao();
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
        List<InvEmployee> employees = employeeDao.getList();
        for (InvEmployee employee : employees) {
            CCMessage.println(
                    CCFormat.pack(employee.getId() + ".|", " ", 5)
                    + CCFormat.pack(employee.getCode() + "|", " ", 20)
                    + CCFormat.pack(employee.getName() + "|", " ", 20));
        }
    }

    private void _showMenu2() {
        CCMessage.println(CCFormat.pack("", "-", 45));
        InvEmployee employee = (InvEmployee) employeeDao.initSequence(new InvEmployee());
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

    private void _showMenu3() {
        InvEmployee employee = null;
        while (employee == null) {
            CCMessage.println(CCFormat.pack("", "-", 45));
            CCMessage.println("Enter Employee Id: ");
            employee = (InvEmployee) employeeDao.getById(CCFormat.getLong(CCMessage.readln()));
        }
        CCMessage.println("Code: " + employee.getCode());
        CCMessage.println("Name: ");
        employee.setName(CCMessage.readln());
        if (hibernate.saveOrUpdate(employee)) {
            CCMessage.println("employee has been saved successfully");
            CCMessage.println("employee.getId(): " + employee.getId());
        } else {
            CCMessage.println(CCMessage.getErrorMessage(), true);
        }
    }

    private void _showMenu4() {
        InvEmployee employee = null;
        while (employee == null) {
            CCMessage.println(CCFormat.pack("", "-", 45));
            CCMessage.println("Enter Employee Id: ");
            employee = (InvEmployee) employeeDao.getById(CCFormat.getLong(CCMessage.readln()));
        }
        if (employeeDao.delete(employee)) {
            CCMessage.println("employee has been deleted successfully");
        } else {
            CCMessage.println(CCMessage.getErrorMessage(), true);
        }
    }

    public static void main(String[] args) {
        new Ex1_Console().showMenu();
    }
}