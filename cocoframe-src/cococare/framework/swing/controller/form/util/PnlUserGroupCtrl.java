package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.extract;
import cococare.common.CCCustomField;
import static cococare.common.CCLanguage.Privilege;
import static cococare.common.CCLanguage.turn;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.IS_NOT_IP;
import static cococare.common.CCMessage.showInformation;
import cococare.framework.model.bo.util.UtilUserGroupBo;
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
public class PnlUserGroupCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilUserGroupBo userGroupBo;
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
        return UtilUserGroup.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        //privilege
        userGroupBo.load((UtilUserGroup) objEntity);
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
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
        tblIp = newCCTable(getContainer(), "tblIp", UtilUserGroupIp.class);
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
        tblArea = newCCTable(getContainer(), "tblArea", UtilUserGroupArea.class);
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
        return userGroupBo.saveOrUpdate();
    }

    private void _doSelect(boolean selected) {
        UtilPrivilege privilege = tblPrivilege.getSelectedItem();
        privilege.setSelected(selected);
        tblPrivilege.reloadSelectedItem();
        if (selected) {
            if (isNotNull(privilege.getParent())) {
                UtilPrivilege parent = privilege.getParent();
                parent.setSelected(selected);
                tblPrivilege.reloadItem(userGroupBo.getPrivilegeIndex(parent));
            }
        } else {
            if (isNotNullAndNotEmpty(privilege.getChilds())) {
                for (UtilPrivilege child : privilege.getChilds()) {
                    child.setSelected(selected);
                    tblPrivilege.reloadItem(userGroupBo.getPrivilegeIndex(child));
                }
            }
        }
    }

    private void _doIpAdd() {
        String ip = txtIp.getText();
        if (isIp(ip)) {
            userGroupBo.addUserGroupIp(ip);
            txtIp.setText("");
            _doUpdateTblIp();
        } else {
            showInformation(IS_NOT_IP("IP"));
        }
    }

    private void _doIpRemove() {
        txtIp.setText("");
        userGroupBo.removeUserGroupIp(tblIp.getSelectedRow());
        _doUpdateTblIp();
    }

    private void _doAreaAdd() {
        UtilArea area = bndArea.getObject();
        if (isNotNull(area)) {
            userGroupBo.addUserGroupArea(area);
            bndArea.setObject(null);
            bndArea.getTable().search();
            _doUpdateTblArea();
        }
    }

    private void _doAreaRemove() {
        bndArea.setObject(null);
        bndArea.getTable().search();
        userGroupBo.removeUserGroupArea(tblArea.getSelectedRow());
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
        tblPrivilege.setList(userGroupBo.getPrivileges());
    }

    private void _doUpdateTblIp() {
        tblIp.setList(userGroupBo.getUserGroupIps());
    }

    private void _doUpdateTblArea() {
        tblArea.setList(userGroupBo.getUserGroupAreas());
    }
}