package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping()
    public List<Student> index(){
        return List.of(new Student(1L,
                "nicko",
                "nicko.putra@mail.com",
                LocalDate.of(2020,03,04),
                20));
    }
}
