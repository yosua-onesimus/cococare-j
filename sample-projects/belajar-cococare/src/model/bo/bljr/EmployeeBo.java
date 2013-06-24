package model.bo.bljr;

import cococare.database.CCHibernateBo;
import model.dao.bljr.EmployeeDao;
import model.obj.bljr.Employee;

public class EmployeeBo extends CCHibernateBo {

    private EmployeeDao employeeDao;

    public synchronized boolean saveOrUpdate(Employee employee) {
        return employeeDao.saveOrUpdate(employee);
    }
}