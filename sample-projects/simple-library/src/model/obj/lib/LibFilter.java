package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateFilter;
//</editor-fold>

public class LibFilter {

    public static CCHibernateFilter isSuspendFalse = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "suspend";
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };
    public static CCHibernateFilter isBorrowedFalse = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "borrowed";
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };

    public static abstract class isBorrowingMember extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "borrowing.member_";
        }

        @Override
        public boolean isValid(Class entity) {
            return true;
        }
    };
    public static CCHibernateFilter isReturnedFalse = new CCHibernateFilter() {
        @Override
        public String getFieldName() {
            return "returned";
        }

        @Override
        public Object getFieldValue() {
            return false;
        }
    };
}