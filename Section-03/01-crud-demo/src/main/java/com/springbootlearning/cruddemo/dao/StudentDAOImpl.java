package com.springbootlearning.cruddemo.dao;

import com.springbootlearning.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define field for entity manager
    private EntityManager entityManager;
    /// inject entity manager using constructor injection

    @Autowired      //optional because there's only one constructor, put here for easier to follow and read
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional  // perform update on databases and save store object on databases
    // handle the transaction management
    public void save(Student theStudent) {
        // TODO document why this method is empty
        entityManager.persist(theStudent);  //save the student in database
    }

    @Override
    public Student findById(Integer id) {
        // Student.class is the entity class
        return entityManager.find(Student.class, id);
    }
}
