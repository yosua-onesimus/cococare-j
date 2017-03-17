package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.*;
import cococare.common.CCField;
import static cococare.common.CCFormat.*;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.logp;
import cococare.common.CCTrackable;
import static cococare.database.CCEntityConfig.FIELD_ID;
import cococare.database.CCHibernateBo;
import cococare.framework.model.bo.util.UtilLoggerBo;
import cococare.framework.model.mdl.util.UtilityModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// </editor-fold>

/**
 * CFViewCtrl is an abstract class which functions as an view controller, in charge of controlling
 * the flow of applications in specific view.
 *
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public abstract class CFViewCtrl implements CCTrackable {

//<editor-fold defaultstate="collapsed" desc=" private enum ">
    protected enum BaseFunction {

        LIST_FUNCTION, FORM_FUNCTION;
    }

    protected enum ShowMode {

        PANEL_MODE, DIALOG_MODE, TAB_MODE;
    }
//</editor-fold>
    //
//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    protected HashMap<String, Object> parameter = new HashMap();
    protected CFViewCtrl callerCtrl;
    protected boolean readonly = false;
    protected Object objEntity = null;
    protected String sysRef;
    protected boolean newEntity = true;
    protected boolean updateCaller = false;
    //
    protected CCAccessibleListener accessibleIfEditable = new CCAccessibleListener() {
        @Override
        public boolean isAccessible() {
            return !readonly;
        }
    };
    protected CCAccessibleListener accessibleIfReadonly = new CCAccessibleListener() {
        @Override
        public boolean isAccessible() {
            return readonly;
        }
    };
    //
    protected UtilLoggerBo loggerBo;
    //parent-childs-screen
    protected final String parentField = "parentField";
    protected final String parentValue = "parentValue";
    protected final String parentNewEntity = "parentNewEntity";
    protected final String childContentId = "childContentId";
    protected final String childsValue = "childsValue";
    protected final String allChildsValue = "allChildsValue";
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CFViewCtrl ">
    /**
     * CFViewCtrl is an abstract class which functions as an view controller, in charge of
     * controlling the flow of applications in specific view.
     */
    public CFViewCtrl() {
        __initBo();
    }

    private void __initBo() {
        for (CCField field : getCCFields(this)) {
            if (instanceOf(CCHibernateBo.class, field.getType()) && isNull(field.getValue())) {
                field.setValue(newObject(field.getType()));
            }
        }
    }
