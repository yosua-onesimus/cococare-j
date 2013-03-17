package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import static cococare.common.CCLogic.*;
import cococare.framework.model.bo.util.UtilUserBo;
import cococare.framework.model.obj.util.UtilPrivilege;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.getCCBandBox;
import static cococare.swing.CCSwing.newCCTable;
import cococare.swing.CCTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlUserCtrl extends CFSwingCtrl {

    private UtilUserBo userBo;
    private CCTable tblPrivilege;
    private ActionListener alSelect = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            _doSelect(((JCheckBox) actionEvent.getSource()).isSelected());
        }
    };

    @Override
    protected Class _getEntity() {
        return UtilUser.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        //privilege
        userBo.load((UtilUser) objEntity);
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        //
        if (!newEntity) {
            edtEntity.unreg("xPassword");
            edtEntity.unreg("txtPassword");
            edtEntity.unreg("xRetypePassword");
            edtEntity.unreg("txtRetypePassword");
        }
        //
        getCCBandBox(getContainer(), "bndUserGroup").addEventListenerOnSelect(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userBo.getPrivileges((UtilUserGroup) getCCBandBox(getContainer(), "bndUserGroup").getObject());
                tblPrivilege.reloadItems();
            }
        });
        //privilege
        _initTblPrivilege();
    }

    protected void _initTblPrivilege() {
        tblPrivilege = newCCTable(getContainer(), "tblPrivilege", UtilPrivilege.class);
        tblPrivilege.setVisibleField(false, "name");
        tblPrivilege.addField(0, new CCCustomField() {

            @Override
            public Object getCustomView(Object object) {
                UtilPrivilege privilege = (UtilPrivilege) object;
                JCheckBox checkBox = new JCheckBox(null, null, privilege.isSelected());
                checkBox.addActionListener(alSelect);
                return checkBox;
            }
        });
        tblPrivilege.addField(1, new CCCustomField() {

            @Override
            public String getLabel() {
                return "Privilege";
            }

            @Override
            public Object getCustomView(Object object) {
                UtilPrivilege privilege = (UtilPrivilege) object;
                return (isNull(privilege.getParent()) ? "" : "    ") + privilege.getName();
            }
        });
        tblPrivilege.setColumnWidth(0, 20);
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        //privilege
        tblPrivilege.setEditableColumn(!readonly, 0);
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        //privilege
        _doUpdateTblPrivilege();
    }

    protected void _doUpdateTblPrivilege() {
        tblPrivilege.setList(userBo.getPrivileges());
    }

    protected void _doSelect(boolean selected) {
        UtilPrivilege privilege = (UtilPrivilege) tblPrivilege.getSelectedItem();
        privilege.setSelected(selected);
        tblPrivilege.reloadSelectedItem();
        if (selected) {
            if (isNotNull(privilege.getParent())) {
                UtilPrivilege parent = privilege.getParent();
                parent.setSelected(selected);
                tblPrivilege.reloadItem(userBo.getPrivilegeIndex(parent));
            }
        } else {
            if (isNotNullAndNotEmpty(privilege.getChilds())) {
                for (UtilPrivilege child : privilege.getChilds()) {
                    child.setSelected(selected);
                    tblPrivilege.reloadItem(userBo.getPrivilegeIndex(child));
                }
            }
        }
    }

    @Override
    protected boolean _doSaveEntity() {
        return userBo.save();
    }
}