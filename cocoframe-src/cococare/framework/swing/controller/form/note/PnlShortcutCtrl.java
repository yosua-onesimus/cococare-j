package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCMessage.IS_USED;
import static cococare.common.CCMessage.showInformation;
import cococare.framework.model.obj.note.NoteShortcut;
import cococare.framework.model.obj.note.NoteTracker;
import cococare.framework.swing.CFSwingCtrl;
import java.util.List;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlShortcutCtrl extends CFSwingCtrl {

    private JTextField txtCode;

    @Override
    protected Class _getEntity() {
        return NoteShortcut.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        if (newEntity && getBoolean(parameter.get("tracker_newEntity"))) {
            newEntity = !((List) parameter.get("shortcuts")).contains(objEntity);
        }
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        if (isNotNull(parameter.get("tracker"))) {
            ((NoteShortcut) objEntity).setTracker((NoteTracker) parameter.get("tracker"));
        }
    }

    @Override
    protected String _getSysRef(Object objEntity) {
        if (getBoolean(parameter.get("tracker_newEntity"))) {
            return objEntity.toString();
        } else {
            return super._getSysRef(objEntity);
        }
    }

    @Override
    protected boolean _isValueUnique() {
        boolean valueUnique = super._isValueUnique();
        if (valueUnique && getBoolean(parameter.get("tracker_newEntity"))) {
            for (NoteShortcut shortcut : ((List<NoteShortcut>) parameter.get("shortcuts"))) {
                if (!shortcut.equals(objEntity) && shortcut.getCode().equals(txtCode.getText())) {
                    showInformation(IS_USED("code"));
                    return false;
                }
            }
        }
        return valueUnique;
    }

    @Override
    protected boolean _doSaveEntity() {
        if (getBoolean(parameter.get("tracker_newEntity"))) {
            List list = (List) parameter.get("shortcuts");
            return list.contains(objEntity) ? true : list.add(objEntity);
        } else {
            return super._doSaveEntity();
        }
    }
}