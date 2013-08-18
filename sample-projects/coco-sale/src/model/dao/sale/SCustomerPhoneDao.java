package model.dao.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.List;
import model.mdl.sale.SaleDao;
import model.obj.sale.SCustomer;
import model.obj.sale.SCustomerPhone;
//</editor-fold>

public class SCustomerPhoneDao extends SaleDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return SCustomerPhone.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public List<SCustomerPhone> getListBy(SCustomer customer) {
        return getListByField("customer", customer, false);
    }
//</editor-fold>
}