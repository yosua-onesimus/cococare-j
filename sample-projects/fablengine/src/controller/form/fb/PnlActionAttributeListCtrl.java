package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.bo.fb.FbActionBo;
import model.obj.fb.FbActionAttribute;
//</editor-fold>

public class PnlActionAttributeListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private FbActionBo actionBo;
    private JTextField txtAttributes;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return FbActionAttribute.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        txtAttributes = (JTextField) parameter.get(callerCtrl.toString() + "txtAttributes");
    }

    @Override
    protected void _initListener() {
        super._initListener();
        tblEntity.addListenerOnChange(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateParentField();
            }
        });
    }

    private void _doUpdateParentField() {
        txtAttributes.setText(actionBo.getAttributes(tblEntity.getList()));
    }
}