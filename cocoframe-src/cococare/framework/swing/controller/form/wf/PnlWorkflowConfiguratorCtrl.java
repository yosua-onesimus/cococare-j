package cococare.framework.swing.controller.form.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCAccessibleListener;
import static cococare.common.CCClass.*;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.framework.model.bo.wf.WfWorkflowConfiguratorBo;
import cococare.framework.model.obj.wf.WfAction;
import cococare.framework.model.obj.wf.WfActivity;
import cococare.framework.model.obj.wf.WfEnum.ActivityPointType;
import cococare.framework.model.obj.wf.WfFilter.isAction;
import cococare.framework.model.obj.wf.WfFilter.isActivity;
import cococare.framework.model.obj.wf.WfFilter.isProcess;
import cococare.framework.model.obj.wf.WfProcess;
import cococare.framework.model.obj.wf.WfTransition;
import cococare.framework.swing.CFSwingCtrl;
import static cococare.swing.CCEditor.requestFocusInWindow;
import static cococare.swing.CCSwing.addAccessibleListener;
import static cococare.swing.CCSwing.applyAccessible;
import java.util.HashMap;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlWorkflowConfiguratorCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfWorkflowConfiguratorBo workflowConfiguratorBo;
    private HashMap<DefaultMutableTreeNode, Object> node_object = new HashMap();
    private HashMap< Object, DefaultMutableTreeNode> object_node = new HashMap();
    private DefaultTreeModel defaultTreeModel;
    private JTree treeProcess;
    private Object selectedObject;
