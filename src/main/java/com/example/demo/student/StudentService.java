package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
public class StudentService {
    private  final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //the JPA class we inherited from contains all the CRUD methods to the DB
    public List<Student> getStudents(){
//        List<Student> list = new ArrayList<>();
//        list.add(new Student("Mar","mar@email.com", LocalDate.of(1998, Month.APRIL,5),23));
//        return list;
        return studentRepository.findAll();
    }
}
