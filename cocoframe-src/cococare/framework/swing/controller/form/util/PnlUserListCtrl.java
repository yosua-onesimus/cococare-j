package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.obj.util.UtilFilter;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlUserListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCButton btnChangePassword;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return UtilUser.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setHqlFilters(UtilFilter.isUserNotRoot);
    }

    @Override
    protected void _initNaviElements() {
        tblEntity.setNaviElements(swingView.getPgnEntity(), swingView.getTxtKeyword(),
                swingView.getBtnView(), swingView.getBtnEdit(), btnChangePassword, swingView.getBtnDelete());
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(btnChangePassword, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doChangePassword();
            }
        });
    }

    private void _doChangePassword() {
        new PnlChangePasswordCtrl().with(this).init(tblEntity.getSelectedItem());
    }

    @Override
    protected boolean _doDeleteEntity() {
        return tblEntity.deleteBySetting(_getSelectedItem()) > 0;
    }
}