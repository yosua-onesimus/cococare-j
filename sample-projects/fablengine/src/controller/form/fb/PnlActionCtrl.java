package controller.form.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import javax.swing.JTextField;
import model.obj.fb.FbAction;
//</editor-fold>

public class PnlActionCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JTextField txtAttributes;
//</editor-fold>

    @Override
    protected Class _getClass() {
        return PnlActionCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return FbAction.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        parameter.put(toString() + "txtAttributes", txtAttributes);
        _addChildScreen("action", new PnlActionAttributeListCtrl(), "pnlAttribute");
    }
}