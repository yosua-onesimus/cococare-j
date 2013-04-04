package cococare.framework.common;

// <editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.*;
import cococare.common.CCField;
import static cococare.common.CCFormat.maxLength;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.logp;
import cococare.common.CCTrackable;
import static cococare.database.CCEntityConfig.FIELD_ID;
import cococare.database.CCHibernateBo;
import cococare.framework.model.bo.util.UtilLoggerBo;
import cococare.framework.model.mdl.util.UtilityModule;
import java.util.HashMap;
import java.util.List;
// </editor-fold>

/**
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
    protected UtilLoggerBo loggerBo;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" CFViewCtrl ">
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

    protected abstract Class _getEntity();

    protected boolean _hasEntity() {
        return isNotNull(_getEntity());
    }

    protected abstract BaseFunction _getBaseFunction();

    protected ShowMode _getShowMode() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            return ShowMode.PANEL_MODE;
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            return ShowMode.TAB_MODE;
        } else {
            return ShowMode.DIALOG_MODE;
        }
    }

    public CFViewCtrl with(HashMap<String, Object> parameter) {
        this.parameter = parameter;
        return this;
    }

    public CFViewCtrl with(CFViewCtrl callerCtrl) {
        this.callerCtrl = callerCtrl;
        return this;
    }

    public CFViewCtrl with(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
        _doUpdateAccessible();
    }

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

    public boolean init(Object objEntity) {
        return _init(objEntity);
    }

    public boolean init() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            return init(null);
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            return init(isNull(_getEntity()) ? null : newObject(_getEntity()));
        } else {
            return false;
        }
    }

    protected abstract void _initContainer();

    public abstract void doShowTab(String sysRef, String title, CFViewCtrl viewCtrl);

    public abstract void doCloseTab(String sysRef);

    protected abstract void _initLanguage();

    protected abstract void _initPrivilege();

    protected void _initObject() {
        newEntity = isNotNull(objEntity) && isNull(getValue(objEntity, FIELD_ID));
        updateCaller = false;
    }

    protected String _getSysRef(Object objEntity) {
        return getSysRef(objEntity);
    }

    protected void _initComponent() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            _initTable();
            _initNaviElements();
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            _initEditor();
            _initAccessible();
            _doUpdateAccessible();
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    protected abstract void _initTable();

    protected abstract void _initNaviElements();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    protected abstract void _initEditor();

    protected abstract void _initObjEntity();

    protected abstract void _initAccessible();

    protected abstract void _doUpdateAccessible();
//</editor-fold>

    protected abstract void _initListener();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    protected void _doAdd() {
        if (isNotNull(_hasTblEntity())) {
            if (_doShowEditor(false, _newObjEntity())) {
                doUpdateTable();
            }
        }
    }

    protected void _doView() {
        if (_isSelected()) {
            Object selectedItem = _getSelectedItem();
            if (_doShowEditor(true, selectedItem)) {
                doUpdateTablePartial(selectedItem);
            }
        }
    }

    protected void _doEdit() {
        if (_isSelected()) {
            Object selectedItem = _getSelectedItem();
            if (_doShowEditor(false, selectedItem)) {
                doUpdateTablePartial(selectedItem);
            }
        }
    }

    protected void _doDelete() {
        if (_isSelected()) {
            if (_isSureDelete()) {
                boolean success = _doDeleteEntity();
                if (success) {
                    _logger(_getSelectedItem());
                    doUpdateTable();
                } else {
                    _showDeleted(success);
                }
            }
        }
    }

    protected void _doSearch() {
        doUpdateTable();
    }

    protected abstract boolean _hasTblEntity();

    protected Object _newObjEntity() {
        return newObject(_getEntity());
    }

    protected abstract boolean _isSelected();

    protected abstract Object _getSelectedItem();

    protected abstract boolean _isSureDelete();

    protected abstract boolean _doDeleteEntity();

    protected abstract void _showDeleted(boolean success);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    protected void _doSave() {
        if (_hasEdtEntity()) {
            if (_isValueValid() && _isValueCompare() && _isValueUnique() && _isSureSave()) {
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

    protected void _doClose() {
        if (_isSavedToClose()) {
            _doCloseScreen();
        }
    }

    protected abstract boolean _hasEdtEntity();

    protected abstract boolean _isValueValid();

    protected abstract boolean _isValueCompare();

    protected abstract boolean _isValueUnique();

    protected abstract boolean _isSureSave();

    protected abstract void _getValueFromEditor();

    protected abstract boolean _doSaveEntity();

    protected abstract void _showSaved(boolean success);

    protected boolean _isSavedToClose() {
        if (_hasEdtEntity()) {
            return (!_isValueChanges() || _isSureDataNotSaved());
        } else {
            return true;
        }
    }

    protected abstract boolean _isValueChanges();

    protected abstract boolean _isSureDataNotSaved();
//</editor-fold>

    protected abstract void _doShowScreen();

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    protected abstract boolean _doShowEditor(boolean readonly, Object objEntity);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    protected abstract void _doCloseScreen();
//</editor-fold>

    protected void _doUpdateComponent() {
        if (BaseFunction.LIST_FUNCTION.equals(_getBaseFunction())) {
            doUpdateTable();
        } else if (BaseFunction.FORM_FUNCTION.equals(_getBaseFunction())) {
            _doUpdateEditor();
        }
    }

//<editor-fold defaultstate="collapsed" desc=" LIST_FUNCTION ">
    public abstract void doUpdateTable();

    public abstract void doUpdateTablePartial(Object objEntity);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" FORM_FUNCTION ">
    protected abstract void _doUpdateEditor();
//</editor-fold>

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
            logp(screen + " :: " + action + " :: " + coalesce(note, "~").toString());
        } else {
            loggerBo.logger(screen, action, coalesce(note, "~").toString());
        }
    }
}