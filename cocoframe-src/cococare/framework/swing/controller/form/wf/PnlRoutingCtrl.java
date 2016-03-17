package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.WF_MULTI_PROCESS;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.showError;
import cococare.common.CCResponse;
import cococare.framework.model.bo.wf.WfWorkflowBo;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.wf.*;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCEditor;
import static cococare.swing.CCSwing.*;
import cococare.swing.component.CCButton;
import cococare.swing.component.CCComboBox;
import cococare.swing.component.CCOptionBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlRoutingCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfWorkflowBo workflowBo;
    private WfDocument document;
    private WfWorkflow workflow;
    private WfRouting routing;
    private CCButton btnProcess;
    private CCButton btnRoute;
    private CCOptionBox pnlMultiProcess;
    private JLabel xProcess;
    private CCComboBox cmbProcess;
    private JLabel xAction;
    private CCComboBox cmbAction;
    private JLabel xUser;
    private CCComboBox cmbUser;
    private JPanel pnlAdditionalInput;
    private CCEditor edtAdditionalInput;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return WfRouting.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected ShowMode _getShowMode() {
        return ShowMode.PANEL_MODE;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        workflow = (WfWorkflow) parameter.get(callerCtrl.toString() + "workflow");
        if (isNotNull(workflow)) {
            objEntity = workflow.getRouting();
        } else {
            document = (WfDocument) parameter.get(callerCtrl.toString() + "document");
        }
        routing = (WfRouting) objEntity;
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        pnlMultiProcess.setVisible(WF_MULTI_PROCESS && isNull(workflow));
        if (isNotNull(workflow)) {
            cmbAction.setList(workflow.getRouting().getActions());
        } else {
            if (WF_MULTI_PROCESS) {
                pnlMultiProcess.initList(false, WfProcess.class, "name");
                pnlMultiProcess.setList(workflowBo.getFirstProcesses());
                swingView.getPnlGenerator().setVisible(false);
            } else {
                cmbProcess.setList(workflowBo.getFirstProcesses());
            }
        }
    }

    @Override
    protected void _initListener() {
        super._initListener();
        alClose = (ActionListener) parameter.get(callerCtrl.toString() + "alCloseOnSuccess");
        if (isNotNull(workflow)) {
            btnProcess.setVisible(false);
            addListener(btnRoute, alSave);
            addListener(cmbAction, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doUpdateUserField();
                    _doUpdateAdditionalInput();
                }
            });
        } else {
            addListener(btnProcess, alSave);
            btnRoute.setVisible(false);
            addListener(cmbProcess, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    _doUpdateAdditionalInput();
                }
            });
        }
    }

    @Override
    protected void _doUpdateAccessible() {
        super._doUpdateAccessible();
        if (isNotNull(workflow)) {
            edtEntity.setAccessible(cmbProcess, Accessible.NORMAL);
            setVisible(false, xProcess, cmbProcess);
        } else {
            edtEntity.setAccessible(cmbAction, Accessible.NORMAL);
            setVisible(false, xAction, cmbAction);
            edtEntity.setAccessible(cmbUser, Accessible.NORMAL);
            setVisible(false, xUser, cmbUser);
        }
    }

    @Override
    protected void _doSave() {
        if (_isValueValid() && _isSureSave()) {
            _getValueFromEditor();
            if (isNotNull(workflow)) {
                CCResponse response = workflowBo.route(workflow);
                if (updateCaller = response.isTrue()) {
                    _logger(workflow);
                    execute(alClose, null);
                } else {
                    showError(response.getMessage());
                }
            } else {
                WfProcess process = cmbProcess.getSelectedObject();
                process.setRouting(routing);
                CCResponse response = workflowBo.createNewWorkflow(process, document);
                if (updateCaller = response.isTrue()) {
                    _logger(document);
                    execute(alClose, null);
                } else {
                    showError(response.getMessage());
                }
            }
        }
    }

    @Override
    protected void _getValueFromEditor() {
        super._getValueFromEditor();
        if (isNotNull(edtAdditionalInput)) {
            edtAdditionalInput.getValueFromEditor();
        }
    }

    private void _doUpdateUserField() {
        List<UtilUser> users = workflow.getRouting().getAction_users().get((WfAction) cmbAction.getSelectedObject());
        boolean manualRoute = isNotNull(users);
        edtEntity.setAccessible(cmbUser, manualRoute ? Accessible.MANDATORY : Accessible.NORMAL);
        setVisible(manualRoute, xUser, cmbUser);
        if (manualRoute) {
            cmbUser.setList(users);
        }
    }

    private void _doUpdateAdditionalInput() {
        WfScript additionalInput = null;
        if (isNotNull(workflow)) {
            WfAction action = cmbAction.getSelectedObject();
            if (isNotNull(action)) {
                additionalInput = action.getAdditionalInput();
            }
        } else {
            WfProcess process = cmbProcess.getSelectedObject();
            if (isNotNull(process)) {
                additionalInput = process.getAdditionalInput();
            }
        }
        pnlAdditionalInput.setVisible(isNotNull(additionalInput));
        if (isNotNull(additionalInput)) {
            edtAdditionalInput = new CCEditor(pnlAdditionalInput, additionalInput.getAdditionalInputClass());
            edtAdditionalInput.generateDefaultEditor(pnlAdditionalInput);
            routing.setAdditionalInput(edtAdditionalInput.newItem());
            edtAdditionalInput.setValueToEditor(routing.getAdditionalInput());
        }
    }
}