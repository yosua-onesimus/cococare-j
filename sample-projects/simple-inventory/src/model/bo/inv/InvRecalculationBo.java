package model.bo.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.ArrayList;
import java.util.List;
import model.dao.inv.InvOwnershipDao;
import model.obj.inv.InvEmployee;
import model.obj.inv.InvInventory;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class InvRecalculationBo extends CCHibernateBo {

    private InvOwnershipDao ownershipDao;

    public synchronized InvInventory recalcInventory(InvInventory inventory) {
        if (inventory.getId() != null) {
            inventory.setQuantityUsed(ownershipDao.getQuantityUsed(inventory));
            inventory.setQuantityAvailable(inventory.getQuantityTotal() - inventory.getQuantityUsed());
        }
        return inventory;
    }

    public synchronized List<InvInventory> recalcInventory(InvEmployee employee, List<InvOwnership> ownerships, List<InvOwnership> removedOwnerships) {
        List<InvInventory> inventorys = new ArrayList();
        for (InvOwnership ownership : ownerships) {
            InvInventory inventory = ownership.getInventory();
            if (!inventorys.contains(inventory)) {
                inventory.setQuantityUsed(
                        employee.getId() == null
                        ? ownershipDao.getQuantityUsed(inventory)
                        : ownershipDao.getQuantityUsedExceptEmployee(inventory, employee));
                inventorys.add(inventory);
            }
            inventory.setQuantityUsed(inventory.getQuantityUsed() + 1);
            inventory.setQuantityAvailable(inventory.getQuantityTotal() - inventory.getQuantityUsed());
        }
        for (InvOwnership ownership : removedOwnerships) {
            InvInventory inventory = ownership.getInventory();
            if (!inventorys.contains(inventory)) {
                inventory.setQuantityUsed(
                        employee.getId() == null
                        ? ownershipDao.getQuantityUsed(inventory)
                        : ownershipDao.getQuantityUsedExceptEmployee(inventory, employee));
                inventorys.add(inventory);
            }
            inventory.setQuantityAvailable(inventory.getQuantityTotal() - inventory.getQuantityUsed());
        }
        return inventorys;
    }
}