//</editor-fold>

    /**
     * <b>Line Number: 95</b>
     * <ol>
     * <li>Returns the runtime class of this Object.</li>
     * </ol>
     *
     * @return The Class object that represents the runtime class of this object.
     */
    protected Class _getClass() {
        return getClass();
    }

    /**
     * <b>Line Number: 107</b>
     *
     * @return The Class object that represents the runtime class of this object.
     */
    protected abstract Class _getCustomToDefaultClass();

    /**
     * <b>Line Number: 114</b>
     *
     * @return The Class object that represents the runtime class of this object.
     */
    protected abstract Class _getDefaultToCustomClass();

    /**
     * <b>Line Number: 121</b>
     * <ol>
     * <li>Returns the Class representing the superclass of the entity (class, interface, primitive
     * type or void) represented by this Class.</li>
     * </ol>
     *
     * @return the superclass of the class represented by this object.
     */
    protected Class _getSuperclass() {
        return getClass().getSuperclass();
    }

    /**
     * <b>Line Number: 134</b>
     *
     * @return The Entity class that will be in management.
     */
    protected abstract Class _getEntity();

    /**
     * <b>Line Number: 141</b>
     * <ol>
     * <li>Returns true if has entity class that will be in management.</li>
     * </ol>
     *
     * @return true if has entity class that will be in management.
     */
    protected boolean _hasEntity() {
        return isNotNull(_getEntity());
    }

    /**
     * <b>Line Number: 153</b>
     * <ol>
     * <li>Returns the simple name of the underlying class as given in the source code.</li>
     * </ol>
     *
     * @return the simple name of the underlying class.
     */
    protected String _getEntityLabel() {
        return getLabel(_getEntity());
    }

    /**
     * <b>Line Number: 165</b>
     *
     * @return BaseFunction: LIST_FUNCTION or FORM_FUNCTION.
     */
    protected abstract BaseFunction _getBaseFunction();

    /**
     * <b>Line Number: 172</b>
     * <ol>
     * <li>Returns ShowMode: PANEL_MODE (Default of LIST_FUNCTION), TAB_MODE (Default of
     * FORM_FUNCTION), or DIALOG_MODE.</li>
     * </ol>
     *
     * @return ShowMode: PANEL_MODE (Default of LIST_FUNCTION), TAB_MODE (Default of FORM_FUNCTION),
     * or DIALOG_MODE.
     */
    protected ShowMode _getShowMode() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            return ShowMode.PANEL_MODE;
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            return ShowMode.TAB_MODE;
        } else {
            return ShowMode.DIALOG_MODE;
        }
    }

    /**
     * <b>Line Number: 192</b>
     * <ol>
     * <li>Sets the parameter.</li>
     * </ol>
     *
     * @param parameter the parameter.
     * @return CFViewCtrl.
     */
    public CFViewCtrl with(HashMap<String, Object> parameter) {
        this.parameter = parameter;
        return this;
    }

    /**
     * <b>Line Number: 206</b>
     * <ol>
     * <li>Sets the caller controller.</li>
     * <li>[listFunction]Re-sets parameter.</li>
     * </ol>
     *
     * @param callerCtrl the caller controller.
     * @return CFViewCtrl.
     */
    public CFViewCtrl with(CFViewCtrl callerCtrl) {
        this.callerCtrl = callerCtrl;
        //parent-childs-screen
        if (BaseFunction.LIST_FUNCTION.equals(callerCtrl._getBaseFunction())) {
            _setParameterParentField(this, _getParameterParentField(callerCtrl));
            _setParameterParentValue(this, _getParameterParentValue(callerCtrl));
            _setParameterParentNewEntity(this, _getParameterParentNewEntity(callerCtrl));
            _setParameterChildsValue(this, _getParameterChildsValue(callerCtrl));
            _setParameterAllChildsValue(this, _getParameterAllChildsValue(callerCtrl));
        }
        //
        return this;
    }

    /**
     * <b>Line Number: 230</b>
     * <ol>
     * <li>Sets the readonly.</li>
     * </ol>
     *
     * @param readonly the readonly.
     * @return CFViewCtrl.
     */
    public CFViewCtrl with(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    /**
     * <b>Line Number: 244</b>
     * <ol>
     * <li>Sets the readonly.</li>
     * <li>_doUpdateAccessible(): ...</li>
     * </ol>
     *
     * @param readonly the readonly.
     */
    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
        _doUpdateAccessible();
    }

    /**
     * <b>Line Number: 258</b>
     * <ol>
     * <li>Sets the object entity.</li>
     * <li>_initContainer(): ...</li>
     * <li>_initLanguage(): ...</li>
     * <li>_initPrivilege(): ...</li>
     * <li>_initObject(): ...</li>
     * <li>_initComponent(): ...</li>
     * <li>_initListener(): ...</li>
     * <li>_doShowScreen(): ...</li>
     * <li>_doUpdateComponent(): ...</li>
     * </ol>
     *
     * @param objEntity the object entity.
     * @return true if update parent is needed.
     */
    protected boolean _init(Object objEntity) {
        this.objEntity = objEntity;
        _initContainer();
        _initLanguage();
        _initPrivilege();
        _initObject();
        _initComponent();
        _initListener();
        if (ShowMode.DIALOG_MODE.equals(_getShowMode())) {
            _doUpdateComponent();
            _doShowScreen();
        } else {
            _doShowScreen();
            _doUpdateComponent();
        }
        return updateCaller;
    }

    /**
     * <b>Line Number: 293</b>
     * <ol>
     * <li>Sets the object entity.</li>
     * </ol>
     *
     * @param objEntity the object entity.
     * @return true if update parent is needed.
     */
    public boolean init(Object objEntity) {
        return _init(objEntity);
    }

    /**
     * <b>Line Number: 306</b>
     * <ol>
     * <li>Sets the object entity.</li>
     * <li>[listFunction]init(null): ...</li>
     * <li>[formFunction]init(_hasEntity() ? _newObjEntity() : null)</li>
     * </ol>
     *
     * @return true if update parent is needed.
     */
    public boolean init() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            return init(null);
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            return init(_hasEntity() ? _newObjEntity() : null);
        } else {
            throw logp(new UnsupportedOperationException(turn(Not_supported_yet)));
        }
    }

    /**
     * <b>Line Number: 326</b>
     */
    protected abstract void _initContainer();

    /**
     * <b>Line Number: 331</b>
     *
     * @param sysRef the system reference.
     * @param title the title.
     * @param viewCtrl the view controller.
     */
    public abstract void doShowTab(String sysRef, String title, CFViewCtrl viewCtrl);

    /**
     * <b>Line Number: 340</b>
     *
     * @param sysRef the system reference.
     */
    public abstract void doCloseTab(String sysRef);

    /**
     * <b>Line Number: 347</b>
     */
    protected abstract void _initLanguage();

    /**
     * <b>Line Number: 352</b>
     */
    protected abstract void _initPrivilege();

    /**
     * <b>Line Number: 357</b>
     * <ol>
     * <li>Sets the newEntity value.</li>
     * <li>Sets the updateCaller value to false.</li>
     * </ol>
     */
    protected void _initObject() {
        newEntity = isNotNull(objEntity) && isNull(getValue(objEntity, FIELD_ID));
        //parent-childs-screen
        if (newEntity && _getParameterParentNewEntity(this)) {
            newEntity = !_getParameterChildsValue(this).contains(objEntity);
        }
        //
        updateCaller = false;
    }

    /**
     * <b>Line Number: 374</b>
     * <ol>
     * <li>Returns the system reference.</li>
     * </ol>
     *
     * @param objEntity the object entity.
     * @return the system reference.
     */
    protected String _getSysRef(Object objEntity) {
        return isNull(objEntity)
                ? _getEntity().getName()
                : getSysRef(objEntity)
                //parent-childs-screen
                + (_getParameterParentNewEntity(this)
                ? ":" + _getParameterChildsValue(this).indexOf(objEntity)
                : "");
    }

    /**
     * <b>Line Number: 393</b>
     * <ol>
     * <li>Initial component.</li>
     * <li>[listFunction]_initTab(): ...</li>
     * <li>[listFunction]_initTable(): ...</li>
     * <li>[listFunction]_initNaviElements(): ...</li>
     * <li>[listFunction]_initFilterElements(): ...</li>
     * <li>[formFunction]_initEditor(): ...</li>
     * <li>_initAccessible(): ...</li>
     * <li>_doUpdateAccessible(): ...</li>
     * </ol>
     */
    protected void _initComponent() {
        _initTab();
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            _initTable();
            _initNaviElements();
            _initFilterElements();
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            _initEditor();
        }
        _initAccessible();
        _doUpdateAccessible();
    }

    /**
     * <b>Line Number: 419</b>
     */
    protected abstract void _initTab();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 425 [LIST_FUNCTION ONLY]</b>
     */
    protected abstract void _initTable();

    /**
     * <b>Line Number: 430 [LIST_FUNCTION ONLY]</b>
     */
    protected abstract void _initNaviElements();

    /**
     * <b>Line Number: 435 [LIST_FUNCTION ONLY]</b>
     */
    protected abstract void _initFilterElements();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 442 [FORM_FUNCTION ONLY]</b>
     */
    protected abstract void _initEditor();

    /**
     * <b>Line Number: 447 [FORM_FUNCTION ONLY]</b>
     */
    protected abstract void _initObjEntity();
