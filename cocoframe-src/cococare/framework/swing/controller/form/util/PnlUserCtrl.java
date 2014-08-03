package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.extract;
import cococare.common.CCCustomField;
import static cococare.common.CCLanguage.Privilege;
import static cococare.common.CCLanguage.turn;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.IS_NOT_IP;
import static cococare.common.CCMessage.showInformation;
import cococare.framework.model.bo.util.UtilUserBo;
import cococare.framework.model.obj.util.UtilFilter.isIdNotInIds;
import cococare.framework.model.obj.util.*;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addActionListener;
import static cococare.swing.CCSwing.newCCTable;
import cococare.swing.CCTable;
import cococare.swing.component.CCBandBox;
import cococare.swing.component.CCButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlUserCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilUserBo userBo;
    private CCBandBox bndUserGroup;
    private CCTable tblPrivilege;
    private ActionListener alSelect = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            _doSelect(((JCheckBox) actionEvent.getSource()).isSelected());
        }
    };
    private JTextField txtIp;
    private CCButton btnIpAdd;
    private CCButton btnIpRemove;
    private CCTable tblIp;
    private CCBandBox bndArea;
    private CCButton btnAreaAdd;
    private CCButton btnAreaRemove;
    private CCTable tblArea;
//</editor-fold>

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
        bndUserGroup.getTable().setHqlFilters(UtilFilter.isUserGroupNotRoot);
        //privilege
        _initTblPrivilege();
        _initTblIp();
        _initTblArea();
    }

    private void _initTblPrivilege() {
        tblPrivilege = newCCTable(getContainer(), "tblPrivilege", UtilPrivilege.class);
        tblPrivilege.setVisibleField(false, "name");
        tblPrivilege.addField(0, new CCCustomField() {
            @Override
            public Object getCustomView(Object object) {
                UtilPrivilege privilege = (UtilPrivilege) object;
                JCheckBox checkBox = new JCheckBox(null, null, privilege.isSelected());
                checkBox.addActionListener(alSelect);
                checkBox.addActionListener(tblPrivilege.getStopCellEditingListener());
                return checkBox;
            }
        });
        tblPrivilege.addField(1, new CCCustomField() {
            @Override
            public String getLabel() {
                return turn(Privilege);
            }

            @Override
            public Object getCustomView(Object object) {
                UtilPrivilege privilege = (UtilPrivilege) object;
                return (isNull(privilege.getParent()) ? "" : "    ") + privilege.getCode() + "-" + privilege.getName();
            }
        });
        tblPrivilege.setCheckboxColumn(true, 0);
        tblPrivilege.setColumnWidth(0, 20);
    }

    private void _initTblIp() {
        tblIp = newCCTable(getContainer(), "tblIp", UtilUserIp.class);
        tblIp.setNaviElements(null, null, btnIpRemove);
    }

    private void _initTblArea() {
        bndArea.initTable(UtilArea.class, "name");
        bndArea.getTable().setHqlFilters(new isIdNotInIds() {
            @Override
            public Object getFieldValue() {
                return extract(tblArea.getList(), "area.id");
            }
        });
        tblArea = newCCTable(getContainer(), "tblArea", UtilUserArea.class);
        tblArea.setNaviElements(null, null, btnAreaRemove);
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        //privilege
        tblPrivilege.setEditableColumn(!readonly, 0);
    }

    @Override
    protected void _initListener() {
        super._initListener();
        //privilege
        bndUserGroup.addEventListenerOnSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userBo.getPrivileges((UtilUserGroup) bndUserGroup.getObject());
                tblPrivilege.reloadItems();
            }
        });
        addActionListener(btnIpAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doIpAdd();
            }
        });
        addActionListener(btnIpRemove, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doIpRemove();
            }
        });
        addActionListener(btnAreaAdd, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doAreaAdd();
            }
        });
        addActionListener(btnAreaRemove, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doAreaRemove();
            }
        });
    }

    @Override
    protected boolean _doSaveEntity() {
        return userBo.saveOrUpdate();
    }

    private void _doSelect(boolean selected) {
        UtilPrivilege privilege = tblPrivilege.getSelectedItem();
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

    private void _doIpAdd() {
        String ip = txtIp.getText();
        if (isIp(ip)) {
            userBo.addUserIp(ip);
            txtIp.setText("");
            _doUpdateTblIp();
        } else {
            showInformation(IS_NOT_IP("IP"));
        }
    }

    private void _doIpRemove() {
        txtIp.setText("");
        userBo.removeUserIp(tblIp.getSelectedRow());
        _doUpdateTblIp();
    }

    private void _doAreaAdd() {
        UtilArea area = bndArea.getObject();
        if (isNotNull(area)) {
            userBo.addUserArea(area);
            bndArea.setObject(null);
            bndArea.getTable().search();
            _doUpdateTblArea();
        }
    }

    private void _doAreaRemove() {
        bndArea.setObject(null);
        bndArea.getTable().search();
        userBo.removeUserArea(tblArea.getSelectedRow());
        _doUpdateTblArea();
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        //privilege
        _doUpdateTblPrivilege();
        _doUpdateTblIp();
        _doUpdateTblArea();
    }

    private void _doUpdateTblPrivilege() {
        tblPrivilege.setList(userBo.getPrivileges());
    }

    private void _doUpdateTblIp() {
        tblIp.setList(userBo.getUserIps());
    }

    private void _doUpdateTblArea() {
        tblArea.setList(userBo.getUserAreas());
    }
}