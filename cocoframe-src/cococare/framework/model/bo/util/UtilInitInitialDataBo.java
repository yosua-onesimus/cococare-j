package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFinal.ADMIN;
import static cococare.common.CCFinal.ROOT;
import static cococare.common.CCLogic.*;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import cococare.framework.model.dao.util.*;
import cococare.framework.model.obj.util.*;
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilInitInitialDataBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private UtilPrivilegeDao privilegeDao;
    private UtilUserGroupDao userGroupDao;
    private UtilUserGroupPrivilegeDao userGroupPrivilegeDao;
    private UtilUserDao userDao;
    private UtilUserPrivilegeDao userPrivilegeDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" private method ">
    private synchronized List<UtilPrivilege> _validate(UtilPrivilege privilege) {
        List<UtilPrivilege> validPrivileges = new ArrayList();
        UtilPrivilege oldPrivilege = privilegeDao.getByComp(privilege.getComp());
        if (isNotNull(oldPrivilege)) {
            privilege.setId(oldPrivilege.getId());
            privilege.setLogSaveTimes(oldPrivilege.getLogSaveTimes());
        }
        validPrivileges.add(privilege);
        for (UtilPrivilege child : privilege.getChilds()) {
            validPrivileges.addAll(_validate(child));
        }
        return validPrivileges;
    }

    private synchronized List<UtilPrivilege> _validate(List<UtilPrivilege> privileges) {
        List<UtilPrivilege> validPrivileges = new ArrayList();
        for (UtilPrivilege privilege : privileges) {
            validPrivileges.addAll(_validate(privilege));
        }
        return validPrivileges;
    }

    private synchronized UtilUserGroup _newUserGroup(String code, String name, boolean root) {
        return coalesce(
                userGroupDao.getByCode(code),
                new UtilUserGroup(code, name, root));
    }

    private synchronized List<UtilUserGroupPrivilege> _newUserGroupPrivileges(UtilUserGroup userGroup) {
        List<UtilUserGroupPrivilege> userGroupPrivileges = new ArrayList();
        for (UtilPrivilege privilege : privilegeDao.getListUnlimited()) {
            UtilUserGroupPrivilege userGroupPrivilege = isNull(userGroup.getId()) ? null : userGroupPrivilegeDao.getBy(userGroup, privilege);
            if (isNull(userGroupPrivilege)) {
                userGroupPrivilege = new UtilUserGroupPrivilege(userGroup, privilege);
            }
            userGroupPrivileges.add(userGroupPrivilege);
        }
        return userGroupPrivileges;
    }

    private synchronized UtilUser _newUser(String username, String password, String fullname, UtilUserGroup userGroup) {
        return coalesce(
                userDao.getByUsername(username),
                new UtilUser(username, password, fullname, userGroup));
    }

    private synchronized List<UtilUserPrivilege> _newUserPrivileges(UtilUser user) {
        List<UtilUserPrivilege> userPrivileges = new ArrayList();
        for (UtilPrivilege privilege : privilegeDao.getListUnlimited()) {
            UtilUserPrivilege userPrivilege = isNull(user.getId()) ? null : userPrivilegeDao.getBy(user, privilege);
            if (isNull(userPrivilege)) {
                userPrivilege = new UtilUserPrivilege(user, privilege);
            }
            userPrivileges.add(userPrivilege);
        }
        return userPrivileges;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized boolean initFirstData(List<UtilPrivilege> privileges) {
        //1. validasi privileges
        if (isNotNullAndNotEmpty(privileges)) {
            privileges = _validate(privileges);
        }
        //2. save privileges
        if (isNull(privileges) || privilegeDao.saveOrUpdate(privileges)) {
            Transaction transaction = privilegeDao.newTransaction();
            //3. create root
            UtilUserGroup userGroup = _newUserGroup(ROOT, ROOT, true);
            List<UtilUserGroupPrivilege> userGroupPrivileges = _newUserGroupPrivileges(userGroup);
            UtilUser user = _newUser(ROOT, ROOT, ROOT, userGroup);
            List<UtilUserPrivilege> userPrivileges = _newUserPrivileges(user);
            transaction.saveOrUpdate(userGroup).saveOrUpdate(userGroupPrivileges).
                    saveOrUpdate(user).saveOrUpdate(userPrivileges);
            //4. create admin
            userGroup = _newUserGroup(ADMIN, ADMIN, false);
            userGroupPrivileges = _newUserGroupPrivileges(userGroup);
            user = _newUser(ADMIN, ADMIN, ADMIN, userGroup);
            userPrivileges = _newUserPrivileges(user);
            transaction.saveOrUpdate(userGroup).saveOrUpdate(userGroupPrivileges).
                    saveOrUpdate(user).saveOrUpdate(userPrivileges);
            return transaction.execute();
        }
        return false;
    }
//</editor-fold>
}