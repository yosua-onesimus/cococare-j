package model.bo.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import cococare.database.CCHibernateDao.Transaction;
import java.util.ArrayList;
import java.util.List;
import model.dao.inv.InvEmployeeDao;
import model.dao.inv.InvOwnershipDao;
import model.obj.inv.InvEmployee;
import model.obj.inv.InvInventory;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class InvEmployeeBo extends CCHibernateBo {

    //Bo
    private InvRecalculationBo recalculationBo = new InvRecalculationBo();
    //Dao
    private InvEmployeeDao employeeDao;
    private InvOwnershipDao ownershipDao;
    //Collection & Object
    private InvEmployee employee;
    //
    private List<InvOwnership> ownerships;
    private List<InvOwnership> removedOwnerships;

    public synchronized void load(InvEmployee employee) {
        //
        this.employee = employee;
        //
        ownerships = employee.getId() == null ? new ArrayList() : ownershipDao.getListUnlimitedBy(employee);
        removedOwnerships = new ArrayList();
    }

    public synchronized List<InvOwnership> getOwnerships() {
        return ownerships;
    }

    public synchronized void addOwnership(InvInventory inventory) {
        InvOwnership ownership = ownershipDao.getBy(employee, inventory);
        if (ownership == null) {
            ownership = new InvOwnership();
            ownership.setEmployee(employee);
            ownership.setInventory(inventory);
        } else {
            for (InvOwnership old : removedOwnerships) {
                if (old.getInventory().getCode().equalsIgnoreCase(inventory.getCode())) {
                    removedOwnerships.remove(old);
                    break;
                }
            }
        }
        boolean isNew = true;
        for (InvOwnership old : ownerships) {
            if (old.getInventory().getCode().equalsIgnoreCase(inventory.getCode())) {
                isNew = false;
                break;
            }
        }
        if (isNew) {
            ownerships.add(ownership);
        }
    }

    public synchronized void removeOwnership(int index) {
        InvOwnership ownership = ownerships.remove(index);
        if (ownership.getId() != null) {
            removedOwnerships.add(ownership);
        }
    }

    public synchronized boolean save() {
        Transaction transaction = employeeDao.newTransaction();
        //
        transaction.saveOrUpdate(employee).
                saveOrUpdate(recalculationBo.recalcInventory(employee, ownerships, removedOwnerships)).
                saveOrUpdate(ownerships).
                delete(removedOwnerships);
        //
        return transaction.execute();
    }
}