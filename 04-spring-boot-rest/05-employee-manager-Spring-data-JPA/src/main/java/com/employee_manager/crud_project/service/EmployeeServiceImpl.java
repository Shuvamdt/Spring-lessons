package com.employee_manager.crud_project.service;



import com.employee_manager.crud_project.dao.EmployeeRepository;
import com.employee_manager.crud_project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> opt = employeeRepository.findById(id);
        Employee emp = null;
        if(opt.isPresent()){
            emp = opt.get();
        }else{
            throw new RuntimeException("Employee not found!");
        }
        return emp;
    }

    @Override
    public Employee save(Employee emp){
        return employeeRepository.save(emp);
    }

    @Override
    public int delete(int id) {
        Optional<Employee> opt = employeeRepository.findById(id);
        Employee emp = null;
        if(opt.isPresent()){
            emp = opt.get();
        }else{
            throw new RuntimeException("Employee not found!");
        }
        employeeRepository.delete(emp);
        return emp.getId();
    }
}
