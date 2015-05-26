package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.obj.fb.FbMap;
//</editor-fold>

public class PnlMapCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JTextField txtSizeX;
    private JTextField txtSizeY;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return FbMap.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alUpdateTile = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTile();
            }
        };
        addListener2(txtSizeX, alUpdateTile);
        addListener2(txtSizeY, alUpdateTile);
    }

    private void _doUpdateTile() {
        System.out.println("_doUpdateTile()");
    }
}