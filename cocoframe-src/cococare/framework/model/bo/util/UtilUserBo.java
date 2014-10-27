package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.*;
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.*;
import static cococare.common.CCMessage.*;
import cococare.common.trial.MD5;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCEntityBo;
import static cococare.database.CCEntityConfig.FIELD_ID;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import static cococare.database.CCLoginInfo.*;
import cococare.framework.model.dao.util.*;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.obj.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class UtilUserBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    private List<Class> utilAdditionalTabClass;
    //
    private UtilPrivilegeDao privilegeDao;
    private UtilUserGroupIpDao userGroupIpDao;
    private UtilUserGroupChildDao userGroupChildDao;
    private UtilUserDao userDao;
    private UtilUserPrivilegeDao userPrivilegeDao;
    private UtilUserIpDao userIpDao;
    private UtilUserChildDao userChildDao;
    //
    private UtilUser user;
    private List<UtilPrivilege> privileges;
    private HashMap<UtilPrivilege, Integer> privilege_index;
    private List<Boolean> privilegeSelecteds;
    private List<UtilUserIp> userIps;
    private List<UtilUserIp> removedUserIps;
    private HashMap<Class, List> clazz_child;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized void load(UtilUser user) {
        //
        utilAdditionalTabClass = new UtilConfigBo().loadConfAppl().getUtilAdditionalTabClass();
        //
        this.user = user;
        //
        privileges = privilegeDao.getListUnlimited();
        privilege_index = new HashMap();
        privilegeSelecteds = isNull(user.getId()) ? null : privilegeDao.getListSelectedUnlimitedBy(user);
        for (int i = 0; i < privileges.size(); i++) {
            UtilPrivilege privilege = privileges.get(i);
            if (isNotNull(privilegeSelecteds)) {
                privilege.setSelected(privilegeSelecteds.get(i));
            }
            privilege_index.put(privilege, i);
            if (isNotNull(privilege.getParent())) {
                privileges.get(privilege_index.get(privilege.getParent())).addChilds(privilege);
            }
        }
        //
        userIps = isNull(user.getId()) ? new ArrayList() : userIpDao.getListUnlimitedBy(user);
        removedUserIps = new ArrayList();
        clazz_child = new HashMap();
        for (Class clazz : utilAdditionalTabClass) {
            clazz_child.put(clazz, getListByAssociativeArray(clazz, userChildDao.getBy(user, clazz).getAssociativeArray()));
        }
    }

    public synchronized List<UtilPrivilege> getPrivileges() {
        return privileges;
    }

    public synchronized List<UtilPrivilege> getPrivileges(UtilUserGroup userGroup) {
        List<Boolean> selecteds = privilegeDao.getListSelectedUnlimitedBy(userGroup);
        for (int i = 0; i < privileges.size(); i++) {
            privileges.get(i).setSelected(selecteds.get(i));
        }
        return privileges;
    }

    public synchronized List getSelectedItem(UtilUserGroup userGroup, Class clazz) {
        return getListByAssociativeArray(clazz, userGroupChildDao.getBy(userGroup, clazz).getAssociativeArray());
    }

    public synchronized int getPrivilegeIndex(UtilPrivilege privilege) {
        return parseInt(privilege_index.get(privilege));
    }

    public synchronized List<UtilUserIp> getUserIps() {
        return userIps;
    }

    public synchronized void addUserIp(String ip) {
        UtilUserIp userIp = coalesce(isNull(user.getId()) ? null : userIpDao.getBy(user, ip), new UtilUserIp(user, ip));
        if (isNotNull(userIp.getId())) {
            for (UtilUserIp old : removedUserIps) {
                if (old.getIp().equalsIgnoreCase(ip)) {
                    removedUserIps.remove(old);
                    break;
                }
            }
        }
        boolean isNew = true;
        for (UtilUserIp old : userIps) {
            if (old.getIp().equalsIgnoreCase(ip)) {
                isNew = false;
                break;
            }
        }
        if (isNew) {
            userIps.add(userIp);
        }
    }

    public synchronized void removeUserIp(int index) {
        UtilUserIp userIp = userIps.remove(index);
        if (isNotNull(userIp.getId())) {
            removedUserIps.add(userIp);
        }
    }

    public synchronized List<Class> getUtilAdditionalTabClass() {
        return utilAdditionalTabClass;
    }

    public synchronized List getListBy(Class clazz) {
        return CCEntityBo.INSTANCE.getListBy(clazz, null, null, null);
    }

    public synchronized List getSelectedItem(Class clazz) {
        return clazz_child.get(clazz);
    }

    public synchronized void addChild(Class clazz, List selectedItems) {
        clazz_child.put(clazz, selectedItems);
    }

    public synchronized boolean saveOrUpdate() {
        Transaction transaction = userDao.newTransaction();
        //
        transaction.saveOrUpdate(user);
        //
        for (int i = 0; i < privileges.size(); i++) {
            UtilPrivilege privilege = privileges.get(i);
            if (isNull(privilegeSelecteds) || (privilegeSelecteds.get(i) != privilege.isSelected())) {
                if (privilege.isSelected()) {
                    transaction.saveOrUpdate(new UtilUserPrivilege(user, privilege));
                } else if (isNotNull(privilegeSelecteds)) {
                    transaction.delete(userPrivilegeDao.getBy(user, privilege));
                }
            }
        }
        //
        transaction.saveOrUpdate(userIps).
                delete(removedUserIps);
        //
        for (Class clazz : utilAdditionalTabClass) {
            UtilUserChild userChild = userChildDao.getBy(user, clazz);
            userChild.setAssociativeArray(getAssociativeArray(clazz_child.get(clazz)));
            transaction.saveOrUpdate(userChild);
        }
        //
        return transaction.execute();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" changePassword ">
    public synchronized boolean changePassword(UtilUser user) {
        try {
            user.setPassword(user.getNewPassword());
            return userDao.saveOrUpdate(user);
        } catch (Exception exception) {
            logp(exception);
            return false;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" login ">
    public synchronized HashMap<String, Boolean> getUserPrivilege(UtilUser user) {
        HashMap<String, Boolean> privilegeComp_accessible = new HashMap();
        for (UtilUserPrivilege userPrivilege : userPrivilegeDao.getListUnlimitedBy(user)) {
            privilegeComp_accessible.put(userPrivilege.getPrivilege().getComp(), true);
        }
        return privilegeComp_accessible;
    }

    public synchronized boolean login(String username, String password) {
        INSTANCE_resetDomainAndUserLoginIp();
        CCDatabaseConfig databaseConfig = UtilityModule.INSTANCE.getCCHibernate().getDatabaseConfig();
        if (isNull(databaseConfig) || !databaseConfig.isValidDate()) {
            setErrorMessage(turn(Can_not_log_you_in));
            setCauseMessage(turn(Your_domain_has_been_suspended_or_no_longer_active));
            return false;
        }
        user = userDao.getByUsername(username);
        if (isNull(user) || isNull(user.getId()) || !user.getPassword().equals(new MD5(password).toString())) {
            setErrorMessage(turn(Can_not_log_you_in));
            setCauseMessage(turn(The_username_or_password_you_entered_is_incorrect));
            return false;
        }
        if (!user.getActive()) {
            setErrorMessage(turn(Can_not_log_you_in));
            setCauseMessage(turn(Your_account_has_been_suspended_or_no_longer_active));
            return false;
        }
        if (userIpDao.hasRestriction(user) && !userIpDao.isValid(user, INSTANCE_getUserLoginIp())) {
            setErrorMessage(turn(Can_not_log_you_in));
            setCauseMessage(turn(Your_IP_has_been_restricted));
            return false;
        }
        INSTANCE_login(user, getUserPrivilege(user));
        return true;
    }

    public synchronized List getIdsUserLogin(Class clazz) {
        return extract(getListByAssociativeArray(clazz, userChildDao.getBy((UtilUser) INSTANCE_getUserLogin(), clazz).getAssociativeArray()), FIELD_ID);
    }
//</editor-fold>
}