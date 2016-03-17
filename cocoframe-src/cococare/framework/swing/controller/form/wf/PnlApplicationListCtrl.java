package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.WF_DOCUMENT_CLASS;
import static cococare.database.CCLoginInfo.INSTANCE_getUserLogin;
import cococare.framework.model.bo.wf.WfWorkflowBo;
import cococare.framework.model.obj.util.UtilFilter.isIdInIds;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.swing.CFSwingCtrl;
import cococare.framework.swing.controller.custom.wf.NumberFieldShowEditor;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.newCCTable;
import cococare.swing.CCTable;
import cococare.swing.component.CCComboBox;
import java.util.List;
import javax.swing.JPanel;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlApplicationListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfWorkflowBo workflowBo;
    private List ids;
    private List poolIds;
    private UtilUser user = INSTANCE_getUserLogin();
    private CCComboBox cmbActivity;
    private JPanel pnlPool;
    private CCTable tblPool;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WF_DOCUMENT_CLASS;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        parameter.put(toString() + "cmbActivity", cmbActivity);
        cmbActivity.initList(null, WfActivity.class, "name");
        cmbActivity.setList(workflowBo.getActivitiesBy(user.getUserGroup(), user));
        //
        super._initTable();
        tblEntity.setVisibleField(false, "number");
        tblEntity.addField(0, new NumberFieldShowEditor(this, tblEntity, workflowBo, cmbActivity));
        tblEntity.setEditableColumn(true, 0);
        tblEntity.setHqlFilters(new isIdInIds() {
            @Override
            public Object getFieldValue() {
                return ids.isEmpty() ? 0L : ids;
            }
        });
        tblPool = newCCTable(getContainer(), "tblPool", _getEntity());
        tblPool.setVisibleField(false, "number");
        tblPool.addField(0, new NumberFieldShowEditor(this, tblPool, workflowBo, cmbActivity));
        tblPool.setEditableColumn(true, 0);
        tblPool.setHqlFilters(new isIdInIds() {
            @Override
            public Object getFieldValue() {
                return poolIds.isEmpty() ? 0L : poolIds;
            }
        });
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbActivity, alSearch);
    }

    @Override
    public void doUpdateTable() {
        ids = workflowBo.getDocumentIdsBy((WfActivity) cmbActivity.getSelectedObject(), user.getUserGroup(), user);
        poolIds = workflowBo.getDocumentIdsBy((WfActivity) cmbActivity.getSelectedObject(), user.getUserGroup(), null);
        super.doUpdateTable();
        tblPool.search();
        pnlPool.setVisible(!tblPool.getList().isEmpty());
    }
}