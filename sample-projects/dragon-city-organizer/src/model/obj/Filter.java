package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateFilter;
//</editor-fold>

public class Filter {

    public static abstract class isHabitatType extends CCHibernateFilter {

        @Override
        public String getFieldName() {
            return "habitatType1";
        }

        @Override
        public String getExpression() {
            return ":habitatType IN (habitatType1, habitatType2, habitatType3)";
        }

        @Override
        public String getParameterName() {
            return "habitatType";
        }
    }
}