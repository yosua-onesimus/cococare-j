package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.copy;
import static cococare.common.CCClass.getMethods;
import static cococare.common.CCFormat.nextSequence;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCResponse;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import cococare.framework.common.CFViewCtrl;
import cococare.framework.model.dao.wf.WfScriptDao;
import cococare.framework.model.obj.wf.WfMethodConfig;
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
import cococare.framework.model.obj.wf.WfScript;
import cococare.framework.model.obj.wf.WfWorkflow;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfScriptBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private WfScriptDao scriptDao;
    private List<WfScript> scripts = new ArrayList();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    /**
     * Sets the scripts with the scriptClass.
     *
     * @param scriptClass the scriptClass.
     */
    public synchronized void setScriptClass(List<String> scriptClass) {
        scripts.clear();
        for (String scriptClassName : scriptClass) {
            Class clazz = CCClass.getClass(scriptClassName);
            if (isNotNull(clazz)) {
                for (Method method : getMethods(clazz)) {
                    WfMethodConfig methodConfig = method.getAnnotation(WfMethodConfig.class);
                    if (isNotNull(methodConfig)) {
                        List parameterTypes = Arrays.asList(method.getParameterTypes());
                        boolean valid = false;
                        if (ScriptType.VIEW_CUSTOMIZATION.equals(methodConfig.scriptType())) {
                            valid = (parameterTypes.size() == 2)
                                    && parameterTypes.contains(CFViewCtrl.class)
                                    && parameterTypes.contains(WfWorkflow.class);
                        } else if (ScriptType.ACTION_VISIBILITY.equals(methodConfig.scriptType())) {
                            valid = (parameterTypes.size() == 1)
                                    && parameterTypes.contains(WfWorkflow.class)
                                    && boolean.class.equals(method.getReturnType());
                        } else if (ScriptType.ROUTE_VALIDATION.equals(methodConfig.scriptType())) {
                            valid = (parameterTypes.size() == 1)
                                    && parameterTypes.contains(WfWorkflow.class)
                                    && CCResponse.class.equals(method.getReturnType());
                        } else if (ScriptType.ROUTE_AVAILABILITY.equals(methodConfig.scriptType())) {
                            valid = (parameterTypes.size() == 1)
                                    && parameterTypes.contains(WfWorkflow.class)
                                    && boolean.class.equals(method.getReturnType());
                        } else if (ScriptType.POST_ROUTE_PROCESS.equals(methodConfig.scriptType())) {
                            valid = (parameterTypes.size() == 2)
                                    && parameterTypes.contains(Transaction.class)
                                    && parameterTypes.contains(WfWorkflow.class);
                        }
                        if (valid) {
                            scripts.add(new WfScript(methodConfig.scriptName(), clazz.getName() + ":" + method.getName(), methodConfig.scriptType()));
                        }
                    }
                }
            }
        }
    }

    /**
     * Create initial data.
     *
     * @return true if success; false if fail.
     */
    public synchronized boolean initInitialData() {
        String code = scriptDao.getLastCode();
        for (WfScript script : scripts) {
            WfScript oldScript = scriptDao.getByPath(script.getPath());
            if (isNull(oldScript)) {
                script.setCode(code = nextSequence(code));
            } else {
                script.setId(oldScript.getId());
                script.setLogSaveTimes(oldScript.getLogSaveTimes());
                copy(oldScript, script);
            }
        }
        return scriptDao.newTransaction().
                saveOrUpdate(scripts).
                execute();
    }
//</editor-fold>
}