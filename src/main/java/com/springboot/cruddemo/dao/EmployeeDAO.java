package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void saveEmployee(Employee employee);

    public void DeleteEmployee(int theId);
}
