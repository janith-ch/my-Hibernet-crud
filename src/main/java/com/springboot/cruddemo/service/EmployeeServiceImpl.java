package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void SaveEmployee(Employee theEmployee) {
        employeeDAO.saveEmployee(theEmployee);

    }

    @Override
    @Transactional
    public void DeleteEmployee(int theId) {
        employeeDAO.DeleteEmployee(theId);

    }
}