//</editor-fold>

    /**
     * <b>Line Number: 453</b>
     */
    protected abstract void _initAccessible();

    /**
     * <b>Line Number: 458</b>
     */
    protected abstract void _doUpdateAccessible();

    /**
     * <b>Line Number: 463</b>
     */
    protected abstract void _initListener();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 469 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>_doShowEditor(false, _newObjEntity()): ...</li>
     * <li>doUpdateTable(): ...</li>
     * </ol>
     */
    protected void _doAdd() {
        if (_hasTblEntity()) {
            if (_doShowEditor(false, _newObjEntity())) {
                doUpdateTable();
            }
        }
    }

    /**
     * <b>Line Number: 484 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>Object selectedItem = _getSelectedItem()</li>
     * <li>_doShowEditor(true, selectedItem): ...</li>
     * <li>doUpdateTablePartial(selectedItem): ...</li>
     * </ol>
     */
    protected void _doView() {
        if (_isSelected()) {
            Object selectedItem = _getSelectedItem();
            if (_doShowEditor(true, selectedItem)) {
                doUpdateTablePartial(selectedItem);
            }
        }
    }

    /**
     * <b>Line Number: 501 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>Object selectedItem = _getSelectedItem()</li>
     * <li>_doShowEditor(false, selectedItem): ...</li>
     * <li>doUpdateTablePartial(selectedItem): ...</li>
     * </ol>
     */
    protected void _doEdit() {
        if (_isSelected()) {
            Object selectedItem = _getSelectedItem();
            if (_doShowEditor(false, selectedItem)) {
                doUpdateTablePartial(selectedItem);
            }
        }
    }

    /**
     * <b>Line Number: 518 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>_isSureDelete(): ...</li>
     * <li>_doDeleteEntity(): ...</li>
     * <li>_logger(_getSelectedItem(): ...</li>
     * <li>doUpdateTable(): ...</li>
     * </ol>
     */
    protected void _doDelete() {
        if (_isSelected()) {
            //parent-childs-screen
            if (_getParameterParentNewEntity(this) || _isSureDelete()) {
                if (_doDeleteEntity()) {
                    _logger(_getSelectedItem());
                    doUpdateTable();
                } else {
                    _showDeleted(false);
                }
            }
        }
    }

    /**
     * <b>Line Number: 541 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>[_hasTblEntity]_doExportMulti(): ...</li>
     * <li>[_hasEdtEntity]_doExportSingle(): ...</li>
     * </ol>
     */
    protected void _doExport() {
        if (_hasTblEntity()) {
            if (!_doExportMulti()) {
                _showExported(false);
            }
        } else if (_hasEdtEntity()) {
            if (!_doExportSingle()) {
                _showExported(false);
            }
        }
    }

    /**
     * <b>Line Number: 560 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>doUpdateTable(): ...</li>
     * </ol>
     */
    protected void _doSearch() {
        doUpdateTable();
    }

    /**
     * <b>Line Number: 570 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if view has tblEntity.
     */
    protected abstract boolean _hasTblEntity();

    /**
     * <b>Line Number: 577 [LIST_FUNCTION ONLY]</b>
     *
     * @return a newly allocated instance of the class represented by this object.
     */
    protected <T> T _newObjEntity() {
        return (T) newObject(_getEntity());
    }

    /**
     * <b>Line Number: 586 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if any row is selected.
     */
    protected abstract boolean _isSelected();

    /**
     * <b>Line Number: 593 [LIST_FUNCTION ONLY]</b>
     *
     * @return the item.
     */
    protected abstract <T> T _getSelectedItem();

    /**
     * <b>Line Number: 600 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if the object is sure to be deleted.
     */
    protected abstract boolean _isSureDelete();

    /**
     * <b>Line Number: 607 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if number of deleted object greater than zero.
     */
    protected abstract boolean _doDeleteEntity();

    /**
     * <b>Line Number: 614 [LIST_FUNCTION ONLY]</b>
     *
     * @param success the success.
     */
    protected abstract void _showDeleted(boolean success);

    /**
     * <b>Line Number: 621 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _doExportMulti();

    /**
     * <b>Line Number: 628 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _doExportSingle();

    /**
     * <b>Line Number: 635 [LIST_FUNCTION ONLY]</b>
     *
     * @param success the success.
     */
    protected abstract void _showExported(boolean success);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 644 [FORM_FUNCTION ONLY]</b>
     * <ol>
     * <li>_isValueValid(): ...</li>
     * <li>_isValueCompare(): ...</li>
     * <li>_isValueUnique(): ...</li>
     * <li>_isSureSave(): ...</li>
     * <li>_getValueFromEditor(): ...</li>
     * <li>_doSaveEntity(): ...</li>
     * <li>_logger(objEntity)(): ...</li>
     * <li>_doCloseScreen(): ...</li>
     * </ol>
     */
    protected void _doSave() {
        if (_hasEdtEntity()) {
            //parent-childs-screen
            if (_isValueValid() && _isValueCompare() && _isValueUnique()
                    && (_getParameterParentNewEntity(this) || _isSureSave())) {
                _getValueFromEditor();
                if (updateCaller = _doSaveEntity()) {
                    _logger(objEntity);
                    _doCloseScreen();
                } else {
                    _showSaved(updateCaller);
                }
            }
        }
    }

    /**
     * <b>Line Number: 673 [FORM_FUNCTION ONLY]</b>
     * <ol>
     * <li>_isSavedToClose(): ...</li>
     * <li>_doCloseScreen(): ...</li>
     * </ol>
     */
    protected void _doClose() {
        if (_isSavedToClose()) {
            _doCloseScreen();
        }
    }

    /**
     * <b>Line Number: 686 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if view has edtEntity.
     */
    protected abstract boolean _hasEdtEntity();

    /**
     * <b>Line Number: 693 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if all value of all registered component is valid.
     */
    protected abstract boolean _isValueValid();

    /**
     * <b>Line Number: 700 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if all value of all registered component is already compared.
     */
    protected abstract boolean _isValueCompare();

    /**
     * <b>Line Number: 707 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if all value of all registered component is unique.
     */
    protected abstract boolean _isValueUnique();

    /**
     * <b>Line Number: 714 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if the object is sure to be saved.
     */
    protected abstract boolean _isSureSave();

    /**
     * <b>Line Number: 721 [FORM_FUNCTION ONLY]</b>
     */
    protected abstract void _getValueFromEditor();

    /**
     * <b>Line Number: 726 [FORM_FUNCTION ONLY]</b>
     * <ol>
     * <li>coalesce(_getParameterAllChildsValue(this), new ArrayList())</li>
     * </ol>
     *
     * @return the collection of entity child.
     */
    protected List _getEntityChilds() {
        return coalesce(_getParameterAllChildsValue(this), new ArrayList());
    }

    /**
     * <b>Line Number: 738 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _doSaveEntity();

    /**
     * <b>Line Number: 745 [FORM_FUNCTION ONLY]</b>
     *
     * @param success the success.
     */
    protected abstract void _showSaved(boolean success);

    /**
     * <b>Line Number: 752 [FORM_FUNCTION ONLY]</b>
     * <ol>
     * <li>(!_isValueChanges() || _isSureDataNotSaved())</li>
     * </ol>
     *
     * @return true if the object is sure not to be saved.
     */
    protected boolean _isSavedToClose() {
        if (_hasEdtEntity()) {
            return (!_isValueChanges() || _isSureDataNotSaved());
        } else {
            return true;
        }
    }

    /**
     * <b>Line Number: 768 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if any value of all registered component has changes.
     */
    protected abstract boolean _isValueChanges();

    /**
     * <b>Line Number: 775 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if the object is sure not to be saved.
     */
    protected abstract boolean _isSureDataNotSaved();
