package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLanguage.*;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import static cococare.common.CCMessage.*;
import cococare.common.trial.MD5;
import cococare.database.CCDatabaseConfig;
import cococare.database.CCHibernateBo;
import cococare.database.CCHibernateDao.Transaction;
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
    private UtilPrivilegeDao privilegeDao;
    private UtilUserDao userDao;
    private UtilUserPrivilegeDao userPrivilegeDao;
    private UtilUserIpDao userIpDao;
    private UtilUserAreaDao userAreaDao;
    //
    private UtilUser user;
    private List<UtilPrivilege> privileges;
    private HashMap<UtilPrivilege, Integer> privilege_index;
    private List<Boolean> privilegeSelecteds;
    private List<UtilUserIp> userIps;
    private List<UtilUserIp> removedUserIps;
    private List<UtilUserArea> userAreas;
    private List<UtilUserArea> removedUserAreas;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized void load(UtilUser user) {
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
        userAreas = isNull(user.getId()) ? new ArrayList() : userAreaDao.getListUnlimitedBy(user);
        removedUserAreas = new ArrayList();
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

    public synchronized int getPrivilegeIndex(UtilPrivilege privilege) {
        return parseInt(privilege_index.get(privilege));
    }

    public synchronized List<UtilUserIp> getUserIps() {
        return userIps;
    }

    public synchronized void addUserIp(String ip) {
        UtilUserIp userIp = isNull(user.getId()) ? null : userIpDao.getBy(user, ip);
        if (isNull(userIp)) {
            userIp = new UtilUserIp();
            userIp.setUser(user);
            userIp.setIp(ip);
        } else {
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

    public synchronized List<UtilUserArea> getUserAreas() {
        return userAreas;
    }

    public synchronized void addUserArea(UtilArea area) {
        UtilUserArea userArea = isNull(user.getId()) ? null : userAreaDao.getBy(user, area);
        if (isNull(userArea)) {
            userArea = new UtilUserArea();
            userArea.setUser(user);
            userArea.setArea(area);
        } else {
            for (UtilUserArea old : removedUserAreas) {
                if (old.getArea().getId().equals(area.getId())) {
                    removedUserAreas.remove(old);
                    break;
                }
            }
        }
        boolean isNew = true;
        for (UtilUserArea old : userAreas) {
            if (old.getArea().getId().equals(area.getId())) {
                isNew = false;
                break;
            }
        }
        if (isNew) {
            userAreas.add(userArea);
        }
    }

    public synchronized void removeUserArea(int index) {
        UtilUserArea userArea = userAreas.remove(index);
        if (isNotNull(userArea.getId())) {
            removedUserAreas.add(userArea);
        }
    }

    public synchronized boolean saveOrUpdate() {
        Transaction transaction = userDao.newTransaction();
        //
        transaction.saveOrUpdate(user);
        //
        for (int i = 0; i < privileges.size(); i++) {
            UtilPrivilege privilege = privileges.get(i);
            if (isNull(user.getId()) || (privilege.isSelected() != privilegeSelecteds.get(i))) {
                if (privilege.isSelected()) {
                    transaction.saveOrUpdate(new UtilUserPrivilege(user, privilege));
                } else if (isNotNull(user.getId())) {
                    transaction.delete(userPrivilegeDao.getBy(user, privilege));
                }
            }
        }
        //
        transaction.saveOrUpdate(userIps).
                delete(removedUserIps).
                saveOrUpdate(userAreas).
                delete(removedUserAreas);
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
//</editor-fold>
}