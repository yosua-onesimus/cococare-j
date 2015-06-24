package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getLabel;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfFilter.isProcess;
import cococare.framework.model.obj.wf.WfProcess;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.component.CCComboBox;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlActivityListCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private CCComboBox cmbProcess;
//</editor-fold>

    @Override
    protected Class _getClass() {
        return PnlActivityListCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        return WfActivity.class;
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
        cmbProcess.initList(null, WfProcess.class, "name");
        cmbProcess.autoList();
        parameter.put(toString() + "cmbProcess", cmbProcess);
        super._initTable();
        tblEntity.setHqlFilters(new isProcess() {
            @Override
            public Object getFieldValue() {
                return cmbProcess.getSelectedObject();
            }
        });
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbProcess, alSearch);
    }

    @Override
    protected String _getTabTitle() {
        return getLabel(_getEntity());
    }
}