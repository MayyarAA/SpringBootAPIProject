package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.List;

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

    public void addNewStudent(Student student) throws IllegalStateException{
        Optional<Student> studentByEmailResult = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmailResult.isPresent()) throw new IllegalStateException(" Error: email already taken");
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) throws IllegalStateException{
        if(!(studentRepository.existsById(studentId))) throw new IllegalStateException("Error: student does not exist");
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateUserNameAndEmail(Long studentId,String name, String email) throws IllegalStateException{
        if(!(studentRepository.existsById(studentId))) throw new IllegalStateException("Error: student does not exist");
        Student student = studentRepository.getById(studentId);
        if(name!= null && name.length()>0) student.setName(name);
        if(email!= null && email.length()>0 ){
            Optional<Student> studentByEmailResult = studentRepository.findStudentByEmail(email);
            if(studentByEmailResult.isPresent()) throw new IllegalStateException(" Error: email already taken");
            student.setEmail(email);
        }
    }
}
