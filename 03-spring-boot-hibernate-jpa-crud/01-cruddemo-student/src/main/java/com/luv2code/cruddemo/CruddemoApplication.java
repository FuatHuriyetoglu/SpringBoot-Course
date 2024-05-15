package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDao){
		return  runner -> {
			createMultipleStudent(studentDao);
			//createStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudent(studentDao);
			//queryForStudentByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudents(studentDao);

		};
	}

	private void deleteAllStudents(StudentDAO studentDao) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDao) {
		int studentId = 4;
		System.out.println("Deleting student id: " +studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDao) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDao.findById(studentId);
		// change first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");
		//update the student
		studentDao.update(myStudent);
		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findByLastName("Walker");
		// display list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDao) {
		//get a list of students
		List<Student> theStudents = studentDao.FindAll();

		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDao) {
		//create a student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("a","a", "a");
		//save the student
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generate id:" +
				"   " + theId);
		// retrieve  student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDao.findById(theId);
		// display student
		System.out.println("Found the student" + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDao) {
		//create multiple students
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("john","Walker","john@luv2code");
		Student tempStudent2 = new Student("jack","hoca","jack@luv2code");
		Student tempStudent3 = new Student("alex","Walker","alex@luv2code");

		//save the student objects
		System.out.println("Saving the studens...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDao) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Walker","paul@luv2code");
		// save the student object
		System.out.println("saving the student...");
		studentDao.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. Generated id "+ tempStudent.getId());
	}

}
