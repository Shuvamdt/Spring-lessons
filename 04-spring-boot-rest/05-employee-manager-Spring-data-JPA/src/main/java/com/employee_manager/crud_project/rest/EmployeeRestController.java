package com.employee_manager.crud_project.rest;


import com.employee_manager.crud_project.entity.Employee;
import com.employee_manager.crud_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService service;
    private JsonMapper jsonMapper;
    @Autowired
    public EmployeeRestController(EmployeeService service, JsonMapper jsonMapper){
        this.service=service;
        this.jsonMapper=jsonMapper;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee emp = service.findById(employeeId);
        if(emp == null){
            throw new RuntimeException("Employee not found for id: "+employeeId);
        }
        return emp;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp){
        if(emp == null){
            throw new RuntimeException("Employee not found");
        }
        emp.setId(0);
        return service.save(emp);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp){
        if(emp == null){
            throw new RuntimeException("Employee not found");
        }
        return service.save(emp);

    }
    @PatchMapping("/employees/{employeeId}")
    public Employee partialUpdateEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload){
        Employee emp = service.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Employee not found for id: "+employeeId);
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id is not allowed to change");
        }
        Employee updatedEmp = jsonMapper.updateValue(emp, patchPayload);
        return service.save(updatedEmp);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee emp = service.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Employee not found for id: "+employeeId);
        }
        return "Deleted employee id: "+ service.delete(employeeId);
    }
}
