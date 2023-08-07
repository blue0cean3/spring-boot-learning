package com.cruddemo.crudrest.service;

import java.util.List;

import com.cruddemo.crudrest.entity.Employee;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(int id);

  Employee save(Employee theEmployee);

  void deleteById(int id);
}
