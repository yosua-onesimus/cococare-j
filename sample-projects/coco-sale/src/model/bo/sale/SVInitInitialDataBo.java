package model.bo.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNull;
import cococare.database.CCHibernateBo;
import cococare.datafile.CCDom;
import java.util.ArrayList;
import java.util.List;
import model.mdl.sale.SaleModule;
import model.obj.sale.SVOperator;
import model.obj.sale.SVVoucherType;
//</editor-fold>

public class SVInitInitialDataBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized boolean initFirstData() {
        List list = new ArrayList();
        CCDom dom = new CCDom();
        dom.read(getClass().getResourceAsStream("/resource/Operator.xml"));
        List<SVOperator> operators = dom.readList(SVOperator.class);
        for (SVOperator operator : operators) {
            if (isNull(SaleModule.INSTANCE.getCCHibernate().get(SVOperator.class, operator.getId()))) {
                list.add(operator);
            }
        }
        dom.read(getClass().getResourceAsStream("/resource/VoucherType.xml"));
        List<SVVoucherType> voucherTypes = dom.readList(SVVoucherType.class);
        for (SVVoucherType voucherType : voucherTypes) {
            if (isNull(SaleModule.INSTANCE.getCCHibernate().get(SVVoucherType.class, voucherType.getId()))) {
                list.add(voucherType);
            }
        }
        return SaleModule.INSTANCE.getCCHibernate().restore(list);
    }
//</editor-fold>
}