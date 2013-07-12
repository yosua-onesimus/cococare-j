package model.dao.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.inv.InventoryDao;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class InvEmployeeDao extends InventoryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return InvEmployee.class;
    }
//</editor-fold>
}