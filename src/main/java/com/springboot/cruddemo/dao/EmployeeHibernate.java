package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class EmployeeHibernate implements EmployeeDAO {

    //define entity manager
    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Employee> findAll() {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create Query
        Query theQuery = currentSession.createQuery("from Employee", Employee.class);

        //execute quarry
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save or update Employee
        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void DeleteEmployee(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object by primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=: employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();


    }


}
