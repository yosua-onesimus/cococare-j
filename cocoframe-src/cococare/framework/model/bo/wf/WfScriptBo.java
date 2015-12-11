package cococare.framework.model.bo.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import static cococare.common.CCClass.*;
import static cococare.common.CCFormat.nextSequence;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCResponse;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" init ">
    /**
     * Create initial data.
     *
     * @param scriptClassNames the script class name.
     * @return true if success; false if fail.
     */
    public synchronized boolean initInitialData(List<String> scriptClassNames) {
        //
        List<WfScript> scripts = new ArrayList();
        for (String scriptClassName : scriptClassNames) {
            Class scriptClass = CCClass.getClass(scriptClassName);
            if (isNotNull(scriptClass)) {
                for (Class clazz : getClasses(scriptClass)) {
                    scripts.add(new WfScript(getLabel(clazz), clazz.getName(), ScriptType.ADDITIONAL_INPUT));
                }
                for (Method method : getMethods(scriptClass)) {
                    WfMethodConfig methodConfig = method.getAnnotation(WfMethodConfig.class);
                    if (isNotNull(methodConfig)) {
                        List parameterTypes = Arrays.asList(method.getParameterTypes());
                        boolean valid = false;
                        if (ScriptType.ACTION_VISIBILITY.equals(methodConfig.scriptType())) {
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
                            scripts.add(new WfScript(methodConfig.scriptName(), scriptClass.getName() + ":" + method.getName(), methodConfig.scriptType()));
                        }
                    }
                }
            }
        }
        //
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
        //
        return scriptDao.newTransaction().
                saveOrUpdate(scripts).
                execute();
    }
//</editor-fold>
}