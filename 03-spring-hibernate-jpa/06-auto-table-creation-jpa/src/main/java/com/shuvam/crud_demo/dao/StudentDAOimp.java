package com.shuvam.crud_demo.dao;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shuvam.crud_demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public class StudentDAOimp implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOimp(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }
    @Override
    public List<Student> findAllStudents(){
        TypedQuery<Student> tq = entityManager.createQuery("FROM Student", Student.class);
        return tq.getResultList();
    }
    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> tq = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);
        tq.setParameter("lastName" ,lastName);
        return tq.getResultList();
    }
    @Override
    @Transactional
    public void updateStudentDB(Student s){
        entityManager.merge(s);
    }
    @Override
    @Transactional
    public void deleteStudent(Integer id){
        Student s = findById(id);
        entityManager.remove(s);
    }

    @Override
    @Transactional
    public void updateAll() {
        int numRows = entityManager.createQuery("UPDATE Student SET lastName='Dutta'").executeUpdate();
        System.out.println("No of rows changed: "+numRows);
    }

    @Override
    @Transactional
    public void deleteAllSelected(String lastName) {
        int numRows = entityManager.createQuery("DELETE FROM Student WHERE lastName=:lastName").setParameter("lastName", lastName).executeUpdate();
        System.out.println("No of rows changed: "+numRows);
    }

    @Override
    @Transactional
    public void deleteAll() {
        int numRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("No of rows changed: "+numRows);
    }
}
