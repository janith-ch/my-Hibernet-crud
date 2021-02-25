package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void SaveEmployee(Employee theEmployee);

    public void DeleteEmployee(int theId);




}
