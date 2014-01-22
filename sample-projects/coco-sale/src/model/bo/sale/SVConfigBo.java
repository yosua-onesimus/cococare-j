package model.bo.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCMath.round;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.UtilConfigDao;
import java.util.List;
import model.dao.sale.SVDepositDao;
import model.dao.sale.SVSellingDao;
import model.dao.sale.SVVoucherTypeDao;
import model.obj.sale.SVConfig;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class SVConfigBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilConfigDao configDao;
    private SVVoucherTypeDao voucherTypeDao;
    private SVDepositDao depositDao;
    private SVSellingDao sellingDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized SVConfig loadSVConfig() {
        return configDao.loadHash(SVConfig.class);
    }

    public synchronized boolean saveConf(Object object) {
        return configDao.saveHash(object);
    }

    public synchronized boolean recalculateSaldo() {
        SVConfig config = loadSVConfig();
        config.setSaldo(depositDao.sumAmount() - sellingDao.sumPurchasePrice());
        return saveConf(config);
    }

    public synchronized boolean recalculateSaldoProfit() {
        SVConfig config = loadSVConfig();
        config.setSaldo(depositDao.sumAmount() - sellingDao.sumPurchasePrice());
        config.setProfit(sellingDao.sumProfit());
        return saveConf(config);
    }

    public synchronized boolean recalculateSalePrice() {
        SVConfig config = loadSVConfig();
        List<SVVoucherType> voucherTypes = voucherTypeDao.getListUnlimited();
        for (SVVoucherType voucherType : voucherTypes) {
            voucherType.setSalePrice(round(voucherType.getPurchasePrice() + config.getMinimalProfit(), config.getSalePriceRound()));
        }
        return voucherTypeDao.saveOrUpdate(voucherTypes);
    }
//</editor-fold>
}