package com.cruddemo.crudrest.dao;

import java.util.List;

import com.cruddemo.crudrest.entity.Employee;

public interface EmployeeDAO {

  List<Employee> findAll();

  Employee findById(int id);

  Employee save(Employee theEmployee);

  void deleteById(int id);
}
