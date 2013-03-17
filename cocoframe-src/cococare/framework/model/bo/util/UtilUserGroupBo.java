package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLogic.isNotNull;
import static cococare.common.CCLogic.isNull;
import cococare.database.CCHibernateBo;
import cococare.database.CCHibernateDao.Transaction;
import cococare.framework.model.dao.util.*;
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
public class UtilUserGroupBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //Dao
    private UtilPrivilegeDao privilegeDao;
    //
    private UtilUserGroupDao userGroupDao;
    private UtilUserGroupPrivilegeDao userGroupPrivilegeDao;
    private UtilUserGroupIpDao userGroupIpDao;
    //
    private UtilUserDao userDao;
    private UtilUserPrivilegeDao userPrivilegeDao;
    private UtilUserIpDao userIpDao;
    //Collection & Object
    private UtilUserGroup userGroup;
    //
    private List<UtilPrivilege> privileges;
    private HashMap<UtilPrivilege, Integer> privilege_index;
    private List<Boolean> privilegeSelecteds;
    //
    private List<UtilUserGroupIp> userGroupIps;
    private List<UtilUserGroupIp> removedUserGroupIps;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized void load(UtilUserGroup userGroup) {
        //
        this.userGroup = userGroup;
        //
        privileges = privilegeDao.getListUnlimited();
        privilege_index = new HashMap();
        privilegeSelecteds = isNull(userGroup.getId()) ? null : privilegeDao.getListSelectedUnlimitedBy(userGroup);
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
        userGroupIps = isNull(userGroup.getId()) ? new ArrayList() : userGroupIpDao.getListUnlimitedBy(userGroup);
        removedUserGroupIps = new ArrayList();
    }

    public synchronized List<UtilPrivilege> getPrivileges() {
        return privileges;
    }

    public synchronized int getPrivilegeIndex(UtilPrivilege privilege) {
        return parseInt(privilege_index.get(privilege));
    }

    public synchronized List<UtilUserGroupIp> getUserGroupIps() {
        return userGroupIps;
    }

    public synchronized void addUserGroupIp(String ip) {
        UtilUserGroupIp userGroupIp = userGroupIpDao.getBy(userGroup, ip);
        if (isNull(userGroupIp)) {
            userGroupIp = new UtilUserGroupIp();
            userGroupIp.setUserGroup(userGroup);
            userGroupIp.setIp(ip);
        } else {
            for (UtilUserGroupIp old : removedUserGroupIps) {
                if (old.getIp().equalsIgnoreCase(ip)) {
                    removedUserGroupIps.remove(old);
                    break;
                }
            }
        }
        boolean isNew = true;
        for (UtilUserGroupIp old : userGroupIps) {
            if (old.getIp().equalsIgnoreCase(ip)) {
                isNew = false;
                break;
            }
        }
        if (isNew) {
            userGroupIps.add(userGroupIp);
        }
    }

    public synchronized void removeUserGroupIp(int index) {
        UtilUserGroupIp userGroupIp = userGroupIps.remove(index);
        if (isNotNull(userGroupIp.getId())) {
            removedUserGroupIps.add(userGroupIp);
        }
    }

    public synchronized boolean save() {
        Transaction transaction = userGroupDao.newTransaction();
        //
        transaction.saveOrUpdate(userGroup);
        //
        for (int i = 0; i < privileges.size(); i++) {
            UtilPrivilege privilege = privileges.get(i);
            if (isNull(userGroup.getId()) || (privilege.isSelected() != privilegeSelecteds.get(i))) {
                if (privilege.isSelected()) {
                    transaction.saveOrUpdate(new UtilUserGroupPrivilege(userGroup, privilege));
                } else if (isNotNull(userGroup.getId())) {
                    transaction.delete(userGroupPrivilegeDao.getBy(userGroup, privilege));
                }
            }
        }
        //
        transaction.saveOrUpdate(userGroupIps).
                delete(removedUserGroupIps);
        //
        if (isNotNull(userGroup.getId()) && userGroup.isApplyToUser()) {
            for (UtilUser user : userDao.getListUnlimitedBy(userGroup)) {
                //
                List<Boolean> userChecks = privilegeDao.getListSelectedUnlimitedBy(user);
                for (int i = 0; i < privileges.size(); i++) {
                    UtilPrivilege privilege = privileges.get(i);
                    if (privilege.isSelected() != userChecks.get(i)) {
                        if (privilege.isSelected()) {
                            transaction.saveOrUpdate(new UtilUserPrivilege(user, privilege));
                        } else {
                            transaction.delete(userPrivilegeDao.getBy(user, privilege));
                        }
                    }
                }
                //
                for (UtilUserGroupIp userGroupIp : userGroupIps) {
                    UtilUserIp userIp = userIpDao.getBy(user, userGroupIp.getIp());
                    if (isNotNull(userIp)) {
                        userIp = new UtilUserIp();
                        userIp.setUser(user);
                        userIp.setIp(userGroupIp.getIp());
                        transaction.saveOrUpdate(userIp);
                    }
                }
            }
        }
        return transaction.execute();
    }
//</editor-fold>
}