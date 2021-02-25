package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import com.springboot.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {

    @Autowired
    private EmployeeService employeeServiceImpl;

    @GetMapping("/")
    public List<Employee> findAll() {
        return employeeServiceImpl.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID) {
        Employee theEmployee = employeeServiceImpl.findById(employeeID);
        if (theEmployee == null) {

            throw new RuntimeException("Employee Id not found " + employeeID);
        }
        return theEmployee;

    }

    @PostMapping("/employees")
    public Employee AddEmployee(@RequestBody Employee theEmployee) {

        //we needs to set id = 0 cause programme will auto generate Id
        theEmployee.setId(0);
        employeeServiceImpl.SaveEmployee(theEmployee);
        return (theEmployee);
    }

    @PutMapping("/employees")
    public Employee UpdateEmployee(@RequestBody Employee theEmployee) {

        employeeServiceImpl.SaveEmployee(theEmployee);
        return theEmployee;

    }

    @DeleteMapping("/employee/{employeeId}")
    public String DeleteEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeServiceImpl.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found:" + employeeId);
        }
        employeeServiceImpl.DeleteEmployee(employeeId);
        return "delete employee id " + employeeId;

    }


}
