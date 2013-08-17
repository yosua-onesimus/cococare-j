package model.mdl.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import cococare.common.CCFormat;
import cococare.database.CCEntityBo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.obj.sale.SCustomer;
import model.obj.sale.SCustomerPhone;
import model.obj.sale.SVSelling;
//</editor-fold>

public class SaleRepair {

    /**
     * function: format customer name to title case
     */
    public static boolean repairName() {
        List<SCustomer> customers = CCEntityBo.INSTANCE.getListBy(SCustomer.class, null, null, "name ASC, id ASC");
        for (SCustomer customer : customers) {
            customer.setName(CCFormat.toTitleCase(customer.getName()));
        }
        return CCEntityBo.INSTANCE.saveOrUpdate(customers);
    }

    /**
     * function: enhance customer from single phone to multi phones
     */
    public static boolean repairPhone1() {
        List enhancement = new ArrayList();
        HashMap<String, SCustomer> name_customer = new HashMap();
        List<SCustomer> customers = CCEntityBo.INSTANCE.getListBy(SCustomer.class, null, null, "name ASC, id ASC");
        for (SCustomer customer : customers) {
            if (!name_customer.containsKey(customer.getName())) {
                enhancement.add(customer);
                name_customer.put(customer.getName(), customer);
            }
            SCustomerPhone customerPhone = new SCustomerPhone();
            customerPhone.setCustomer(name_customer.get(customer.getName()));
            customerPhone.setPhone(customer.getPhone());
            enhancement.add(customerPhone);
        }
        return CCEntityBo.INSTANCE.saveOrUpdate(enhancement);
    }

    /**
     * function: enhance customer from single phone to multi phones
     */
    public static boolean repairPhone2() {
        List<SVSelling> sellings = CCEntityBo.INSTANCE.getListBy(SVSelling.class, null, null, "id ASC");
        for (SVSelling selling : sellings) {
            System.out.println(CCClass.getAssociativeArray(selling, null));
            selling.setCustomerPhone((SCustomerPhone) CCEntityBo.INSTANCE.getByField(SCustomerPhone.class, "phone", selling.getCustomer().getPhone()));
        }
        return CCEntityBo.INSTANCE.saveOrUpdate(sellings);
    }
}