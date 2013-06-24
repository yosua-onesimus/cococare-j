package model.dao.bljr;

import model.mdl.bljr.BljrDao;
import model.obj.bljr.Employee;

public class EmployeeDao extends BljrDao {

    @Override
    protected Class getEntity() {
        return Employee.class;
    }
}