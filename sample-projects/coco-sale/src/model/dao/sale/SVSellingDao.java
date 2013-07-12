package model.dao.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseDouble;
import model.mdl.sale.SaleDao;
import model.obj.sale.SVSelling;
//</editor-fold>

public class SVSellingDao extends SaleDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return SVSelling.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public double sumPurchasePrice() {
        hql.start().
                select("SUM(purchasePrice)");
        parameters.start();
        return parseDouble(getBy(hql.value(), parameters.value()));
    }

    public double sumProfit() {
        hql.start().
                select("SUM(salePrice)-SUM(purchasePrice)");
        parameters.start();
        return parseDouble(getBy(hql.value(), parameters.value()));
    }
//</editor-fold>
}