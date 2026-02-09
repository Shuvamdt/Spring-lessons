package com.employee_manager.crud_project.dao;

import com.employee_manager.crud_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
