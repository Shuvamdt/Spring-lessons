package com.shuvam.crud_demo.dao;

import com.shuvam.crud_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAllStudents();
    List<Student> findByLastName(String lastName);
    void updateStudentDB(Student s);
    void deleteStudent(Integer id);
    void updateAll();
    void deleteAllSelected(String lastName);
    void deleteAll();
}
