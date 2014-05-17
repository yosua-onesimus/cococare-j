package a.simple.sample;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.*;
import static cococare.common.CCFinal.FORMAT_DATE;
import static cococare.common.CCFormat.getDate;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernate;
import model.mdl.lib.LibraryModule;
import model.obj.lib.LibMember;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class No0_Static {

    public static void initConfig() {
        MSG_SHOW_PRINTLN = true;
        MSG_SHOW_LOG_INFO = false;
        MSG_SHOW_LOG_SEVERE = true;
        HBN_SHOW_HQL = "false";
    }

    public static void initHibernate() {
        CCHibernate hibernate = new CCHibernate();
        LibraryModule.INSTANCE.init(hibernate);
        hibernate.addDatabaseConfig(new CCDatabaseConfig().
                withHost("localhost").
                withPort("3306").
                withUsername("root").
                withPassword("1234").
                withDatabase("coco_trial"));
    }

    public static LibMember newMember(String code, String fullName, String birthDate) {
        LibMember member = new LibMember();
        member.setCode(code);
        member.setFullName(fullName);
        member.setBirthDate(getDate(birthDate, FORMAT_DATE));
        return member;
    }
}