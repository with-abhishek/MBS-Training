package com.springboot.ManyToManyStudent.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String course_name;
    private long course_fee;

//    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
//    private Set<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

    public long getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(long course_fee) {
        this.course_fee = course_fee;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", course_fee=" + course_fee +
                '}';
    }
}
