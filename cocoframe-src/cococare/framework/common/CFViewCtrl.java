package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.*;
import cococare.common.CCField;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCFormat.maxLength;
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
 * CFViewCtrl is an abstract class which functions as an view controller, in
 * charge of controlling the flow of applications in specific view.
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
    protected List<String> childsValueKeys = new ArrayList();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CFViewCtrl ">
    /**
     * CFViewCtrl is an abstract class which functions as an view controller, in
     * charge of controlling the flow of applications in specific view.
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
     * <b>Line Number: 96</b>
     *
     * @return Entity class that will be in management.
     */
    protected abstract Class _getEntity();

    /**
     * <b>Line Number: 103</b>
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
     * <b>Line Number: 115</b>
     *
     * @return BaseFunction: LIST_FUNCTION or FORM_FUNCTION.
     */
    protected abstract BaseFunction _getBaseFunction();

    /**
     * <b>Line Number: 122</b>
     * <ol>
     * <li>Returns ShowMode: PANEL_MODE (Default of LIST_FUNCTION), TAB_MODE
     * (Default of FORM_FUNCTION), or DIALOG_MODE.</li>
     * </ol>
     *
     * @return ShowMode: PANEL_MODE (Default of LIST_FUNCTION), TAB_MODE
     * (Default of FORM_FUNCTION), or DIALOG_MODE.
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
     * <b>Line Number: 142</b>
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
     * <b>Line Number: 156</b>
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
            parameter.put(toString() + parentField, parameter.get(callerCtrl.toString() + parentField));
            parameter.put(toString() + parentValue, parameter.get(callerCtrl.toString() + parentValue));
            parameter.put(toString() + parentNewEntity, parameter.get(callerCtrl.toString() + parentNewEntity));
            parameter.put(toString() + childsValue, parameter.get(callerCtrl.toString() + childsValue));
        }
        //
        return this;
    }

    /**
     * <b>Line Number: 179</b>
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
     * <b>Line Number: 193</b>
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
     * <b>Line Number: 207</b>
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
     * <b>Line Number: 242</b>
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
     * <b>Line Number: 255</b>
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
     * <b>Line Number: 275</b>
     */
    protected abstract void _initContainer();

    /**
     * <b>Line Number: 280</b>
     *
     * @param sysRef the system reference.
     * @param title the title.
     * @param viewCtrl the view controller.
     */
    public abstract void doShowTab(String sysRef, String title, CFViewCtrl viewCtrl);

    /**
     * <b>Line Number: 289</b>
     *
     * @param sysRef the system reference.
     */
    public abstract void doCloseTab(String sysRef);

    /**
     * <b>Line Number: 296</b>
     */
    protected abstract void _initLanguage();

    /**
     * <b>Line Number: 301</b>
     */
    protected abstract void _initPrivilege();

    /**
     * <b>Line Number: 306</b>
     * <ol>
     * <li>Sets the newEntity value.</li>
     * <li>Sets the updateCaller value to false.</li>
     * </ol>
     */
    protected void _initObject() {
        newEntity = isNotNull(objEntity) && isNull(getValue(objEntity, FIELD_ID));
        //parent-childs-screen
        if (newEntity && getBoolean(parameter.get(toString() + parentNewEntity))) {
            newEntity = !((List) parameter.get(toString() + childsValue)).contains(objEntity);
        }
        //
        updateCaller = false;
    }

    /**
     * <b>Line Number: 323</b>
     * <ol>
     * <li>Returns the system reference.</li>
     * </ol>
     *
     * @param objEntity the object entity.
     * @return the system reference.
     */
    protected String _getSysRef(Object objEntity) {
        return getSysRef(objEntity)
                //parent-childs-screen
                + (getBoolean(parameter.get(toString() + parentNewEntity))
                ? ":" + ((List) parameter.get(toString() + childsValue)).indexOf(objEntity)
                : "");
    }

    /**
     * <b>Line Number: 340</b>
     * <ol>
     * <li>Initial component.</li>
     * <li>[listFunction]_initTable(): ...</li>
     * <li>[listFunction]_initNaviElements(): ...</li>
     * <li>[listFunction]_initFilterElements(): ...</li>
     * <li>[formFunction]_initEditor(): ...</li>
     * <li>_initAccessible(): ...</li>
     * <li>_doUpdateAccessible(): ...</li>
     * </ol>
     */
    protected void _initComponent() {
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

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 365 [LIST_FUNCTION ONLY]</b>
     */
    protected abstract void _initTable();

    /**
     * <b>Line Number: 370 [LIST_FUNCTION ONLY]</b>
     */
    protected abstract void _initNaviElements();

    /**
     * <b>Line Number: 375 [LIST_FUNCTION ONLY]</b>
     */
    protected abstract void _initFilterElements();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 382 [FORM_FUNCTION ONLY]</b>
     */
    protected abstract void _initEditor();

    /**
     * <b>Line Number: 387 [FORM_FUNCTION ONLY]</b>
     */
    protected abstract void _initObjEntity();
//</editor-fold>

    /**
     * <b>Line Number: 393</b>
     */
    protected abstract void _initAccessible();

    /**
     * <b>Line Number: 398</b>
     */
    protected abstract void _doUpdateAccessible();

    /**
     * <b>Line Number: 403</b>
     */
    protected abstract void _initListener();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 409 [LIST_FUNCTION ONLY]</b>
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
     * <b>Line Number: 424 [LIST_FUNCTION ONLY]</b>
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
     * <b>Line Number: 441 [LIST_FUNCTION ONLY]</b>
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
     * <b>Line Number: 458 [LIST_FUNCTION ONLY]</b>
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
            if (getBoolean(parameter.get(toString() + parentNewEntity)) || _isSureDelete()) {
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
     * <b>Line Number: 481 [LIST_FUNCTION ONLY]</b>
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
     * <b>Line Number: 500 [LIST_FUNCTION ONLY]</b>
     * <ol>
     * <li>doUpdateTable(): ...</li>
     * </ol>
     */
    protected void _doSearch() {
        doUpdateTable();
    }

    /**
     * <b>Line Number: 510 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if view has tblEntity.
     */
    protected abstract boolean _hasTblEntity();

    /**
     * <b>Line Number: 517 [LIST_FUNCTION ONLY]</b>
     *
     * @return a newly allocated instance of the class represented by this
     * object.
     */
    protected <T> T _newObjEntity() {
        return (T) newObject(_getEntity());
    }

    /**
     * <b>Line Number: 527 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if any row is selected.
     */
    protected abstract boolean _isSelected();

    /**
     * <b>Line Number: 534 [LIST_FUNCTION ONLY]</b>
     *
     * @return the item.
     */
    protected abstract <T> T _getSelectedItem();

    /**
     * <b>Line Number: 541 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if the object is sure to be deleted.
     */
    protected abstract boolean _isSureDelete();

    /**
     * <b>Line Number: 548 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if number of deleted object greater than zero.
     */
    protected abstract boolean _doDeleteEntity();

    /**
     * <b>Line Number: 555 [LIST_FUNCTION ONLY]</b>
     *
     * @param success the success.
     */
    protected abstract void _showDeleted(boolean success);

    /**
     * <b>Line Number: 562 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _doExportMulti();

    /**
     * <b>Line Number: 569 [LIST_FUNCTION ONLY]</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _doExportSingle();

    /**
     * <b>Line Number: 576 [LIST_FUNCTION ONLY]</b>
     *
     * @param success the success.
     */
    protected abstract void _showExported(boolean success);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 585 [FORM_FUNCTION ONLY]</b>
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
                    && (getBoolean(parameter.get(toString() + parentNewEntity)) || _isSureSave())) {
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
     * <b>Line Number: 614 [FORM_FUNCTION ONLY]</b>
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
     * <b>Line Number: 627 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if view has edtEntity.
     */
    protected abstract boolean _hasEdtEntity();

    /**
     * <b>Line Number: 634 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if all value of all registered component is valid.
     */
    protected abstract boolean _isValueValid();

    /**
     * <b>Line Number: 641 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if all value of all registered component is already
     * compared.
     */
    protected abstract boolean _isValueCompare();

    /**
     * <b>Line Number: 649 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if all value of all registered component is unique.
     */
    protected abstract boolean _isValueUnique();

    /**
     * <b>Line Number: 656 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if the object is sure to be saved.
     */
    protected abstract boolean _isSureSave();

    /**
     * <b>Line Number: 663 [FORM_FUNCTION ONLY]</b>
     */
    protected abstract void _getValueFromEditor();

    /**
     * <b>Line Number: 668 [FORM_FUNCTION ONLY]</b>
     * <ol>
     * <li>list.addAll((List) parameter.get(childsValueKey))</li>
     * </ol>
     *
     * @return the collection of entity child.
     */
    protected List _getEntityChilds() {
        List list = new ArrayList();
        for (String childsValueKey : childsValueKeys) {
            list.addAll((List) parameter.get(childsValueKey));
        }
        return list;
    }

    /**
     * <b>Line Number: 684 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if success; false if fail.
     */
    protected abstract boolean _doSaveEntity();

    /**
     * <b>Line Number: 691 [FORM_FUNCTION ONLY]</b>
     *
     * @param success the success.
     */
    protected abstract void _showSaved(boolean success);

    /**
     * <b>Line Number: 698 [FORM_FUNCTION ONLY]</b>
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
     * <b>Line Number: 714 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if any value of all registered component has changes.
     */
    protected abstract boolean _isValueChanges();

    /**
     * <b>Line Number: 721 [FORM_FUNCTION ONLY]</b>
     *
     * @return true if the object is sure not to be saved.
     */
    protected abstract boolean _isSureDataNotSaved();
//</editor-fold>

    /**
     * <b>Line Number: 729</b>
     * <ol>
     * <li>newEntity ? turn(New) : coalesce(getUniqueKeyValue(objEntity),
     * readonly ? turn(View) : turn(Edit)).toString()</li>
     * </ol>
     *
     * @return the tab title.
     */
    protected String _getTabTitle() {
        return newEntity ? turn(New) : coalesce(getUniqueKeyValue(objEntity), readonly ? turn(View) : turn(Edit)).toString();
    }

    /**
     * <b>Line Number: 742</b>
     */
    protected abstract void _doShowScreen();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    /**
     * <b>Line Number: 748</b>
     *
     * @param readonly the readonly.
     * @param objEntity the object entity.
     * @return true if update parent is needed.
     */
    protected abstract boolean _doShowEditor(boolean readonly, Object objEntity);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 759</b>
     */
    protected abstract void _doCloseScreen();
//</editor-fold>

    /**
     * <b>Line Number: 765</b>
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
     * <b>Line Number: 781</b>
     */
    public abstract void doUpdateTable();

    /**
     * <b>Line Number: 786</b>
     *
     * @param objEntity the object entity.
     */
    public abstract void doUpdateTablePartial(Object objEntity);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    /**
     * <b>Line Number: 795</b>
     */
    protected abstract void _doUpdateEditor();

    /**
     * <b>Line Number: 800</b>
     *
     * @param parentField the parent field.
     * @param childCtrl the child controller.
     * @param childContentId the child content id.
     */
    protected void _addChildScreen(String parentField, CFViewCtrl childCtrl, String childContentId) {
        parameter.put(childCtrl.toString() + this.parentField, parentField);
        parameter.put(childCtrl.toString() + this.parentValue, objEntity);
        parameter.put(childCtrl.toString() + this.parentNewEntity, newEntity);
        parameter.put(childCtrl.toString() + this.childContentId, childContentId);
        parameter.put(childCtrl.toString() + this.childsValue, new ArrayList());
        childsValueKeys.add(childCtrl.toString() + this.childsValue);
        childCtrl.with(parameter).with(this).with(readonly).init();
    }
//</editor-fold>

    /**
     * <b>Line Number: 818</b>
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