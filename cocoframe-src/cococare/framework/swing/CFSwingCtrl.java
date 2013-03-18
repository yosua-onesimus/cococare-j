package cococare.framework.swing;

// <editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.*;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.showDeleted;
import static cococare.common.CCMessage.showSaved;
import cococare.framework.common.CFViewCtrl;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.swing.CCEditor;
import cococare.swing.CCHotkey;
import static cococare.swing.CCSwing.*;
import cococare.swing.CCTable;
import java.awt.Container;
import java.awt.event.*;
import java.util.HashMap;
// </editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class CFSwingCtrl extends CFViewCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    protected CFSwingView swingView;
    //
    protected CCTable tblEntity;
    protected ActionListener alAdd;
    protected ActionListener alView;
    protected ActionListener alEdit;
    protected ActionListener alDelete;
    protected KeyListener klSearch;
    protected HashMap<String, CFSwingCtrl> sysRef_swingCtrl;
    //
    protected CCEditor edtEntity;
    protected CCAccessibleListener accessibleIfEditable;
    protected CCAccessibleListener accessibleIfReadonly;
    protected ActionListener alNew;
    protected ActionListener alSave;
    protected ActionListener alSaveAndNew;
    protected ActionListener alCancel;
    protected ActionListener alClose;
//</editor-fold>

    @Override
    protected void _initContainer() {
        swingView = new CFSwingView(newContainer(getClass()));
    }

    public Container getContainer() {
        return swingView.getContainer();
    }

    @Override
    public void doShowTab(String sysRef, String title, CFViewCtrl viewCtrl) {
        swingView.getTabEntity().addTab(title, ((CFSwingCtrl) viewCtrl).getContainer());
        sysRef_swingCtrl.put(sysRef, ((CFSwingCtrl) viewCtrl));
        swingView.getTabEntity().setSelectedComponent(sysRef_swingCtrl.get(sysRef).getContainer());
        swingView.getTabEntity().requestFocusInWindow();
    }

    @Override
    public void doCloseTab(String sysRef) {
        swingView.getTabEntity().remove(sysRef_swingCtrl.remove(sysRef).getContainer());
    }

    @Override
    protected void _initLanguage() {
        applyLanguage(getContainer());
    }

    @Override
    protected void _initPrivilege() {
        new CFSwingUae().isAccessible(getClass(), getContainer());
    }

    @Override
    protected void _initObject() {
        super._initObject();
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            sysRef_swingCtrl = new HashMap();
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            sysRef = getSysRef(objEntity);
            sysRef = objEntity.toString();
        }
    }

    @Override
    protected void _initComponent() {
        initComponent(getContainer(), this);
        super._initComponent();
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected void _initTable() {
        if (_hasEntity() && isNotNull(swingView.getTblEntity())) {
            tblEntity = new CCTable(swingView.getTblEntity(), _getEntity());
            swingView.getTblEntity().requestFocusInWindow();
        }
    }

    @Override
    protected void _initNaviElements() {
        if (_hasTblEntity()) {
            tblEntity.setNaviElements(swingView.getPgnEntity(), swingView.getTxtKeyword(),
                    swingView.getBtnView(), swingView.getBtnEdit(), swingView.getBtnDelete());
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    @Override
    protected void _initEditor() {
        if (_hasEntity()) {
            edtEntity = new CCEditor(getContainer(), _getEntity());
            _initObjEntity();
        }
    }

    @Override
    protected void _initObjEntity() {
        if (newEntity) {
            edtEntity.initSequence(objEntity);
        }
    }

    @Override
    protected void _initAccessible() {
        accessibleIfEditable = new CCAccessibleListener() {

            @Override
            public boolean isAccessible() {
                return !readonly;
            }
        };
        accessibleIfReadonly = new CCAccessibleListener() {

            @Override
            public boolean isAccessible() {
                return readonly;
            }
        };
        addAccessibleListener(swingView.getBtnEdit(), accessibleIfReadonly);
        addAccessibleListener(swingView.getBtnSave(), accessibleIfEditable);
        addAccessibleListener(swingView.getBtnSaveAndNew(), accessibleIfEditable);
        addAccessibleListener(swingView.getBtnCancel(), accessibleIfEditable);
    }

    @Override
    protected void _doUpdateAccessible() {
        if (_hasEdtEntity()) {
            applyAccessible(swingView.getBtnEdit(), swingView.getBtnSave(), swingView.getBtnSaveAndNew(), swingView.getBtnCancel());
            if (readonly) {
                edtEntity.setAccessible2Readonly();
            } else {
                edtEntity.setAccessible2Default();
            }
        }
    }
//</editor-fold>

    @Override
    protected void _initListener() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            alAdd = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doAdd();
                }
            };
            alView = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doView();
                }
            };
            alEdit = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doEdit();
                }
            };
            alDelete = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doDelete();
                }
            };
            klSearch = new KeyAdapter() {

                @Override
                public void keyReleased(KeyEvent e) {
                    _doSearch();
                }
            };
            addFocusListener(swingView.getTabEntity(), new FocusAdapter() {

                @Override
                public void focusGained(FocusEvent focusEvent) {
                    focusEvent.getComponent().transferFocus();
                }
            });
            addActionListener(swingView.getBtnAdd(), alAdd);
            addActionListener(swingView.getBtnView(), alView);
            addActionListener(swingView.getBtnEdit(), alEdit);
            addActionListener(swingView.getBtnDelete(), alDelete);
            addKeyListener(swingView.getTxtKeyword(), klSearch);
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
                new CCHotkey(getContainer()).add(KeyEvent.VK_ESCAPE, alClose);
            }
            alNew = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //new data
                }
            };
            alEdit = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    setReadonly(false);
                }
            };
            alSave = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doSave();
                }
            };
            alSaveAndNew = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doSave();
                    //new data
                }
            };
            alCancel = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    setReadonly(true);
                }
            };
            alClose = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    _doClose();
                }
            };
            addActionListener(swingView.getBtnNew(), alNew);
            addActionListener(swingView.getBtnEdit(), alEdit);
            addActionListener(swingView.getBtnSave(), alSave);
            addActionListener(swingView.getBtnSaveAndNew(), alSaveAndNew);
            addActionListener(swingView.getBtnCancel(), alCancel);
            addActionListener(swingView.getBtnClose(), alClose);
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected boolean _hasTblEntity() {
        return isNotNull(tblEntity);
    }

    @Override
    protected boolean _isSelected() {
        return _hasTblEntity() && tblEntity.isSelected();
    }

    @Override
    protected Object _getSelectedItem() {
        return tblEntity.getSelectedItem();
    }

    @Override
    protected boolean _isSureDelete() {
        return isSureDelete();
    }

    @Override
    protected boolean _doDeleteEntity() {
        return tblEntity.deleteById(_getSelectedItem()) > 0;
    }

    @Override
    protected void _showDeleted(boolean success) {
        showDeleted(success);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    @Override
    protected boolean _hasEdtEntity() {
        return isNotNull(edtEntity);
    }

    @Override
    protected boolean _isValueValid() {
        return edtEntity.isValueValid();
    }

    @Override
    protected boolean _isValueCompare() {
        return edtEntity.isValueCompare();
    }

    @Override
    protected boolean _isValueUnique() {
        return edtEntity.isValueUnique();
    }

    @Override
    protected boolean _isSureSave() {
        return isSureSave();
    }

    @Override
    protected void _getValueFromEditor() {
        objEntity = edtEntity.getValueFromEditor();
    }

    @Override
    protected boolean _doSaveEntity() {
        return edtEntity.saveOrUpdate(objEntity);
    }

    @Override
    protected void _showSaved(boolean success) {
        showSaved(success);
    }

    @Override
    protected boolean _isValueChanges() {
        return edtEntity.isValueChanges();
    }

    @Override
    protected boolean _isSureDataNotSaved() {
        return isSureDataNotSaved();
    }
//</editor-fold>

    @Override
    protected void _doShowScreen() {
        if (ShowMode.PANEL_MODE.equals(_getShowMode())) {
            showPanel(getContent(), swingView.getPanel());
        } else if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
            showDialog(getMainScreen(), swingView.getDialog());
        } else if (ShowMode.TAB_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                showPanel(getContent(), swingView.getPanel());
            } else {
                callerCtrl.doShowTab(sysRef, newEntity ? turn(New) : coalesce(getUniqueKeyValue(objEntity), readonly ? turn(View) : turn(Edit)).toString(), this);
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected boolean _doShowEditor(boolean readonly, Object objEntity) {
        sysRef = getSysRef(objEntity);
        sysRef = objEntity.toString();
        if (isNotNull(sysRef_swingCtrl.get(sysRef))) {
            CFSwingCtrl swingCtrl = sysRef_swingCtrl.get(sysRef);
            swingCtrl.setReadonly(readonly);
            swingView.getTabEntity().setSelectedComponent(swingCtrl.getContainer());
            return false;
        } else {
            return ((CFSwingCtrl) newObject(getControllerForm(getClass()))).with(parameter).with(this).with(readonly).init(objEntity);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    @Override
    protected void _doCloseScreen() {
        if (ShowMode.PANEL_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                showPanel(getContent(), null);
            } else {
                callerCtrl.init();
            }
        } else if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
            swingView.getDialog().dispose();
        } else if (ShowMode.TAB_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                showPanel(getContent(), null);
            } else {
                callerCtrl.doCloseTab(sysRef);
                if (updateCaller) {
                    if (newEntity) {
                        callerCtrl.doUpdateTable();
                    } else {
                        callerCtrl.doUpdateTablePartial(objEntity);
                    }
                }
            }
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    public void doUpdateTable() {
        if (_hasTblEntity()) {
            tblEntity.search();
        }
    }

    @Override
    public void doUpdateTablePartial(Object objEntity) {
        if (_hasTblEntity()) {
            tblEntity.reloadItem(objEntity);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    @Override
    protected void _doUpdateEditor() {
        if (_hasEdtEntity()) {
            edtEntity.setValueToEditor(objEntity);
        }
    }
//</editor-fold>
}