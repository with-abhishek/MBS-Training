package com.springboot.ManyToManyStudent.service;

import com.springboot.ManyToManyStudent.model.Course;
import com.springboot.ManyToManyStudent.model.Student;
import com.springboot.ManyToManyStudent.repository.CourseRepo;
import com.springboot.ManyToManyStudent.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
 @Autowired
    private CourseRepo courseRepo;

    public String saveStudent(List<Student> stu) {
        studentRepo.saveAll(stu);
        return "Register Successfully";
    }

    public List<Student> getAllStudent() {
        return  studentRepo.findAll();
    }


    public Student getStudentById(long id) {
        return studentRepo.findById(id).orElse(null);
    }


    public String deleteStudentById(long id) {
        Optional<Student> optStu = studentRepo.findById(id);
        if(optStu.isPresent()){
            Student st =optStu.get();
            studentRepo.delete(st);
            return "Successfully deleted";
        }
        return "No Student in databases";
    }






}
