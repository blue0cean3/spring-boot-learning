package com.springbootlearning.cruddemo;

import com.springbootlearning.cruddemo.dao.StudentDAO;
import com.springbootlearning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
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
			int chosen = 0;
			boolean isQuit = false;
			do {
				System.out.println("1. Create new student");
				System.out.println("2. Read the student");
				System.out.println("3. List out the Student");
				System.out.println("0. Exit");
				System.out.print("Enter the code: ");
				chosen = sc.nextInt();
				switch (chosen) {
					case 1 -> createStudent(studentDAO);
					case 2 -> readStudent(studentDAO);
					case 3 -> queryForStudents(studentDAO);
					case 0 -> {
						isQuit = true;
					}
					default -> {
						System.out.println("You enter wrong code. Please enter again: ");
					}
				}
			} while (!isQuit);
		};
	}

	public void queryForStudents(StudentDAO studentDAO) {
		int chosen = 0;
		boolean isQuit = false;
		do {
			System.out.println("1. List all of student");
			System.out.println("2. List all of student by last name");
			System.out.println("3. List out the Student");
			System.out.println("0. Exit");
			System.out.print("Enter the code: ");
			chosen = sc.nextInt();
			switch (chosen) {
				case 1 -> {
					//get the list of student
					List<Student> theStudents = studentDAO.findAll();
					//display list of students
					for (Student tempStudent : theStudents) {
						System.out.println(tempStudent);
					}
				}
				case 2 -> {
					//get the list of student
					System.out.print("Enter the last name you want to find: ");
					String name = sc.next();
					List<Student> theStudents = studentDAO.findByLastName(name);
					//display list of students
					for (Student tempStudent : theStudents) {
						System.out.println(tempStudent);
					}
				}
				case 3 -> queryForStudents(studentDAO);
				case 0 -> {
					isQuit = true;
				}
				default -> {
					System.out.println("You enter wrong code. Please enter again: ");
				}
			}
		} while (!isQuit);
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
