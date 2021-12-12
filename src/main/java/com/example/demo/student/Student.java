package com.example.demo.student;
import java.time.LocalDate;
import java.util.*;
public class Student {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Student(){

    }

    public Student(Long id, String name,String email, LocalDate dob, Integer age){
        this.id = id;
        this.name= name;
        this.email= email;
        this.dob= dob;
        this.age= age;
    }
    public Student( String name,String email, LocalDate dob, Integer age){
        this.name= name;
        this.email= email;
        this.dob= dob;
        this.age= age;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    public void setDob(LocalDate dob){
        this.dob=dob;
    }
    public LocalDate getDob(){
        return dob;
    }

    public void setAge(Integer age){
        this.age=age;
    }
    public Integer getAge(){
        return age;
    }
    @Override
    public String toString(){
        String studentStringValue = name + " email " + email + " dob " + dob + " age " + age;
//        String studentStringValue = "Student{" + "id=" + this.id +
//                " , name= " name + " email " + email +" dob " + dob + " age " + age;
        return studentStringValue;

    }
}
