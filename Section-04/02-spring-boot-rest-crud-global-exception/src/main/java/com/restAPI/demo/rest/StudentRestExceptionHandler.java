package com.restAPI.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
  // add exception handler code here

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