package com.springboot.ManyToManyStudent.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "Students_Courses",
            joinColumns = @JoinColumn(name = "Student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id",referencedColumnName = "id"))
    private Set<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }
}
