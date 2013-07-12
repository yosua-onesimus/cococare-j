package model.bo.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.isNotNull;
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.inv.InvOwnershipDao;
import model.obj.inv.InvInventory;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class InvRecalculationBo extends CCHibernateBo {

    private InvOwnershipDao ownershipDao;

    public synchronized InvInventory recalcInventory(InvInventory inventory) {
        if (isNotNull(inventory.getId())) {
            inventory.setQuantityUsed(ownershipDao.getQuantityUsed(inventory));
            inventory.setQuantityAvailable(inventory.getQuantityTotal() - inventory.getQuantityUsed());
        }
        return inventory;
    }

    public synchronized List<InvOwnership> recalcInventory(List<InvOwnership> ownerships) {
        for (InvOwnership ownership : ownerships) {
            recalcInventory(ownership.getInventory());
        }
        return ownerships;
    }
}