package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.*;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNullOrEmpty;
import static cococare.common.CCMessage.logp;
import cococare.database.CCEntityModule;
import cococare.framework.model.obj.util.UtilConfig;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.*;
import cococare.swing.component.CCComboBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlParameterListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCComboBox cmbEntity;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        if (isNotNull(cmbEntity) && cmbEntity.getSelectedIndex() > -1) {
            return CCEntityModule.INSTANCE.getCCHibernate().getParameterClasses().get(cmbEntity.getSelectedIndex());
        } else {
            return UtilConfig.class;
        }
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        for (Class clazz : CCEntityModule.INSTANCE.getCCHibernate().getParameterClasses()) {
            cmbEntity.addItem(getLabel(clazz));
        }
    }

    @Override
    protected void _initNaviElements() {
        super._initNaviElements();
        CCAccessibleListener notUtilConfig = new CCAccessibleListener() {
            @Override
            public boolean isAccessible() {
                return !UtilConfig.class.equals(_getEntity());
            }
        };
        addAccessibleListener(swingView.getBtnAdd(), notUtilConfig);
        addAccessibleListener(swingView.getBtnEdit(), notUtilConfig);
        addAccessibleListener(swingView.getBtnDelete(), notUtilConfig);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbEntity, alSearch);
    }

    @Override
    protected boolean _doShowEditor(boolean readonly, Object objEntity) {
        String controllerClass = getCCTypeConfig(_getEntity()).controllerClass();
        if (isNullOrEmpty(controllerClass)) {
            return super._doShowEditor(readonly, objEntity);
        } else {
            try {
                return ((CFSwingCtrl) newObject(controllerClass)).with(parameter).with(this).with(readonly).init(objEntity);
            } catch (NullPointerException nullPointerException) {
                logp(nullPointerException);
                return false;
            }
        }
    }

    @Override
    public void doUpdateTable() {
        applyAccessible(swingView.getBtnAdd());
        tblEntity.setEntity(_getEntity());
        super.doUpdateTable();
    }
}