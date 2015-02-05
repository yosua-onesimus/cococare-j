package test;

import cococare.common.CCConfig;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCDatabaseConfig.SupportedDatabase;
import cococare.database.CCHibernate;
import model.obj.HabitatType;

public class Test {

    public static void main(String[] args) {
        CCConfig.HBN_SHOW_HQL = "true";
        CCConfig.MSG_SHOW_LOG_INFO = true;
        CCDatabaseConfig databaseConfig = new CCDatabaseConfig().
                withSupportedDatabase(SupportedDatabase.Derby);
        databaseConfig.setHost("dragon-city");
        databaseConfig.setAutoCreateDatabase(true);
        CCHibernate hibernate = new CCHibernate();
        hibernate.addAnnotatedClass(HabitatType.class);
        hibernate.addDatabaseConfig(databaseConfig);
        HabitatType habitatType = hibernate.get(HabitatType.class, 1l);
        System.out.println(habitatType.getCode());
    }
}