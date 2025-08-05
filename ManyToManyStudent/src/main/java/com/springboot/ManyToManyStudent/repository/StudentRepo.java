package com.springboot.ManyToManyStudent.repository;

import com.springboot.ManyToManyStudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
