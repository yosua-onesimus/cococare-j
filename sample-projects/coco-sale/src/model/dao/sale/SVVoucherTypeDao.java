package model.dao.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.sale.SaleDao;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class SVVoucherTypeDao extends SaleDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return SVVoucherType.class;
    }
//</editor-fold>
}