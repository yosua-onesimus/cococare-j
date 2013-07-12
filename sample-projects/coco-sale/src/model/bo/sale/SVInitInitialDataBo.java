package model.bo.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
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
        list.addAll(dom.readList(SVOperator.class));
        dom.read(getClass().getResourceAsStream("/resource/VoucherType.xml"));
        list.addAll(dom.readList(SVVoucherType.class));
        return SaleModule.INSTANCE.getCCHibernate().restore(list);
    }
//</editor-fold>
}