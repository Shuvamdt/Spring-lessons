package com.shuvam.crud_demo;

import com.shuvam.crud_demo.entity.Student;
import com.shuvam.crud_demo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO dao){
		return runner ->{
			createStudent(dao);
//			readStudent(dao);
//			getAllStudents(dao);
//			getByLastName(dao);
//			updateStudent(dao);
//			updateAll(dao);
//			deleteStudent(dao);
//			deleteAll(dao);
//			deleteAllSelected(dao);
		};
	}
	private void createStudent(StudentDAO dao){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student first name, last name, email ");
		String fName = sc.next();
		String lName = sc.next();
		String email = sc.next();
		Student s = new Student(fName, lName, email);
		dao.save(s);
		System.out.println("Saved student :"+s.getId());
	}
	private void readStudent(StudentDAO dao){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the student");
		Student std = dao.findById(sc.nextInt());
		System.out.println(std.toString());
	}
	private void getAllStudents(StudentDAO dao){
		List<Student> list = dao.findAllStudents();
		for(Student s: list){
			System.out.println(s.toString());
		}
	}
	private void getByLastName(StudentDAO dao){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the last name: ");
		String lastName = sc.next();
		List<Student> list = dao.findByLastName(lastName);
		for(Student s: list){
			System.out.println(s.toString());
		}
	}
	private void updateStudent(StudentDAO dao){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id");
		Student std = dao.findById(sc.nextInt());
		System.out.println("Enter the first name");
		std.setFirstName(sc.next());
		dao.updateStudentDB(std);
	}
	private void deleteStudent(StudentDAO dao){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to delete: ");
		dao.deleteStudent(sc.nextInt());
	}
	private void updateAll(StudentDAO dao){
		dao.updateAll();
	}
	private void deleteAll(StudentDAO dao){
		dao.deleteAll();
	}
	private void deleteAllSelected(StudentDAO dao){
		dao.deleteAllSelected("Laha");
	}
}
