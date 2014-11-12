package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import static cococare.common.CCLogic.isNotNull;
import static cococare.database.CCHibernate.readTransientByteAValue;
import static cococare.datafile.CCFile.*;
import cococare.framework.model.obj.note.NoteEnum.ReferenceType;
import cococare.framework.model.obj.note.NoteReference;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCLink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReferenceListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return NoteReference.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        int column = tblEntity.getColumnCount();
        tblEntity.addField(column, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Value";
            }

            @Override
            public Object getCustomView(Object object) {
                final NoteReference reference = (NoteReference) object;
                CCLink link = new CCLink(reference.getValue());
                if (ReferenceType.ATTACHMENT.equals(reference.getReferenceType())) {
                    addListener(link, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            tblEntity.getStopCellEditingListener().actionPerformed(actionEvent);
                            readTransientByteAValue(reference);
                            File file = showSaveDialog();
                            if (isNotNull(file) && writeByteA(reference.getByteA(), file)) {
                                open(file);
                            }
                        }
                    });
                } else if (ReferenceType.LINK.equals(reference.getReferenceType())) {
                    link.toBookmark();
                } else if (ReferenceType.SHORTCUT.equals(reference.getReferenceType())) {
                    link.toShortcut();
                }
                return link;
            }
        });
        tblEntity.setEditableColumn(true, column);
    }
}