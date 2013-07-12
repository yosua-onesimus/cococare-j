package controller.form.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import model.bo.inv.InvInventoryBo;
import model.obj.inv.InvInventory;
//</editor-fold>

public class PnlInventoryCtrl extends CFSwingCtrl {

    private InvInventoryBo inventoryBo;
    private JTextField txtQuantityTotal;
    private JTextField txtQuantityUsed;
    private JTextField txtQuantityAvailable;

    @Override
    protected Class _getEntity() {
        return InvInventory.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        //
        inventoryBo.load((InvInventory) objEntity);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //
        CCSwing.addKeyListener(txtQuantityTotal, new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtQuantityAvailable.setText(CCFormat.formatInteger(CCFormat.parseInt(txtQuantityTotal.getText()) - CCFormat.parseInt(txtQuantityUsed.getText())));
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return inventoryBo.save();
    }
}