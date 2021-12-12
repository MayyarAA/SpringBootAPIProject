package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity registerNewStudent(@RequestBody Student student){
        try{
            studentService.addNewStudent(student);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(IllegalStateException e){
            System.out.println("error from registerNewStudent");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error from registerNewStudent");
        }
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity deleteStudent(@PathVariable("studentId")Long studentId){
        try{
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(IllegalStateException error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error from deleteStudent");
        }
    }
}
