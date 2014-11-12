package cococare.framework.model.bo.util;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getAssociativeArray;
import static cococare.common.CCClass.getListByAssociativeArray;
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLogic.*;
import cococare.database.CCEntityBo;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
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
    //
    private List<Class> utilAdditionalTabClass;
    //
    private UtilPrivilegeDao privilegeDao;
    private UtilUserGroupDao userGroupDao;
    private UtilUserGroupPrivilegeDao userGroupPrivilegeDao;
    private UtilUserGroupIpDao userGroupIpDao;
    private UtilUserGroupChildDao userGroupChildDao;
    private UtilUserDao userDao;
    private UtilUserPrivilegeDao userPrivilegeDao;
    private UtilUserIpDao userIpDao;
    private UtilUserChildDao userChildDao;
    //
    private UtilUserGroup userGroup;
    private List<UtilPrivilege> privileges;
    private HashMap<UtilPrivilege, Integer> privilege_index;
    private List<Boolean> privilegeSelecteds;
    private List<UtilUserGroupIp> userGroupIps;
    private List<UtilUserGroupIp> removedUserGroupIps;
    private HashMap<Class, List> clazz_child;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized void load(UtilUserGroup userGroup) {
        //
        utilAdditionalTabClass = new UtilConfigBo().loadConfAppl().getUtilAdditionalTabClass();
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
        clazz_child = new HashMap();
        for (Class clazz : utilAdditionalTabClass) {
            clazz_child.put(clazz, isNull(userGroup.getId()) ? new ArrayList() : getListByAssociativeArray(clazz, userGroupChildDao.getBy(userGroup, clazz).getAssociativeArray()));
        }
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
        UtilUserGroupIp userGroupIp = coalesce(isNull(userGroup.getId()) ? null : userGroupIpDao.getBy(userGroup, ip), new UtilUserGroupIp(userGroup, ip));
        if (isNotNull(userGroupIp.getId())) {
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

    private synchronized void _applyToUser(Transaction transaction, UtilUser user, List<UtilPrivilege> privileges, List<UtilUserGroupIp> userGroupIps, List<UtilUserGroupIp> removedUserGroupIps, HashMap<Class, List> clazz_child) {
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
            if (isNull(userIpDao.getBy(user, userGroupIp.getIp()))) {
                transaction.saveOrUpdate(new UtilUserIp(user, userGroupIp.getIp()));
            }
        }
        //
        for (UtilUserGroupIp userGroupIp : removedUserGroupIps) {
            UtilUserIp userIp = userIpDao.getBy(user, userGroupIp.getIp());
            if (isNotNull(userIp)) {
                transaction.delete(userIp);
            }
        }
        //
        for (Class clazz : clazz_child.keySet()) {
            UtilUserChild userChild = userChildDao.getBy(user, clazz);
            userChild.setAssociativeArray(getAssociativeArray(clazz_child.get(clazz)));
            transaction.saveOrUpdate(userChild);
        }
    }

    public synchronized boolean saveOrUpdate() {
        Transaction transaction = userGroupDao.newTransaction();
        //
        transaction.saveOrUpdate(userGroup);
        //
        for (int i = 0; i < privileges.size(); i++) {
            UtilPrivilege privilege = privileges.get(i);
            if (isNull(privilegeSelecteds) || (privilegeSelecteds.get(i) != privilege.isSelected())) {
                if (privilege.isSelected()) {
                    transaction.saveOrUpdate(new UtilUserGroupPrivilege(userGroup, privilege));
                } else if (isNotNull(privilegeSelecteds)) {
                    transaction.delete(userGroupPrivilegeDao.getBy(userGroup, privilege));
                }
            }
        }
        //
        transaction.saveOrUpdate(userGroupIps).
                delete(removedUserGroupIps);
        //
        for (Class clazz : clazz_child.keySet()) {
            UtilUserGroupChild userGroupChild = userGroupChildDao.getBy(userGroup, clazz);
            userGroupChild.setAssociativeArray(getAssociativeArray(clazz_child.get(clazz)));
            transaction.saveOrUpdate(userGroupChild);
        }
        //
        if (userGroup.isApplyToUser()) {
            for (UtilUser user : userDao.getListUnlimitedBy(userGroup)) {
                _applyToUser(transaction, user, privileges, userGroupIps, removedUserGroupIps, clazz_child);
            }
        }
        return transaction.execute();
    }

    /**
     *
     * Save or update user and apply user group configuration to user.
     *
     * @param transaction the transaction.
     * @param user the user.
     */
    public synchronized void saveOrUpdate(Transaction transaction, UtilUser user) {
        load(user.getUserGroup());
        transaction.saveOrUpdate(user);
        _applyToUser(transaction, user, privileges, userGroupIps, removedUserGroupIps, clazz_child);
    }
//</editor-fold>
}