//</editor-fold>

    /**
     * <b>Line Number: 783</b>
     * <ol>
     * <li>newEntity ? turn(New) : coalesce(getUniqueKeyValue(objEntity), readonly ? turn(View) :
     * turn(Edit)).toString()</li>
     * </ol>
     *
     * @return the tab title.
     */
    protected String _getTabTitle() {
        return newEntity ? turn(New) : coalesce(getUniqueKeyValue(objEntity), readonly ? turn(View) : turn(Edit)).toString();
    }

    /**
     * <b>Line Number: 796</b>
     */
    protected abstract void _doShowScreen();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 802</b>
     *
     * @param readonly the readonly.
     * @param objEntity the object entity.
     * @return true if update parent is needed.
     */
    protected abstract boolean _doShowEditor(boolean readonly, Object objEntity);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 813</b>
     */
    protected abstract void _doCloseScreen();
//</editor-fold>

    /**
     * <b>Line Number: 819</b>
     * <ol>
     * <li>[listFunction]doUpdateTable(): ...</li>
     * <li>[formFunction]_doUpdateEditor(): ...</li>
     * </ol>
     */
    protected void _doUpdateComponent() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            doUpdateTable();
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            _doUpdateEditor();
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 835</b>
     */
    public abstract void doUpdateTable();

    /**
     * <b>Line Number: 840</b>
     *
     * @param objEntity the object entity.
     */
    public abstract void doUpdateTablePartial(Object objEntity);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 849</b>
     */
    protected abstract void _doUpdateEditor();

    /**
     * <b>Line Number: 854</b>
     *
     * @param parentField the parent field.
     * @param childCtrl the child controller.
     * @param childContentId the child content id.
     */
    protected void _addChildScreen(String parentField, CFViewCtrl childCtrl, String childContentId) {
        _setParameterParentField(childCtrl, parentField);
        _setParameterParentValue(childCtrl, objEntity);
        _setParameterParentNewEntity(childCtrl, newEntity);
        _setParameterChildContentId(childCtrl, childContentId);
        _setParameterChildsValue(childCtrl, new ArrayList());
        List entityChilds = _getParameterAllChildsValue(this);
        if (isNull(entityChilds)) {
            _setParameterAllChildsValue(this, entityChilds = new ArrayList());
        }
        entityChilds.add(_getParameterChildsValue(childCtrl));
        _setParameterAllChildsValue(childCtrl, _getParameterAllChildsValue(this));
        childCtrl.with(parameter).with(this).with(readonly).init();
    }

    /**
     * <b>Line Number: 876</b>
     *
     * @param tabTitle
     * @param parentField
     * @param childCtrl
     */
    protected abstract void _addChildScreen2(String tabTitle, String parentField, CFViewCtrl childCtrl);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" parent-childs-screen ">
    /**
     * <b>Line Number: 887</b>
     *
     * @param viewCtrl
     * @return
     */
    protected String _getParameterParentField(CFViewCtrl viewCtrl) {
        return getStringOrNull(parameter.get(viewCtrl.toString() + parentField));
    }

    /**
     * <b>Line Number: 897</b>
     *
     * @param viewCtrl
     * @param value
     */
    protected void _setParameterParentField(CFViewCtrl viewCtrl, String value) {
        parameter.put(viewCtrl.toString() + parentField, value);
    }

    /**
     * <b>Line Number: 907</b>
     *
     * @param <T>
     * @param viewCtrl
     * @return
     */
    protected <T> T _getParameterParentValue(CFViewCtrl viewCtrl) {
        return (T) parameter.get(viewCtrl.toString() + parentValue);
    }

    /**
     * <b>Line Number: 918</b>
     *
     * @param viewCtrl
     * @param value
     */
    protected void _setParameterParentValue(CFViewCtrl viewCtrl, Object value) {
        parameter.put(viewCtrl.toString() + parentValue, value);
    }

    /**
     * <b>Line Number: 928</b>
     *
     * @param viewCtrl
     * @return
     */
    protected Boolean _getParameterParentNewEntity(CFViewCtrl viewCtrl) {
        return getBoolean(parameter.get(viewCtrl.toString() + parentNewEntity));
    }

    /**
     * <b>Line Number: 938</b>
     *
     * @param viewCtrl
     * @param value
     */
    protected void _setParameterParentNewEntity(CFViewCtrl viewCtrl, Boolean value) {
        parameter.put(viewCtrl.toString() + parentNewEntity, value);
    }

    /**
     * <b>Line Number: 948/b>
     *
     * @param viewCtrl
     * @return
     */
    protected String _getParameterChildContentId(CFViewCtrl viewCtrl) {
        return getStringOrNull(parameter.get(viewCtrl.toString() + childContentId));
    }

    /**
     * <b>Line Number: 958</b>
     *
     * @param viewCtrl
     * @param value
     */
    protected void _setParameterChildContentId(CFViewCtrl viewCtrl, String value) {
        parameter.put(viewCtrl.toString() + childContentId, value);
    }

    /**
     * <b>Line Number: 968</b>
     *
     * @param viewCtrl
     * @return
     */
    protected List _getParameterChildsValue(CFViewCtrl viewCtrl) {
        return (List) parameter.get(viewCtrl.toString() + childsValue);
    }

    /**
     * <b>Line Number: 978</b>
     *
     * @param viewCtrl
     * @param value
     */
    protected void _setParameterChildsValue(CFViewCtrl viewCtrl, List value) {
        parameter.put(viewCtrl.toString() + childsValue, value);
    }

    /**
     * <b>Line Number: 988</b>
     *
     * @param viewCtrl
     * @return
     */
    protected List _getParameterAllChildsValue(CFViewCtrl viewCtrl) {
        return (List) parameter.get(viewCtrl.toString() + allChildsValue);
    }

    /**
     * <b>Line Number: 998</b>
     *
     * @param viewCtrl
     * @param value
     */
    protected void _setParameterAllChildsValue(CFViewCtrl viewCtrl, List value) {
        parameter.put(viewCtrl.toString() + allChildsValue, value);
    }
//</editor-fold>

    /**
     * <b>Line Number: 1009</b>
     *
     * @param note the note.
     */
    protected void _logger(Object note) {
        String screen = getClass().getSimpleName().replace("Ctrl", "");
        String action = new Throwable().getStackTrace()[1].getMethodName().replaceFirst("_", "").replaceFirst("do", "");
        if (isNotNull(note)) {
            if (note instanceof List) {
                List list = (List) note;
                if (list.isEmpty()) {
                    note = "no data";
                } else if (list.size() == 1) {
                    note = list.get(0);
                } else if (list.size() > 1) {
                    note = list.size() + " records";
                }
            }
            if (!(note instanceof String)) {
                note = note.getClass().getSimpleName() + " : " + getAssociativeArray(note, null);
            }
            if (note instanceof String) {
                note = maxLength((String) note, 255);
            }
        }
        if (isNull(UtilityModule.INSTANCE.getCCHibernate())) {
            logp(screen + " :: " + action + " :: " + coalesce(note, "~"));
        } else {
            loggerBo.logger(screen, action, coalesce(note, "~").toString());
        }
    }
}