package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//<the type of obj, the type of id for obj>
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
