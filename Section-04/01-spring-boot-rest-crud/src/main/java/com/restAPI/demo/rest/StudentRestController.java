package com.restAPI.demo.rest;

import com.restAPI.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    //define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudent() {
        // TODO document why this method is empty
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Viet", "Cu"));
        theStudents.add(new Student("Nam", "Cu"));
        return theStudents;
    }
}
