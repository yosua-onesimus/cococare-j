package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.database.CCLoginInfo.INSTANCE_getUserLogin;
import cococare.framework.model.bo.wf.WfWorkflowBo;
import cococare.framework.model.obj.util.UtilFilter.isIdInIds;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfDocumentSample;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCComboBox;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfWorkflowBo workflowBo;
    private List ids;
    private UtilUser user = INSTANCE_getUserLogin();
    private CCComboBox cmbActivity;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfDocumentSample.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        swingView.getTabEntity().setTitleAt(0, _getEntityLabel());
        cmbActivity.initList(null, WfActivity.class, "name");
        cmbActivity.setList(workflowBo.getActivitiesBy(user.getUserGroup()));
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setHqlFilters(new isIdInIds() {
            @Override
            public Object getFieldValue() {
                return ids.isEmpty() ? 0L : ids;
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
        super.doUpdateTable();
    }
}