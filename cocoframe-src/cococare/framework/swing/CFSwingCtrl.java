package cococare.framework.swing;

// <editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.newObject;
import static cococare.common.CCClass.setValue;
import static cococare.common.CCFinal.btnEdit;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.*;
import cococare.database.CCHibernateFilter;
import static cococare.database.CCLoginInfo.INSTANCE_isCompAccessible;
import cococare.framework.common.CFViewCtrl;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.swing.CCEditor;
import cococare.swing.CCHotkey;
import static cococare.swing.CCSwing.*;
import cococare.swing.CCTable;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    protected List<Component> reinitComponents = new ArrayList();
    protected CCTable tblEntity;
    protected ActionListener alAdd;
    protected ActionListener alView;
    protected ActionListener alEdit;
    protected ActionListener alDelete;
    protected ActionListener alExport;
    protected KeyListener klSearch;
    protected HashMap<String, CFSwingCtrl> sysRef_swingCtrl;
    //
    protected CCEditor edtEntity;
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
        try {
            swingView.getTabEntity().remove(sysRef_swingCtrl.remove(sysRef).getContainer());
        } catch (Exception exception) {
            logp(exception.toString());
        }
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
        if (_hasEntity()) {
            if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
                sysRef_swingCtrl = new HashMap();
            } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
                sysRef = _getSysRef(objEntity);
            }
        }
    }

    @Override
    protected void _initComponent() {
        initComponent(getContainer(), this, reinitComponents);
        super._initComponent();
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected void _initTable() {
        if (_hasEntity() && isNotNull(swingView.getTblEntity())) {
            tblEntity = new CCTable(swingView.getTblEntity(), _getEntity());
            swingView.getTblEntity().requestFocusInWindow();
        }
        //parent-childs-screen
        if (isNotNull(parameter.get(toString() + parentValue))) {
            final Object dummy = this;
            tblEntity.setVisibleField(false, parameter.get(toString() + parentField).toString());
            tblEntity.setHqlFilters(new CCHibernateFilter() {
                @Override
                public String getFieldName() {
                    return parameter.get(dummy.toString() + parentField).toString();
                }

                @Override
                public Object getFieldValue() {
                    return parameter.get(dummy.toString() + parentValue);
                }
            });
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
            if (newEntity) {
                _initObjEntity();
            }
        }
    }

    @Override
    protected void _initObjEntity() {
        edtEntity.initSequence(objEntity);
        //parent-childs-screen
        if (isNotNull(parameter.get(toString() + parentValue))) {
            setValue(objEntity, parameter.get(toString() + parentField).toString(), parameter.get(toString() + parentValue));
        }
    }

    @Override
    protected void _initAccessible() {
        if (isNotNull(getControllerForm(getClass())) && !INSTANCE_isCompAccessible(getControllerForm(getClass()).getName() + "." + btnEdit)) {
            addAccessibleListener(swingView.getBtnEdit(), CCAccessibleListener.nonAccessible);
        }
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
            alExport = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _doExport();
                }
            };
            klSearch = new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    _doSearch();
                }
            };
//            addFocusListener(swingView.getTabEntity(), new FocusAdapter() {
//                @Override
//                public void focusGained(FocusEvent focusEvent) {
//                    focusEvent.getComponent().transferFocus();
//                }
//            });
            addActionListener(swingView.getBtnAdd(), alAdd);
            addActionListener(swingView.getBtnView(), alView);
            addActionListener(swingView.getBtnEdit(), alEdit);
            addActionListener(swingView.getBtnDelete(), alDelete);
            addActionListener(swingView.getBtnExport(), alExport);
            addKeyListener(swingView.getTxtKeyword(), klSearch);
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
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
            if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
                new CCHotkey(getContainer()).add(KeyEvent.VK_ESCAPE, alClose);
            }
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
        //parent-childs-screen
        if (getBoolean(parameter.get(toString() + parentNewEntity))) {
            return ((List) parameter.get(toString() + childsValue)).remove(_getSelectedItem());
        } else {
            return tblEntity.deleteById(_getSelectedItem()) > 0;
        }
    }

    @Override
    protected void _showDeleted(boolean success) {
        showDeleted(success);
    }

    @Override
    protected boolean _doExportMulti() {
        return tblEntity.export2Excel();
    }

    @Override
    protected boolean _doExportSingle() {
        return true;
    }

    @Override
    protected void _showExported(boolean success) {
        if (!success) {
            showError();
        }
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
        //return edtEntity.saveOrUpdate(objEntity);
        //parent-childs-screen
        if (getBoolean(parameter.get(toString() + parentNewEntity))) {
            List list = (List) parameter.get(toString() + childsValue);
            return list.contains(objEntity) ? true : list.add(objEntity);
        } else {
            return edtEntity.saveOrUpdate(objEntity, _getEntityChilds());
        }
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
        //parent-childs-screen
        if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction()) || isNull(parameter.get(toString() + parentValue))) {
            if (ShowMode.PANEL_MODE.equals(_getShowMode())) {
                showPanel(getContent(), swingView.getPanel());
            } else if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
                showDialog(getMainScreen(), swingView.getDialog());
            } else if (ShowMode.TAB_MODE.equals(_getShowMode())) {
                if (isNull(callerCtrl)) {
                    showPanel(getContent(), swingView.getPanel());
                } else {
                    callerCtrl.doShowTab(sysRef, _getTabTitle(), this);
                }
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected boolean _doShowEditor(boolean readonly, Object objEntity) {
        sysRef = _getSysRef(objEntity);
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
                removePanel(getContent(), getContainer());
            } else {
                callerCtrl.init();
            }
        } else if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
            swingView.getDialog().dispose();
        } else if (ShowMode.TAB_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                removePanel(getContent(), getContainer());
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
            //parent-childs-screen
            if (getBoolean(parameter.get(toString() + parentNewEntity))) {
                tblEntity.setList((List) parameter.get(toString() + childsValue));
            } else {
                tblEntity.search();
            }
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

    //parent-childs-screen
    protected void _addChildScreen(String parentField, CFSwingCtrl childCtrl, String childView) {
        parameter.put(childCtrl.toString() + this.parentField, parentField);
        parameter.put(childCtrl.toString() + this.parentValue, objEntity);
        parameter.put(childCtrl.toString() + this.parentNewEntity, newEntity);
        parameter.put(childCtrl.toString() + this.childsValue, new ArrayList());
        childCtrl.with(parameter).init();
        showPanel(getJPanel(getContainer(), childView), childCtrl.getContainer());
        childsValueKeys.add(childCtrl.toString() + this.childsValue);
    }
}