package com.cruddemo.crudrest.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruddemo.crudrest.entity.Employee;
import com.cruddemo.crudrest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  public EmployeeRestController(EmployeeService theEmployeeService) {
    employeeService = theEmployeeService;
  }

  // add mapping for GET requests
  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable int id) {
    Employee theEmployee = employeeService.findById(id);
    if (theEmployee == null) {
      throw new RuntimeException("Employee not found");
    }
    return theEmployee;
  }

  // add mapping for POST requests /employees - add new employee
  @PostMapping("/employees")
  public Employee saveEmployee(@RequestBody Employee theEmployee) {
    // in case they pass an id in JSON set id to 0
    // force a new item instead of creating new one

    theEmployee.setEmployeeID(0);
    Employee dbEmployee = employeeService.save(theEmployee);
    return dbEmployee;
  }
}
