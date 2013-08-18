package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import cococare.framework.swing.CFSwingCtrl;
import java.util.List;
import model.bo.sale.SCustomerBo;
import model.obj.sale.SCustomer;
import model.obj.sale.SCustomerPhone;
//</editor-fold>

public class PnlCustomerListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private SCustomerBo customerBo;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return SCustomer.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        //
        tblEntity.addField(1, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Phone";
            }

            @Override
            public Object getCustomView(Object object) {
                String phones = "";
                List<SCustomerPhone> customerPhones = customerBo.getCustomerPhonesBy((SCustomer) object);
                for (SCustomerPhone customerPhone : customerPhones) {
                    phones += (phones.isEmpty() ? "" : "\n") + customerPhone.getPhone();
                }
                return phones;
            }
        });
        tblEntity.setColumnWidth(1, 150);
        tblEntity.setMultilineColumn(true, 1);
    }
}