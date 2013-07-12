package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.getJPanel;
import static cococare.swing.CCSwing.showPanel;
import java.util.ArrayList;
import java.util.List;
import model.bo.inv.InvEmployeeBo;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class PnlEmployeeCtrl extends CFSwingCtrl {

    //
    private InvEmployeeBo employeeBo;

    @Override
    protected Class _getEntity() {
        return InvEmployee.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        parameter.put("employee", objEntity);
        parameter.put("employee_newEntity", newEntity);
        if (newEntity) {
            parameter.put("ownerships", new ArrayList());
        }
        PnlOwnershipListCtrl ownershipListCtrl = new PnlOwnershipListCtrl();
        ownershipListCtrl.with(parameter).with(this).init();
        showPanel(getJPanel(getContainer(), "pnlOwnership"), ownershipListCtrl.getContainer());
    }

    @Override
    protected boolean _doSaveEntity() {
        if (newEntity) {
            return employeeBo.saveOrUpdate((InvEmployee) objEntity,
                    (List) parameter.get("ownerships"));
        } else {
            return super._doSaveEntity();
        }
    }
}