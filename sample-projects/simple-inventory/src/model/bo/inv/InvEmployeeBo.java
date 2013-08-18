package model.bo.inv;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.inv.InvEmployeeDao;
import model.obj.inv.InvEmployee;
//</editor-fold>

public class InvEmployeeBo extends CCHibernateBo {

    //Bo
    private InvRecalculationBo recalculationBo = new InvRecalculationBo();
    //Dao
    private InvEmployeeDao employeeDao;

    public synchronized boolean saveOrUpdate(InvEmployee employee, List employeeChilds) {
        return employeeDao.newTransaction().start().
                saveOrUpdate(employee).
                saveOrUpdate(employeeChilds).
                execute()
                && employeeDao.saveOrUpdate(recalculationBo.recalcInventory(employeeChilds));
    }
}