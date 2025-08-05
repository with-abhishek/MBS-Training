package com.springboot.ManyToManyStudent.service;

import com.springboot.ManyToManyStudent.model.Course;
import com.springboot.ManyToManyStudent.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;



    public List<Course> getAllCourses() {
        return courseRepo.findAll();

    }
}
