package cococare.framework.swing;

// <editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.newObject;
import static cococare.common.CCClass.setValue;
import static cococare.common.CCFinal.SHOW_MODE_TAB_MODE_NOT_APPLICABLE_FOR___AND_IT_CHILD;
import static cococare.common.CCFinal.btnEdit;
import static cococare.common.CCFormat.*;
import static cococare.common.CCLanguage.Filter;
import static cococare.common.CCLanguage.turn;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.*;
import cococare.database.CCHibernateFilter;
import static cococare.database.CCLoginInfo.INSTANCE_isCompAccessible;
import cococare.framework.common.CFViewCtrl;
import static cococare.framework.swing.CFSwingMap.*;
import cococare.swing.CCEditor;
import static cococare.swing.CCEditor.requestFocusInWindow;
import cococare.swing.CCHotkey;
import static cococare.swing.CCHotkey.simpleNavigate;
import static cococare.swing.CCSwing.*;
import cococare.swing.CCTable;
import cococare.swing.component.CCDialog;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
// </editor-fold>

/**
 * CFSwingCtrl is an abstract class which functions as an view controller, in charge of controlling
 * the flow of applications in specific view.
 *
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
    protected ActionListener alSearch;
    protected HashMap<String, CFSwingCtrl> sysRef_swingCtrl;
    //
    protected CCEditor edtEntity;
    protected ActionListener alNew;
    protected ActionListener alSave;
    protected ActionListener alSaveAndNew;
    protected ActionListener alCancel;
    protected ActionListener alClose;
//</editor-fold>

    /**
     * @return nvl2(swingView, _getSuperclass(), getClass())
     */
    @Override
    protected Class _getCustomToDefaultClass() {
        return nvl2(swingView, _getSuperclass(), getClass());
    }

    /**
     * @return nvl2(swingView, getClass(), _getSuperclass())
     */
    @Override
    protected Class _getDefaultToCustomClass() {
        return nvl2(swingView, getClass(), _getSuperclass());
    }

    @Override
    protected void _initContainer() {
        swingView = new CFSwingView(newContainer(_getClass()));
    }

    public Container getContainer() {
        return swingView.getContainer();
    }

    @Override
    public void doShowTab(String sysRef, String title, CFViewCtrl viewCtrl) {
        try {
            if (isNull(sysRef_swingCtrl.get(sysRef))) {
                swingView.getTabEntity().addTab(turn(title), ((CFSwingCtrl) viewCtrl).getContainer());
                sysRef_swingCtrl.put(sysRef, ((CFSwingCtrl) viewCtrl));
            }
            swingView.getTabEntity().setSelectedComponent(sysRef_swingCtrl.get(sysRef).getContainer());
        } catch (Exception exception) {
            throw new RuntimeException(replaceFirst(SHOW_MODE_TAB_MODE_NOT_APPLICABLE_FOR___AND_IT_CHILD, getClass().getSimpleName()), exception);
        }
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
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            sysRef_swingCtrl = new HashMap();
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            if (_hasEntity()) {
                sysRef = _getSysRef(objEntity);
            }
        }
    }

    @Override
    protected void _initComponent() {
        initComponent(getContainer(), this, reinitComponents);
        super._initComponent();
    }

    @Override
    protected void _initTab() {
        if (_hasEntity()) {
            if (isNotNull(swingView.getTabEntity()) && isNullOrEmpty(swingView.getTabEntity().getTitleAt(0))) {
                swingView.getTabEntity().setTitleAt(0, turn(_getEntityLabel()));
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected void _initTable() {
        if (_hasEntity()) {
            if (isNotNull(swingView.getTblEntity())) {
                tblEntity = new CCTable(swingView.getTblEntity(), _getEntity());
                requestFocusInWindow(swingView.getTblEntity());
                //parent-childs-screen
                if (isNotNull(_getParameterParentValue(this))) {
                    if (_getParameterParentNewEntity(this)) {
                        setVisible(false, swingView.getTxtKeyword(), swingView.getBtnFilter(), swingView.getPgnEntity());
                    }
                    final CFViewCtrl dummy = this;
                    tblEntity.setVisibleField(false, _getParameterParentField(this));
                    tblEntity.setHqlFilters(new CCHibernateFilter() {
                        @Override
                        public String getFieldName() {
                            return _getParameterParentField(dummy);
                        }

                        @Override
                        public Object getFieldValue() {
                            return _getParameterParentValue(dummy);
                        }
                    });
                }
            }
        }
    }

    @Override
    protected void _initNaviElements() {
        if (_hasTblEntity()) {
            tblEntity.setNaviElements(swingView.getPgnEntity(), swingView.getTxtKeyword(),
                    swingView.getBtnView(), swingView.getBtnEdit(), swingView.getBtnDelete());
        }
    }

    @Override
    protected void _initFilterElements() {
        if (_hasTblEntity() && isNotNull(swingView.getBtnFilter())) {
            final CCDialog dialog = new CCDialog(getMainScreen(), turn(_getEntityLabel() + " " + Filter), tblEntity.getFilterContainer());
            addListener(swingView.getBtnFilter(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    showDialog(getMainScreen(), dialog);
                }
            });
            addListener(tblEntity.getFilterBtnFilter(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    dialog.dispose();
                }
            });
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    @Override
    protected void _initEditor() {
        if (_hasEntity()) {
            edtEntity = new CCEditor(getContainer(), _getEntity());
            if (isNotNull(swingView.getPnlGenerator())) {
                edtEntity.generateDefaultEditor(swingView.getPnlGenerator(), _getParameterParentField(this));
                initComponent(getContainer(), this, reinitComponents);
            }
            if (newEntity) {
                _initObjEntity();
            }
        }
    }

    @Override
    protected void _initObjEntity() {
        edtEntity.initSequence(objEntity);
        //parent-childs-screen
        if (isNotNull(_getParameterParentValue(this))) {
            setValue(objEntity, _getParameterParentField(this), _getParameterParentValue(this));
        }
    }
//</editor-fold>

    @Override
    protected void _initAccessible() {
        if (_hasTblEntity()) {
            addAccessibleListener(swingView.getBtnAdd(), accessibleIfEditable);
            addAccessibleListener(swingView.getBtnEdit(), accessibleIfEditable);
            addAccessibleListener(swingView.getBtnDelete(), accessibleIfEditable);
        } else if (_hasEdtEntity()) {
            if (isNotNull(getControllerForm(_getClass())) && !INSTANCE_isCompAccessible(getControllerForm(_getClass()).getName() + "." + btnEdit)) {
                addAccessibleListener(swingView.getBtnEdit(), CCAccessibleListener.nonAccessible);
            }
            addAccessibleListener(swingView.getBtnEdit(), accessibleIfReadonly);
            addAccessibleListener(swingView.getBtnSave(), accessibleIfEditable);
            addAccessibleListener(swingView.getBtnSaveAndNew(), accessibleIfEditable);
            addAccessibleListener(swingView.getBtnCancel(), accessibleIfEditable);
        }
    }

    @Override
    protected void _doUpdateAccessible() {
        applyAccessible(swingView.getBtnAdd(), swingView.getBtnEdit(), swingView.getBtnDelete(), swingView.getBtnSave(), swingView.getBtnSaveAndNew(), swingView.getBtnCancel());
        if (_hasEdtEntity()) {
            if (readonly) {
                edtEntity.setAccessible2Readonly();
            } else {
                edtEntity.setAccessible2Default();
            }
        }
    }

    @Override
    protected void _initListener() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            alAdd = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doAdd();
                }
            };
            alView = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doView();
                }
            };
            alEdit = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doEdit();
                }
            };
            alDelete = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doDelete();
                }
            };
            alExport = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doExport();
                }
            };
            alSearch = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doSearch();
                }
            };
            simpleNavigate(swingView.getTabEntity());
            addListener(swingView.getBtnAdd(), alAdd);
            addListener(swingView.getBtnView(), alView);
            addListener(swingView.getBtnEdit(), alEdit);
            addListener(swingView.getBtnDelete(), alDelete);
            addListener(swingView.getBtnExport(), alExport);
