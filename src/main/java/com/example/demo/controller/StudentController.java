package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> index(){
        return studentService.getStudents();
    }
    
    @PostMapping()
    public void store(@RequestBody Student student){
        studentService.store(student);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) String email){
        studentService.update(id, name, email);
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable("id") Long id){
        studentService.destroy(id);
    }
    
}
