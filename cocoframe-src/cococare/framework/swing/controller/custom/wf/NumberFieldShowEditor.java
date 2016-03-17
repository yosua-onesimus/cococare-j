package cococare.framework.swing.controller.custom.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.getMethod;
import static cococare.common.CCClass.invoke;
import cococare.common.CCCustomField;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCFormat.getString;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCLogic.isSureClaim;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.bo.wf.WfWorkflowBo;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfDocument;
import cococare.framework.model.obj.wf.WfEnum.DocumentStatus;
import static cococare.swing.CCSwing.addListener;
import cococare.swing.CCTable;
import cococare.swing.component.CCComboBox;
import cococare.swing.component.CCLink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//</editor-fold>

public class NumberFieldShowEditor extends CCCustomField {

//<editor-fold defaultstate="collapsed" desc=" private ">
    private CFViewCtrl viewCtrl;
    private CCTable tblEntity;
    private WfWorkflowBo workflowBo;
    private CCComboBox cmbActivity;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" NumberFieldShowEditor ">
    public NumberFieldShowEditor(CFViewCtrl viewCtrl, CCTable tblEntity, WfWorkflowBo workflowBo, CCComboBox cmbActivity) {
        this.viewCtrl = viewCtrl;
        this.tblEntity = tblEntity;
        this.workflowBo = workflowBo;
        this.cmbActivity = cmbActivity;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter ">
    @Override
    public String getLabel() {
        return "Number";
    }

    @Override
    public Object getCustomView(final Object object) {
        CCLink link = new CCLink(getString(CCClass.getValue(object, "number")));
        addListener(link, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tblEntity.getStopCellEditingListener().actionPerformed(actionEvent);
                WfDocument document = (WfDocument) object;
                if (DocumentStatus.ACTIVE.equals(document.getDocumentStatus())) {
                    document.setWorkflow(workflowBo.getWorkflowBy(document, (WfActivity) cmbActivity.getSelectedObject()));
                    if (isNull(document.getWorkflow().getUser())) {
                        if (isSureClaim()) {
                            workflowBo.claim(document.getWorkflow());
                            viewCtrl.doUpdateTable();
                        } else {
                            return;
                        }
                    }
                }
                boolean readonly = getBoolean(CCClass.getValue(viewCtrl, "readonly"));
                invoke(getMethod(viewCtrl.getClass(), "_doShowEditor", boolean.class, Object.class), viewCtrl, readonly, object);
            }
        });
        return link;
    }

    @Override
    public Integer getColumnWidth() {
        return 150;
    }
//</editor-fold>
}