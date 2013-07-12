package model.dao.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import java.util.List;
import model.mdl.inv.InventoryDao;
import model.obj.inv.InvEmployee;
import model.obj.inv.InvInventory;
import model.obj.inv.InvOwnership;
//</editor-fold>

public class InvOwnershipDao extends InventoryDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return InvOwnership.class;
    }
//</editor-fold>

    public int getQuantityUsed(InvInventory inventory) {
        hql.start().
                select("COUNT(*)").
                where("inventory = :inventory");
        parameters.start().
                set("inventory", inventory);
        return CCFormat.parseInt(getBy(hql.value(), parameters.value()));
    }

    public int getQuantityUsedExceptEmployee(InvInventory inventory, InvEmployee employee) {
        hql.start().
                select("COUNT(*)").
                where("inventory = :inventory").
                where("employee != :employee");
        parameters.start().
                set("inventory", inventory).
                set("employee", employee);
        return CCFormat.parseInt(getBy(hql.value(), parameters.value()));
    }

    public InvOwnership getBy(InvEmployee employee, InvInventory inventory) {
        hql.start().
                where("employee = :employee").
                where("inventory = :inventory");
        parameters.start().
                set("employee", employee).
                set("inventory", inventory);
        return (InvOwnership) getBy(hql.value(), parameters.value());
    }

    public List<InvOwnership> getListUnlimitedBy(InvEmployee employee) {
        hql.start().
                where("employee = :employee");
        parameters.start().
                set("employee", employee);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }
}