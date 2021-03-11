package com.example.demo.configuration;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student nicko = new Student(1L,
                    "nicko",
                    "nicko.putra@mail.com",
                    LocalDate.of(2020, Month.JANUARY, 04));
            Student putra = new Student(2L,
                    "putra",
                    "putra@mail.com",
                    LocalDate.of(2020, Month.JANUARY, 04));

            repository.saveAll(List.of(nicko, putra));
        };
    }
}
