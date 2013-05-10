package model.dao;

import cococare.database.CCHibernate;
import cococare.database.CCHibernateDao;
import console.Main;
import model.obj.Employee;

public class EmployeeDao extends CCHibernateDao {

    @Override
    protected CCHibernate getCCHibernate() {
        return Main.HIBERNATE;
    }

    @Override
    protected Class getEntity() {
        return Employee.class;
    }
}