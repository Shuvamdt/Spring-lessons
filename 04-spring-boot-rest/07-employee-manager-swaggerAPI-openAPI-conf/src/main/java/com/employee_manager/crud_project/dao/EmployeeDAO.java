package com.employee_manager.crud_project.dao;

import com.employee_manager.crud_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    List<Employee> findByFirstName(String firstNAme);
    int delete(int id);
    int deleteAll();
}
