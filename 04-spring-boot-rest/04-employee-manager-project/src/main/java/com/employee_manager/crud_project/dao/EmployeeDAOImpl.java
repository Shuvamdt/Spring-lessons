package com.employee_manager.crud_project.dao;

import com.employee_manager.crud_project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> tq = entityManager.createQuery("FROM Employee", Employee.class);
        return tq.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findByFirstName(String firstNAme) {
        TypedQuery<Employee> tq = entityManager.createQuery("FROM Employee WHERE firstName LIKE :firstName", Employee.class);
        tq.setParameter("firstName", firstNAme);
        return tq.getResultList();
    }

    @Override
    public int delete(int id) {
        Employee currEmp = entityManager.find(Employee.class, id);
        entityManager.remove(currEmp);
        return id;
    }
    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Employee").executeUpdate();
    }
}
