package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import cococare.framework.model.obj.note.NoteShortcut;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCLink;
import java.awt.Color;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlShortcutListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return NoteShortcut.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setVisibleField(false, "path");
        tblEntity.addField(2, new CCCustomField() {
            @Override
            public Object getCustomView(Object object) {
                return new CCLink(((NoteShortcut) object).getPath()).
                        addActionListener(tblEntity.getStopCellEditingListener()).
                        toShortcut();
            }

            @Override
            public Integer getColumnWidth() {
                return 200;
            }
        });
        tblEntity.setColumnForeground(2, Color.BLUE);
        tblEntity.setEditableColumn(true, 2);
        tblEntity.getTable().setRowHeight(29);
    }
}