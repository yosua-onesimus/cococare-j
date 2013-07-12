package model.dao.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseDouble;
import model.mdl.sale.SaleDao;
import model.obj.sale.SVDeposit;
//</editor-fold>

public class SVDepositDao extends SaleDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return SVDeposit.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public double sumAmount() {
        hql.start().
                select("SUM(amount)");
        parameters.start();
        return parseDouble(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}