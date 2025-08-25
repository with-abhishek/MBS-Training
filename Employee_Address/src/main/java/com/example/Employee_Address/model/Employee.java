package com.example.Employee_Address.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Email")
    private String email;


    @ManyToMany
    @JoinTable(
            name = "employee_address",
            joinColumns = @JoinColumn(name = "Employee_id",referencedColumnName = "Employee_id"),
            inverseJoinColumns = @JoinColumn(name = "Address_id",referencedColumnName = "Address_id")
    )
    private List<Address> address;
}
