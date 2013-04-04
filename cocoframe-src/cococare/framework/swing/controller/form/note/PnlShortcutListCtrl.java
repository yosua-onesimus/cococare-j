package cococare.framework.swing.controller.form.note;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.database.CCHibernateFilter;
import cococare.framework.model.obj.note.NoteShortcut;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCLink;
import java.awt.Color;
import java.util.List;
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
    protected String _getSysRef(Object objEntity) {
        if (getBoolean(parameter.get("tracker_newEntity"))) {
            return objEntity.toString();
        } else {
            return super._getSysRef(objEntity);
        }
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setVisibleField(false, "path");
        tblEntity.addField(2, new CCCustomField() {

            @Override
            public String getLabel() {
                return "Path";
            }

            @Override
            public Object getCustomView(Object object) {
                return new CCLink(((NoteShortcut) object).getPath()).toShortcut();
            }
        });
        tblEntity.setColumnForeground(2, Color.BLUE);
        tblEntity.setColumnWidth(2, 200);
        tblEntity.setEditableColumn(true, 2);
        tblEntity.getTable().setRowHeight(29);
        if (isNotNull(parameter.get("tracker"))) {
            tblEntity.setHqlFilters(new CCHibernateFilter() {

                @Override
                public String getFieldName() {
                    return "tracker";
                }

                @Override
                public Object getFieldValue() {
                    return parameter.get("tracker");
                }
            });
        }
    }

    @Override
    protected void _doShowScreen() {
        if (isNull(parameter.get("tracker"))) {
            super._doShowScreen();
        }
    }

    @Override
    protected boolean _doDeleteEntity() {
        if (getBoolean(parameter.get("tracker_newEntity"))) {
            return ((List) parameter.get("shortcuts")).remove(_getSelectedItem());
        } else {
            return super._doDeleteEntity();
        }
    }

    @Override
    public void doUpdateTable() {
        if (getBoolean(parameter.get("tracker_newEntity"))) {
            tblEntity.setList((List) parameter.get("shortcuts"));
        } else {
            super.doUpdateTable();
        }
    }
}