package model.dao.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.inv.InventoryDao;
import model.obj.inv.InvInventory;
//</editor-fold>

public class InvInventoryDao extends InventoryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return InvInventory.class;
    }
//</editor-fold>
}