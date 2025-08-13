package com.spring.MBS_CRUD_Operation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name = "Name")
    private String name;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Email")
    private String email;
}
