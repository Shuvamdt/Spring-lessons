package com.employee_manager.crud_project.service;


import com.employee_manager.crud_project.dao.EmployeeDAO;
import com.employee_manager.crud_project.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    @Override
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        return employeeDAO.findByFirstName(firstName);
    }

    @Override
    @Transactional
    public Employee save(Employee emp){
        return employeeDAO.save(emp);
    }

    @Override
    @Transactional
    public int delete(int id) {
        return employeeDAO.delete(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return employeeDAO.deleteAll();
    }
}
