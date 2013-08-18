package model.bo.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.sale.SCustomerPhoneDao;
import model.obj.sale.SCustomer;
import model.obj.sale.SCustomerPhone;
//</editor-fold>

public class SCustomerBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private SCustomerPhoneDao customerPhoneDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized List<SCustomerPhone> getCustomerPhonesBy(SCustomer customer) {
        return customerPhoneDao.getListBy(customer);
    }
//</editor-fold>
}