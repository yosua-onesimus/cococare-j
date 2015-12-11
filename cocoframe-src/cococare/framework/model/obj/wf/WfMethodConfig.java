package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.lang.annotation.*;
//</editor-fold>

/**
 * WfMethodConfig
 *
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WfMethodConfig {

//<editor-fold defaultstate="collapsed" desc=" public enum ">
    /**
     * ScriptType
     */
    public enum ScriptType {

        /**
         * additionalInput
         */
        ADDITIONAL_INPUT,
        /**
         * actionVisibility
         */
        ACTION_VISIBILITY,
        /**
         * routeValidation
         */
        ROUTE_VALIDATION,
        /**
         * routeAvailability
         */
        ROUTE_AVAILABILITY,
        /**
         * postRouteProcess
         */
        POST_ROUTE_PROCESS;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter ">
    /**
     * Returns the scriptName.
     *
     * @return the scriptName.
     */
    String scriptName() default "";

    /**
     * Returns the scriptType.
     *
     * @return the scriptType.
     */
    ScriptType scriptType();
//</editor-fold>
}