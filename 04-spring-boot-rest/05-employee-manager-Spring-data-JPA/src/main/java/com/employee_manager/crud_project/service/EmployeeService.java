package com.employee_manager.crud_project.service;

import com.employee_manager.crud_project.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    int delete(int id);
}
