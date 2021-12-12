package com.example.demo.student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student("Mar","mar@email.com", LocalDate.of(1998, Month.APRIL,5),23));
        return list;
    }
}
