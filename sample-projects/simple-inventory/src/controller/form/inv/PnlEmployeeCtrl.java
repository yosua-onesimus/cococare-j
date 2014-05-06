package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.formatNumber;
import static cococare.common.CCFormat.unformatNumber;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addKeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import model.bo.inv.InvConfigBo;
import model.bo.inv.InvEmployeeBo;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class PnlEmployeeCtrl extends CFSwingCtrl {

    //
    private InvEmployeeBo employeeBo;
    private InvConfigBo configBo;
    private JTextField txtSalary;
    private JTextField txtBonusPercent;
    private JTextField txtBonusAmount;

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
        InvEmployee employee = (InvEmployee) objEntity;
        employee.setSalary(configBo.loadInvConfig().getDefaultSalary());
        employee.setBonusPercent(configBo.loadInvConfig().getDefaultBonus());
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen("employee", new PnlOwnershipListCtrl(), "pnlOwnership");
    }

    @Override
    protected void _initListener() {
        super._initListener();
        KeyListener klUpdateTxtBonusAmount = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                _doUpdateTxtBonusAmount();
            }
        };
        addKeyListener(txtSalary, klUpdateTxtBonusAmount);
        addKeyListener(txtBonusPercent, klUpdateTxtBonusAmount);
    }

    @Override
    protected boolean _doSaveEntity() {
        return employeeBo.saveOrUpdate((InvEmployee) objEntity, _getEntityChilds());
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        _doUpdateTxtBonusAmount();
    }

    private void _doUpdateTxtBonusAmount() {
        txtBonusAmount.setText(formatNumber(unformatNumber(txtSalary.getText()) * unformatNumber(txtBonusPercent.getText()) / 100d));
    }
}