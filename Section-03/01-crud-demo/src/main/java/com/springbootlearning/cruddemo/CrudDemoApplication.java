package com.springbootlearning.cruddemo;

import com.springbootlearning.cruddemo.dao.StudentDAO;
import com.springbootlearning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class CrudDemoApplication {

	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("1. Create new student");
			System.out.println("2. Read the student");
			System.out.print("Enter the code: ");
			int chosen = 0;
			boolean isQuit = false;
			do {
				chosen = sc.nextInt();
				switch (chosen) {
					case 1 -> createStudent(studentDAO);
					case 2 -> readStudent(studentDAO);
					default -> {
						System.out.println("You enter wrong code. Please enter again: ");
						chosen = 0;
					}
				}
				if (chosen == 0) isQuit = true;
			} while (!isQuit);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.print("Enter the id of student to find: ");
		int theID = sc.nextInt();
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id " + theID);
		Student myStudent = studentDAO.findById(theID);
		// display student
		System.out.println("Found the student " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		boolean isQuit = false;
		do {
			//create the student object
			System.out.println("Creating new student object... ");
			System.out.print("First name: ");
			String firstName = sc.nextLine();
			System.out.print("\nLast name: ");
			String lastName = sc.nextLine();
			System.out.print("\nEmail: ");
			String email = sc.nextLine();
			System.out.println();
			Student tempStudent = new Student(firstName, lastName, email);
			//save the student object
			System.out.println("Saving the student...");
			studentDAO.save(tempStudent);
			//display id of saved student
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			System.out.print("Continue entering student (Y or N): ");
			String temp = sc.next();
			if (temp.equalsIgnoreCase("Y")) isQuit = false;
			else isQuit = true;
		} while (!isQuit);
	}
}
