package com.springbootlearning.cruddemo.dao;

import com.springbootlearning.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.zip.ZipEntry;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //define field for entity manager
    private final EntityManager entityManager;
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

    @Override

    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc ", Student.class);
        // FROM Student: JPQL syntax (Student) is entity name and entity field not database name
        // order by "entity name" desc or asc will sort by desc or asc (default is ascending)
//        ascending: A - Z
//        decending: Z - A
        //return query result
        return theQuery.getResultList();


    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query by last name
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);
        // JPQL Named Parameters are prefixed with a colon( : ) here is :theData. It works like a placeholder that is filled later

        //set the query parameters

        theQuery.setParameter("theData", theLastName);
        //return query results
        return theQuery.getResultList();
    }
}
