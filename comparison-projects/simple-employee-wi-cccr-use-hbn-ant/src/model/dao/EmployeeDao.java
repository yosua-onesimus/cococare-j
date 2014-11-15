package model.dao;

import cococare.database.CCHibernate;
import cococare.database.CCHibernateDao;
import cococare.database.CCHibernateFilter;
import console.Main;
import java.util.ArrayList;
import java.util.List;
import model.obj.Employee;

public class EmployeeDao extends CCHibernateDao {

    @Override
    protected CCHibernate getCCHibernate() {
        return Main.HIBERNATE;
    }

    @Override
    protected List<CCHibernateFilter> getFilters() {
        return new ArrayList();
    }

    @Override
    protected Class getEntity() {
        return Employee.class;
    }
}