//</editor-fold>

    @Override
    protected Class _getClass() {
        if (isNotNull(selectedObject)) {
            Class selectedClass = selectedObject.getClass();
            if (String.class.equals(selectedClass)) {
                return PnlProcessListCtrl.class;
            } else if (WfProcess.class.equals(selectedClass)) {
                return PnlActivityListCtrl.class;
            } else if (WfActivity.class.equals(selectedClass)) {
                return PnlActionListCtrl.class;
            } else if (WfAction.class.equals(selectedClass)) {
                return PnlTransitionListCtrl.class;
            }
        }
        return PnlWorkflowConfiguratorCtrl.class;
    }

    @Override
    protected Class _getEntity() {
        if (isNotNull(selectedObject)) {
            Class selectedClass = selectedObject.getClass();
            if (String.class.equals(selectedClass)) {
                return WfProcess.class;
            } else if (WfProcess.class.equals(selectedClass)) {
                return WfActivity.class;
            } else if (WfActivity.class.equals(selectedClass)) {
                return WfAction.class;
            } else if (WfAction.class.equals(selectedClass)) {
                return WfTransition.class;
            }
        }
        return WfProcess.class;
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
    protected void _initComponent() {
        super._initComponent();
        _initTreeProcess();
    }

    @Override
    protected void _initTable() {
        super._initTable();
        parameter.put(toString() + "tblEntity", tblEntity);
    }

    private DefaultMutableTreeNode _newNode(String label, Object object) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(label);
        node_object.put(node, object);
        object_node.put(getSysRef(object), node);
        return node;
    }

    private void _initTreeProcess() {
        DefaultMutableTreeNode nodeRoot = _newNode(turn(Process), "root");
        treeProcess.setModel(defaultTreeModel = new DefaultTreeModel(nodeRoot));
        for (WfProcess process : workflowConfiguratorBo.getProcesses()) {
            DefaultMutableTreeNode nodeProcess = _newNode(process.getName(), process);
            nodeRoot.add(nodeProcess);
            for (WfActivity activity : workflowConfiguratorBo.getActivitesBy(process)) {
                DefaultMutableTreeNode nodeActivity = _newNode(activity.getName(), activity);
                nodeProcess.add(nodeActivity);
                for (WfAction action : workflowConfiguratorBo.getActionsBy(activity)) {
                    DefaultMutableTreeNode nodeAction = _newNode(action.getName(), action);
                    nodeActivity.add(nodeAction);
                }
            }
        }
        _doTreeProcess();
    }

    @Override
    protected void _initAccessible() {
        super._initAccessible();
        addAccessibleListener(swingView.getBtnAdd(), new CCAccessibleListener() {
            @Override
            public boolean isAccessible() {
                return !(selectedObject instanceof WfActivity)
                        || !ActivityPointType.FINAL_POINT.equals(((WfActivity) selectedObject).getActivityPointType());
            }
        });
    }

    @Override
    protected void _initListener() {
        super._initListener();
        treeProcess.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                _doTreeProcess();
            }
        });
    }

    @Override
    protected boolean _doDeleteEntity() {
        parameter.put(toString() + "crudObject", _getSelectedItem());
        return super._doDeleteEntity();
    }

    private void _doTreeProcess() {
        selectedObject = node_object.get((DefaultMutableTreeNode) treeProcess.getLastSelectedPathComponent());
        if (isNull(selectedObject)) {
            treeProcess.setSelectionRow(0);
            _doTreeProcess();
        } else {
            for (String string : sysRef_swingCtrl.keySet()) {
                doCloseTab(string);
            }
            applyAccessible(swingView.getBtnAdd());
            parameter.put(toString() + "selectedObject", selectedObject);
            Class selectedClass = selectedObject.getClass();
            if (String.class.equals(selectedClass)) {
                swingView.getTabEntity().setTitleAt(0, turn(Process));
                tblEntity.setEntity(WfProcess.class);
            } else if (WfProcess.class.equals(selectedClass)) {
                swingView.getTabEntity().setTitleAt(0, turn(Activity));
                tblEntity.setEntity(WfActivity.class);
                tblEntity.setHqlFilters(new isProcess() {
                    @Override
                    public Object getFieldValue() {
                        return selectedObject;
                    }
                });
            } else if (WfActivity.class.equals(selectedClass)) {
                swingView.getTabEntity().setTitleAt(0, turn(Action));
                tblEntity.setEntity(WfAction.class);
                tblEntity.setHqlFilters(new isActivity() {
                    @Override
                    public Object getFieldValue() {
                        return selectedObject;
                    }
                });
            } else if (WfAction.class.equals(selectedClass)) {
                swingView.getTabEntity().setTitleAt(0, turn(Transition));
                tblEntity.setEntity(WfTransition.class);
                tblEntity.setHqlFilters(new isAction() {
                    @Override
                    public Object getFieldValue() {
                        return selectedObject;
                    }
                });
            }
            tblEntity.search();
        }
    }

    @Override
    protected String _getTabTitle() {
        return _getEntityLabel();
    }

    @Override
    public void doUpdateTable() {
        _doUpdateTreeProcess();
        super.doUpdateTable();
        requestFocusInWindow(treeProcess);
    }

    @Override
    public void doUpdateTablePartial(Object objEntity) {
        _doUpdateTreeProcess();
        super.doUpdateTablePartial(objEntity);
    }

    private void _doUpdateTreeProcess() {
        Object crudObject = parameter.get(toString() + "crudObject");
        if (crudObject instanceof WfProcess
                || crudObject instanceof WfActivity
                || crudObject instanceof WfAction) {
            DefaultMutableTreeNode selectedNode = object_node.get(getSysRef(selectedObject));
            DefaultMutableTreeNode crudNode = object_node.get(getSysRef(crudObject));
            if (isNotNull(getObjectById(crudObject.getClass(), (Long) getValue(crudObject, "id")))) {
                String label = getValue(crudObject, "name").toString();
                if (isNotNull(crudNode)) {
                    crudNode.setUserObject(label);
                } else {
                    selectedNode.add(_newNode(label, crudObject));
                }
            } else {
                selectedNode.remove(crudNode);
            }
            defaultTreeModel.reload(selectedNode);
            parameter.put(toString() + "crudObject", null);
        }
    }
}