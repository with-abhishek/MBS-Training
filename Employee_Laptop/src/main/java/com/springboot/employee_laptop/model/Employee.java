package com.springboot.employee_laptop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private String age;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Contact Number")
    private Long number;

    @OneToOne(cascade = CascadeType.ALL)
    private Laptop laptop;
}
