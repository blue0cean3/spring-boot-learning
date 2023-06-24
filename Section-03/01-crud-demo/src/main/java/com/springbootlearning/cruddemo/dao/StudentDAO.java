package com.springbootlearning.cruddemo.dao;

import com.springbootlearning.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
