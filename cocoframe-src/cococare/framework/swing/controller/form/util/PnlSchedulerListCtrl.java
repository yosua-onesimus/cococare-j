package cococare.framework.swing.controller.form.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCCustomField;
import cococare.framework.model.obj.util.UtilScheduler;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCLink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlSchedulerListCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return UtilScheduler.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.TAB_MODE;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setVisibleField(false, "code");
        tblEntity.addField(0, new CCCustomField() {
            @Override
            public String getLabel() {
                return "Code";
            }

            @Override
            public Object getCustomView(Object object) {
                final UtilScheduler scheduler = (UtilScheduler) object;
                CCLink link = new CCLink(scheduler.getCode());
                addListener(link, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        tblEntity.getStopCellEditingListener().actionPerformed(actionEvent);
                        _doShowEditor(readonly, scheduler);
                    }
                });
                return link;
            }

            @Override
            public Integer getColumnWidth() {
                return 100;
            }
        });
        tblEntity.setEditableColumn(true, 0);
    }

    @Override
    protected String _getTabTitle() {
        return _getEntityLabel();
    }
}