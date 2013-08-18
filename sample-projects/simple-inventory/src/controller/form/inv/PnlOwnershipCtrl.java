package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.inv.InvRecalculationBo;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class PnlOwnershipCtrl extends CFSwingCtrl {

    private InvRecalculationBo recalculationBo;

    @Override
    protected Class _getEntity() {
        return InvOwnership.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected boolean _doSaveEntity() {
        return super._doSaveEntity() && edtEntity.saveOrUpdate(recalculationBo.recalcInventory(((InvOwnership) objEntity).getInventory()));
    }
}