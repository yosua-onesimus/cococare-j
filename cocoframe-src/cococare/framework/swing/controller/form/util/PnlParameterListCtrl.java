package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.getCCTypeConfig;
import static cococare.common.CCLogic.isNotNull;
import cococare.database.CCEntityModule;
import cococare.framework.model.obj.util.UtilConfig;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addAccessibleListener;
import static cococare.swing.CCSwing.applyAccessible;
import cococare.swing.component.CCComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        //
        for (Class clazz : CCEntityModule.INSTANCE.getCCHibernate().getParameterClasses()) {
            cmbEntity.addItem(getCCTypeConfig(clazz).label());
        }
    }

    @Override
    protected void _initNaviElements() {
        super._initNaviElements();
        //
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
        //
        cmbEntity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _doSearch();
            }
        });
    }

    @Override
    public void doUpdateTable() {
        applyAccessible(swingView.getBtnAdd());
        tblEntity.setEntity(_getEntity());
        //
        super.doUpdateTable();
    }
}