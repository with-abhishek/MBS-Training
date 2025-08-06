package com.spring.OneToManyMapping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String state;
    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
