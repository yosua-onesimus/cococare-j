package cococare.framework.model.mdl.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.*;
import static cococare.database.CCEntityConfig.FIELD_APPL;
import cococare.database.CCHibernateFilter;
import cococare.database.CCHibernateModule;
import static cococare.framework.common.CFApplCtrl.APPL_CODE;
import cococare.framework.model.obj.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    protected List<Class> _getAnnotatedClasses() {
        List<Class> annotatedClasses = new ArrayList();
        if (APPL_UTIL_INCLUDED_PERSON_ENTITIES) {
            annotatedClasses.add(UtilCountry.class);
            annotatedClasses.add(UtilProvince.class);
            annotatedClasses.add(UtilRegency.class);
            annotatedClasses.add(UtilSubDistrict.class);
            annotatedClasses.add(UtilVillage.class);
            annotatedClasses.add(UtilZipCode.class);
            annotatedClasses.add(UtilPerson.class);
        }
        if (APPL_UTIL_INCLUDED_PERSON_ENTITIES || APPL_UTIL_SHOW_WORKFLOW_MODULE) {
            annotatedClasses.add(UtilArea.class);
        }
        //
        annotatedClasses.add(UtilConfig.class);
        if (APPL_UTIL_SHOW_SCHEDULER_MODULE) {
            annotatedClasses.add(UtilScheduler.class);
        }
        annotatedClasses.add(UtilLogger.class);
        annotatedClasses.add(UtilPrivilege.class);
        //
        annotatedClasses.add(UtilUserGroup.class);
        annotatedClasses.add(UtilUserGroupPrivilege.class);
        annotatedClasses.add(UtilUserGroupIp.class);
        annotatedClasses.add(UtilUserGroupChild.class);
        //
        annotatedClasses.add(UtilUser.class);
        annotatedClasses.add(UtilUserPrivilege.class);
        annotatedClasses.add(UtilUserIp.class);
        annotatedClasses.add(UtilUserChild.class);
        return annotatedClasses;
    }

    @Override
    public List<CCHibernateFilter> getFilters() {
        return (List) Arrays.asList(
                new CCHibernateFilter() {
            @Override
            public String getFieldName() {
                return FIELD_APPL;
            }

            @Override
            public Object getFieldValue() {
                return APPL_CODE;
            }
        });
    }
//</editor-fold>
}