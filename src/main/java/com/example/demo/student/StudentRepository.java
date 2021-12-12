package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
//<the type of obj, the type of id for obj>
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //@Query("Select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
