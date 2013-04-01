package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import cococare.swing.CCTable;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.inv.InvEmployeeBo;
import model.obj.inv.InvEmployee;
import model.obj.inv.InvInventory;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class PnlEmployeeCtrl extends CFSwingCtrl {

    private InvEmployeeBo employeeBo;
    private CCBandBox bndInventory;
    private CCButton btnAddInventory;
    private CCButton btnRemoveInventory;
    private CCTable tblOwnership;

    @Override
    protected Class _getEntity() {
        return InvEmployee.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        //
        employeeBo.load((InvEmployee) objEntity);
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        //
        bndInventory.initTable(InvInventory.class, "name");
        _initTblOwnership();
    }

    protected void _initTblOwnership() {
        tblOwnership = CCSwing.newCCTable(getContainer(), "tblOwnership", InvOwnership.class);
        tblOwnership.setVisibleField(false, "employee");
    }

    @Override
    protected void _initAccessible() {
        super._initAccessible();
        //
        CCSwing.addAccessibleListener(btnAddInventory, accessibleIfEditable);
        CCSwing.addAccessibleListener(btnRemoveInventory, accessibleIfEditable);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addActionListener(btnAddInventory, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                _doAddInventory();
            }
        });
        CCSwing.addActionListener(btnRemoveInventory, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                _doRemoveInventory();
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return employeeBo.save();
    }

    private void _doAddInventory() {
        if (bndInventory.getObject() != null) {
            employeeBo.addOwnership((InvInventory) bndInventory.getObject());
            _doUpdateTblOwnership();
        }
    }

    private void _doRemoveInventory() {
        if (tblOwnership.isSelected()) {
            employeeBo.removeOwnership(tblOwnership.getSelectedRow());
            _doUpdateTblOwnership();
        }
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        //
        _doUpdateTblOwnership();
    }

    protected void _doUpdateTblOwnership() {
        tblOwnership.setList(employeeBo.getOwnerships());
    }
}