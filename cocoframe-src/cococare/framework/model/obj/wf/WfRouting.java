package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.ComponentType;
import cococare.framework.model.obj.util.UtilUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfRouting {

    //
    private List<WfAction> actions = new ArrayList();
    private HashMap<WfAction, List<UtilUser>> action_users = new HashMap();
    //
    @CCFieldConfig(componentType = ComponentType.COMBOBOX)
    private WfAction action;
    @CCFieldConfig(componentType = ComponentType.COMBOBOX)
    private UtilUser holder;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public List<WfAction> getActions() {
        return actions;
    }

    public void setActions(List<WfAction> actions) {
        this.actions = actions;
    }

    public HashMap<WfAction, List<UtilUser>> getAction_users() {
        return action_users;
    }

    public void setAction_users(HashMap<WfAction, List<UtilUser>> action_users) {
        this.action_users = action_users;
    }

    public WfAction getAction() {
        return action;
    }

    public void setAction(WfAction action) {
        this.action = action;
    }

    public UtilUser getHolder() {
        return holder;
    }

    public void setHolder(UtilUser holder) {
        this.holder = holder;
    }
//</editor-fold>
}