package cococare.framework.model.obj.wf;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateFilter;
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class WfFilter {

    public static abstract class isProcess extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "process";
        }
    };

    public static abstract class isActivity extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "activity";
        }
    };

    public static abstract class isAction extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "action";
        }
    };

    public static abstract class isTypeIndex extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "typeIndex";
        }
    }
    public static CCHibernateFilter isTypeIsViewCustomization = new isTypeIndex() {
        @Override
        public Object getFieldValue() {
            return ScriptType.VIEW_CUSTOMIZATION.ordinal();
        }
    };
    public static CCHibernateFilter isTypeIsActionVisibility = new isTypeIndex() {
        @Override
        public Object getFieldValue() {
            return ScriptType.ACTION_VISIBILITY.ordinal();
        }
    };
    public static CCHibernateFilter isTypeIsRouteValidation = new isTypeIndex() {
        @Override
        public Object getFieldValue() {
            return ScriptType.ROUTE_VALIDATION.ordinal();
        }
    };
    public static CCHibernateFilter isTypeIsRouteAvailability = new isTypeIndex() {
        @Override
        public Object getFieldValue() {
            return ScriptType.ROUTE_AVAILABILITY.ordinal();
        }
    };
    public static CCHibernateFilter isTypeIsPostRouteProcess = new isTypeIndex() {
        @Override
        public Object getFieldValue() {
            return ScriptType.POST_ROUTE_PROCESS.ordinal();
        }
    };
}