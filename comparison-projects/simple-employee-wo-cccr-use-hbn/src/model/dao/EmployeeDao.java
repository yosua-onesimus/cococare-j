package model.dao;

import java.util.List;
import model.obj.Employee;

public class EmployeeDao {

    public List<Employee> getList() {
        return Hibernate.execute("FROM Employee", null, 0, null);
    }

    public Employee getById(Long id) {
        return (Employee) Hibernate.get(Employee.class, id);
    }

    public boolean saveOrUpdate(Employee employee) {
        return Hibernate.saveOrUpdate(employee);
    }

    public boolean delete(Employee employee) {
        return Hibernate.delete(employee);
    }
}