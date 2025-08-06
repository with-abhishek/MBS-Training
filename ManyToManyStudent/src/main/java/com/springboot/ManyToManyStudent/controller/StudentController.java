package com.springboot.ManyToManyStudent.controller;


import com.springboot.ManyToManyStudent.model.Course;
import com.springboot.ManyToManyStudent.model.Student;
import com.springboot.ManyToManyStudent.repository.CourseRepo;
import com.springboot.ManyToManyStudent.service.CourseService;
import com.springboot.ManyToManyStudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @RequestMapping("/")
    public String msg(){
        return "Hello Spring Boot";
    }

    @PostMapping("/register")
    public String register(@RequestBody List<Student> stu){

        return studentService.saveStudent(stu);
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/searchStudent")
    public Student getStudent(@RequestParam long id)
    {
        return studentService.getStudentById(id);

    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam long id){
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/getAllCourses")
    public List<Course> getCourses(){

        return courseService.getAllCourses();
    }





}
