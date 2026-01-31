package com.shuvam.crud_demo.dao;

import com.shuvam.crud_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
