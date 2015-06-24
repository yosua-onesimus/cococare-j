package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.wf.WfActivity;
import static cococare.framework.model.obj.wf.WfFilter.isTypeIsViewCustomization;
import cococare.framework.model.obj.wf.WfProcess;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCComboBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlActivityCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCComboBox cmbProcess;
    private CCBandBox bndViewCustomization;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfActivity.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        cmbProcess = (CCComboBox) parameter.get(callerCtrl.toString() + "cmbProcess");
        super._initComponent();
        _addChildScreen("origin", new PnlTransitionListCtrl(), "pnlTransition");
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndViewCustomization.getTable().setHqlFilters(isTypeIsViewCustomization);
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        ((WfActivity) objEntity).setProcess((WfProcess) cmbProcess.getSelectedObject());
    }
}