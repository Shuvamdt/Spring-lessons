package com.shuvam.REST.restController;


import com.shuvam.REST.Entity.Student;
import com.shuvam.REST.Exceptions.StudentErrorResponse;
import com.shuvam.REST.Exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> list;
    @PostConstruct
    public void loadData(){
        list = new ArrayList<>();
        list.add(new Student("Shuvam", "Dutta"));
        list.add(new Student("Sneha", "Pal"));
        list.add(new Student("Surajit", "Maji"));
        list.add(new Student("Ribhu", "Mitra"));
        list.add(new Student("Snehashish", "Laha"));
        list.add(new Student("Krishnendu", "Mukherjee"));
    }
    @GetMapping("/student")
    public List<Student> getStudents(){
        return list;
    }
    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId >= list.size() || studentId < 0){
            throw new StudentNotFoundException("Student not found : "+studentId);
        }
        return list.get(studentId);
    }
}
