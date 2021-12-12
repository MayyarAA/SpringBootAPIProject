package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.*;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return  args -> {
            Student mar  = new Student("Mar","mar@email.com",
                    LocalDate.of(1998, Month.APRIL,5),23);

        Student tom  = new Student("tom","tom@email.com",
                LocalDate.of(1988, Month.APRIL,10),33);

        studentRepository.saveAll(List.of(mar,tom));
        };

    };
}

