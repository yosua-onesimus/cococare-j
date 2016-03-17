package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig.Accessible;
import static cococare.framework.model.obj.util.UtilFilter.isUserGroupNotRoot;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfProcess;
import cococare.framework.swing.controller.form.PnlDefaultWithChildCtrl;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.CCTable;
import cococare.swing.component.CCBandBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlActivityCtrl extends PnlDefaultWithChildCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JTextField txtDayLimit;
    private CCBandBox bndUserRole;
    private JTextField txtWeight;
    private JComboBox cmbPointType;
//</editor-fold>

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen2("Tab", "activity", new PnlActivityTabListCtrl());
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        bndUserRole.getTable().setHqlFilters(isUserGroupNotRoot);
    }

    @Override
    protected void _initObjEntity() {
        super._initObjEntity();
        WfActivity activity = (WfActivity) objEntity;
        activity.setProcess((WfProcess) parameter.get(callerCtrl.toString() + "selectedObject"));
        if (((CCTable) parameter.get(callerCtrl.toString() + "tblEntity")).getRowCount() == 0) {
            activity.setActivityPointType(ActivityPointType.START_POINT);
        }
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbPointType, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doPointType();
            }
        });
    }

    private void _doPointType() {
        boolean isFinalPoint = ActivityPointType.FINAL_POINT.equals(ActivityPointType.values()[cmbPointType.getSelectedIndex()]);
        edtEntity.setAccessible(txtDayLimit, isFinalPoint ? Accessible.READONLY_SET_NULL : Accessible.MANDATORY);
        edtEntity.setAccessible(bndUserRole, isFinalPoint ? Accessible.READONLY_SET_NULL : Accessible.MANDATORY);
        edtEntity.setAccessible(txtWeight, isFinalPoint ? Accessible.READONLY_SET_NULL : Accessible.MANDATORY);
    }

    @Override
    protected boolean _doSaveEntity() {
        parameter.put(callerCtrl.toString() + "crudObject", objEntity);
        return super._doSaveEntity();
    }
}