package com.cruddemo.crudrest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cruddemo.crudrest.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  // define field for entitymanager
  private EntityManager entityManager;

  public EmployeeDAOImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public List<Employee> findAll() {

    // create a query
    TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

    // execute query and get the result list
    List<Employee> employees = theQuery.getResultList();

    // return the result list
    return employees;

  }

  @Override
  public Employee findById(int id) {

    // get employee
    Employee theEmployee = entityManager.find(Employee.class, id);

    // return employee
    return theEmployee;

  }

  @Override
  public Employee save(Employee theEmployee) {

    // save employee
    Employee dbEmployee = entityManager.merge(theEmployee);

    // return employee
    return dbEmployee;
  }

  @Override
  public void deleteById(int id) {

    // delete employee by id
    Employee theEmployee = entityManager.find(Employee.class, id);

    // remove employee
    entityManager.remove(theEmployee);
  }

}