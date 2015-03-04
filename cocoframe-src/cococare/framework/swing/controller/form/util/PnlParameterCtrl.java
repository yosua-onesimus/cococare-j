package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getLabel;
import static cococare.common.CCLogic.isNotNull;
import cococare.framework.model.obj.util.UtilConfig;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.framework.swing.CFSwingMap.newContainer;
import cococare.framework.swing.CFSwingView;
import static cococare.swing.CCSwing.initComponent;
import javax.swing.JPanel;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlParameterCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JPanel pnlGenerator;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return isNotNull(objEntity) ? objEntity.getClass() : UtilConfig.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initContainer() {
        swingView = new CFSwingView(newContainer(PnlParameterCtrl.class));
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        edtEntity.generateDefaultEditor(pnlGenerator);
        initComponent(getContainer(), this, reinitComponents);
    }

    @Override
    protected String _getTabTitle() {
        return getLabel(_getEntity()) + ": " + super._getTabTitle();
    }
}