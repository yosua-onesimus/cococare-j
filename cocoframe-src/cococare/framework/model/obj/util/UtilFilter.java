package cococare.framework.model.obj.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateFilter;
//</editor-fold>

public class UtilFilter {

    public static CCHibernateFilter IsUserGroupNotRoot = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "root";
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };
    public static CCHibernateFilter IsUserNotRoot = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "userGroup.root";
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };
}