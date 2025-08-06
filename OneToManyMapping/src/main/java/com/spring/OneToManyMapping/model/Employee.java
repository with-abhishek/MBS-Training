package com.spring.OneToManyMapping.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.*;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String gender;
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_address",
            joinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id",referencedColumnName = "id")
    )
    private Set<Address> address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }
}
