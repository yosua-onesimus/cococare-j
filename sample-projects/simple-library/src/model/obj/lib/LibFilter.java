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
}