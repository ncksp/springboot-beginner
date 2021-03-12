package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private boolean checkEmailExist(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

        return studentOptional.isPresent();
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void store(Student student) {
        if (checkEmailExist(student.getEmail()))
            throw new IllegalStateException("Email already exist");

        studentRepository.save(student);
    }

    public void destroy(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("Student with id %d not found!", id)
        ));

        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(
            String.format("Student with id %d not found!", id)
        ));

        if(name != null && name.length() > 0 && !name.equals(student.getName()))
            student.setName(name);

        if (email == null || email.length() == 0 || email.equals(student.getEmail()))
            return;

        if (checkEmailExist(student.getEmail()))
            throw new IllegalStateException("Email already exist");

        student.setEmail(email);
    }
}
