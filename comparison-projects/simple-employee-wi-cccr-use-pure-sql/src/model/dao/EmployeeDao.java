package model.dao;

import cococare.database.CCDatabase;
import cococare.database.CCDatabaseDao;
import console.Main;
import model.obj.Employee;

public class EmployeeDao extends CCDatabaseDao {

    @Override
    protected CCDatabase getCCDatabase() {
        return Main.DATABASE;
    }

    @Override
    protected Class getEntity() {
        return Employee.class;
    }
}