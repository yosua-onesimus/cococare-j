package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFinal.ROOT;
import cococare.database.CCHibernateFilter;
import static cococare.database.CCLoginInfo.INSTANCE_getUserLogin;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilFilter {

    public static CCHibernateFilter isUserGroupNotRoot = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return ROOT;
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };
    public static CCHibernateFilter isUserNotRoot = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "userGroup.root";
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };
    public static CCHibernateFilter isUserIsUserLogin = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "user";
        }

        @Override
        public Object getFieldValue() {
            return INSTANCE_getUserLogin();
        }
    };

    public static abstract class isProvince extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "province";
        }
    };

    public static abstract class isId extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "id";
        }
    }

    public static abstract class isIdNotId extends isId {

        @Override
        public String getExpression() {
            return "id != :id";
        }
    }

    public static abstract class isIdInIds extends isId {

        @Override
        public String getExpression() {
            return "id IN (:ids)";
        }

        @Override
        public String getParameterName() {
            return "ids";
        }
    }

    public static abstract class isIdNotInIds extends isIdInIds {

        @Override
        public String getExpression() {
            return "id NOT IN (:ids)";
        }
    }
}