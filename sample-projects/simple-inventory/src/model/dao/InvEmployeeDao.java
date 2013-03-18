package model.dao;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.InventoryDao;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class InvEmployeeDao extends InventoryDao {

    @Override
    protected Class getEntity() {
        return InvEmployee.class;
    }
}