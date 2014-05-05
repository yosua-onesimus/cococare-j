package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.bo.inv.InvConfigBo;
import model.bo.inv.InvEmployeeBo;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class PnlEmployeeCtrl extends CFSwingCtrl {

    //
    private InvEmployeeBo employeeBo;
    private InvConfigBo configBo;

    @Override
    protected Class _getEntity() {
        return InvEmployee.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        ((InvEmployee) objEntity).setSalary(configBo.loadInvConfig().getDefaultSalary());
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen("employee", new PnlOwnershipListCtrl(), "pnlOwnership");
    }

    @Override
    protected boolean _doSaveEntity() {
        return employeeBo.saveOrUpdate((InvEmployee) objEntity, _getEntityChilds());
    }
}