package cococare.framework.model.mdl.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.database.CCEntityConfig.FIELD_APPL;
import cococare.database.CCHibernate;
import cococare.database.CCHibernateFilter;
import cococare.database.CCHibernateModule;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.obj.util.*;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilityModule extends CCHibernateModule {

    public static UtilityModule INSTANCE = new UtilityModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(UtilConfig.class);
        hibernate.addAnnotatedClass(UtilLogger.class);
        hibernate.addAnnotatedClass(UtilPrivilege.class);
        hibernate.addAnnotatedClass(UtilArea.class);
        //
        hibernate.addAnnotatedClass(UtilUserGroup.class);
        hibernate.addAnnotatedClass(UtilUserGroupPrivilege.class);
        hibernate.addAnnotatedClass(UtilUserGroupIp.class);
        hibernate.addAnnotatedClass(UtilUserGroupChild.class);
        //
        hibernate.addAnnotatedClass(UtilUser.class);
        hibernate.addAnnotatedClass(UtilUserPrivilege.class);
        hibernate.addAnnotatedClass(UtilUserIp.class);
        hibernate.addAnnotatedClass(UtilUserChild.class);
        //
        hibernate.addAnnotatedClass(UtilPerson.class);
        //
        addFilters(new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return FIELD_APPL;
            }

            @Override
            public Object getFieldValue() {
                return CFApplCtrl.APPL_CODE;
            }
        });
    }
//</editor-fold>
}