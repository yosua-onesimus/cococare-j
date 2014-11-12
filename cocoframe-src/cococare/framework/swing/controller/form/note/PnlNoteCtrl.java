package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.model.bo.note.NoteNoteBo;
import cococare.framework.model.obj.note.NoteNote;
import cococare.framework.model.obj.note.NoteTag;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCOptionBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlNoteCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private NoteNoteBo noteBo;
    private CCOptionBox optTag;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return NoteNote.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        noteBo.load((NoteNote) objEntity);
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen("note", new PnlNoteReferenceListCtrl(), "pnlNoteReference");
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        optTag.initList(false, NoteTag.class, "name");
        optTag.setColumnCount(1);
        optTag.autoList();
    }

    @Override
    protected boolean _doSaveEntity() {
        return noteBo.saveOrUpdate(_getEntityChilds());
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        optTag.setSelectedItem(true, noteBo.getSelectedTags().toArray());
    }

    @Override
    protected void _getValueFromEditor() {
        super._getValueFromEditor();
        noteBo.setSelectedTags(optTag.getSelectedItems());
    }
}