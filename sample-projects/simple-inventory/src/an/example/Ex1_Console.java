package an.example;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.common.CCMessage;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCEntityBo;
import cococare.database.CCHibernate;
import model.mdl.InventoryModule;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class Ex1_Console {

    private CCHibernate hibernate;

    public Ex1_Console() {
        //basic config
        CCConfig.MSG_SHOW_PRINTLN = true;
        CCConfig.MSG_SHOW_LOG_INFO = true;
        CCConfig.MSG_SHOW_LOG_SEVERE = true;
        CCConfig.HBN_SHOW_HQL = "true";
        //initial hibernate
        hibernate = new CCHibernate();
        //add annotated class
        InventoryModule.INSTANCE.init(hibernate);
        //add database config
        hibernate.addDatabaseConfig(new CCDatabaseConfig().withPassword("1234").withDatabase("test"));
    }

    public InvEmployee newEmployee() {
        //initial new employee
        InvEmployee employee = new InvEmployee();
        CCEntityBo.INSTANCE.initSequence(employee);
        return employee;
    }

    public void saveEmployee(InvEmployee employee) {
        //save or update employee
        if (hibernate.saveOrUpdate(employee)) {
            CCMessage.println("employee has been saved successfully");
            CCMessage.println("employee.getId(): " + employee.getId());
        } else {
            CCMessage.println(CCMessage.getErrorMessage(), true);
        }
    }

    public InvEmployee loadEmployee(Long id) {
        return (InvEmployee) hibernate.get(InvEmployee.class, id);
    }

    public void showEmployeeDetail(InvEmployee employee) {
        CCMessage.println("employee.getCode(): " + employee.getCode());
        CCMessage.println("employee.getName(): " + employee.getName());
    }

    public static void main(String[] args) {
        Ex1_Console console = new Ex1_Console();

//        InvEmployee employee = console.newEmployee();
//        employee.setName("Sari Heriati");
//        console.saveEmployee(employee);

        InvEmployee employee = console.loadEmployee(2l);
        console.showEmployeeDetail(employee);
    }
}