//            addListener2(swingView.getTxtKeyword(), alSearch);
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            alNew = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    //new data
                }
            };
            alEdit = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    setReadonly(false);
                }
            };
            alSave = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doSave();
                }
            };
            alSaveAndNew = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doSave();
                    //new data
                }
            };
            alCancel = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    setReadonly(true);
                }
            };
            alExport = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doExport();
                }
            };
            alClose = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doClose();
                }
            };
            if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
                new CCHotkey(swingView.getDialog()).add(KeyEvent.VK_ESCAPE, alClose);
            }
            addListener(swingView.getBtnNew(), alNew);
            addListener(swingView.getBtnEdit(), alEdit);
            addListener(swingView.getBtnSave(), alSave);
            addListener(swingView.getBtnSaveAndNew(), alSaveAndNew);
            addListener(swingView.getBtnCancel(), alCancel);
            addListener(swingView.getBtnExport(), alExport);
            addListener(swingView.getBtnClose(), alClose);
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
    protected <T> T _getSelectedItem() {
        return tblEntity.getSelectedItem();
    }

    @Override
    protected boolean _isSureDelete() {
        return isSureDelete();
    }

    @Override
    protected boolean _doDeleteEntity() {
        //parent-childs-screen
        if (_getParameterParentNewEntity(this)) {
            return _getParameterChildsValue(this).remove(_getSelectedItem());
        } else {
            return tblEntity.deleteBySetting(_getSelectedItem()) > 0;
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
        if (_getParameterParentNewEntity(this)) {
            List list = _getParameterChildsValue(this);
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

    protected JPanel _getContent() {
        //parent-childs-screen
        if (isNull(_getParameterChildContentId(this))) {
            return getContent();
        } else {
            return getJPanel(((CFSwingCtrl) callerCtrl).getContainer(), _getParameterChildContentId(this));
        }
    }

    @Override
    protected void _doShowScreen() {
        if (ShowMode.PANEL_MODE.equals(_getShowMode())) {
            showPanel(_getContent(), swingView.getPanel());
        } else if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
            showDialog(getMainScreen(), swingView.getDialog());
        } else if (ShowMode.TAB_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                showPanel(_getContent(), swingView.getPanel());
            } else {
                sysRef = _getSysRef(objEntity);
                callerCtrl.doShowTab(sysRef, _getTabTitle(), this);
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    @Override
    protected boolean _doShowEditor(boolean readonly, Object objEntity) {
        sysRef = _getSysRef(objEntity);
        if (isNotNull(sysRef_swingCtrl.get(sysRef))) {
            sysRef_swingCtrl.get(sysRef).setReadonly(readonly);
            doShowTab(sysRef, null, null);
            return false;
        } else {
            return newObject(getControllerForm(_getClass())).with(parameter).with(this).with(readonly).init(objEntity);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    @Override
    protected void _doCloseScreen() {
        if (ShowMode.PANEL_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                removePanel(_getContent(), getContainer());
            } else {
                callerCtrl.init();
            }
        } else if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
            swingView.getDialog().dispose();
        } else if (ShowMode.TAB_MODE.equals(_getShowMode())) {
            if (isNull(callerCtrl)) {
                removePanel(_getContent(), getContainer());
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
            if (_getParameterParentNewEntity(this)) {
                tblEntity.setList(_getParameterChildsValue(this));
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

    @Override
    protected void _addChildScreen2(String tabTitle, String parentField, CFViewCtrl childCtrl) {
        String componentId = childCtrl.getClass().getSimpleName();
        if (isNull(getJPanel(getContainer(), componentId))) {
            JPanel panel = new JPanel();
            panel.setName(componentId);
            panel.setLayout(new GroupLayout(panel));
            swingView.getTabEntity().add(turn(tabTitle), panel);
        }
        _addChildScreen(parentField, childCtrl, componentId);
    }
//</editor-fold>
}