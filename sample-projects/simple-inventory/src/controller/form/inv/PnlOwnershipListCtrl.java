package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.inv.InvRecalculationBo;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class PnlOwnershipListCtrl extends CFSwingCtrl {

    private InvRecalculationBo recalculationBo;

    @Override
    protected Class _getEntity() {
        return InvOwnership.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected boolean _doDeleteEntity() {
        return super._doDeleteEntity() && tblEntity.saveOrUpdate(recalculationBo.recalcInventory(((InvOwnership) objEntity).getInventory()));
    }
}