package com.restAPI.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  // define endpoint for "/students" - return a list of students

  private List<Student> theStudents;

  @PostConstruct
  public void LoadData() {

    theStudents = new ArrayList<>();

    theStudents.add(new Student("Viet", "Cu"));
    theStudents.add(new Student("Nam", "Cu"));
  }

  @GetMapping("/students")
  public List<Student> getStudent() {
    // TODO document why this method is empty

    return theStudents;
  }

  // define endpoint for "students/{studentID}" - return student at
  // index
  @GetMapping("/students/{studentID}")
  public Student getStudent(@PathVariable int studentID) {
    // TODO document why this method is empty

    // just index into the list

    // check student ID against the list size
    if (studentID >= theStudents.size() || studentID < 0) {
      throw new StudentNotFoundException("StudentID not found in the list "
          + studentID);
    }
    return theStudents.get(studentID);
  }

  // Add an exception handler using @ExceptionHandler
  @ExceptionHandler
  // exception handler method <type of the response body> (exception
  // type to handle / catch exceptions)
  public ResponseEntity<StudentErrorResponse> handleException(
      StudentNotFoundException e) {

    // create a StudentErrorResponse

    StudentErrorResponse errorResponse = new StudentErrorResponse();

    errorResponse.setMessage(e.getMessage());
    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    errorResponse.setTimestamp(System.currentTimeMillis());

    // return the errorResponse
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  // add exception handler to catch any exceptions ( catch all
  // exceptions)
  @ExceptionHandler(Exception.class)
  public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

    // create a StudentErrorResponse

    StudentErrorResponse errorResponse = new StudentErrorResponse();

    errorResponse.setMessage("You enter other than number.");
    errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    errorResponse.setTimestamp(System.currentTimeMillis());

    // return the errorResponse
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
