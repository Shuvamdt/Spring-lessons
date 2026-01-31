package com.shuvam.crud_demo;

import com.shuvam.crud_demo.entity.Student;
import com.shuvam.crud_demo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
	}
	public void createStudent(StudentDAO dao){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student first name, last name, email ");
		String fName = sc.next();
		String lName = sc.next();
		String email = sc.next();
		Student s = new Student(fName, lName, email);
		dao.save(s);
		System.out.println("Saved student :"+s.getId());
	}
}
