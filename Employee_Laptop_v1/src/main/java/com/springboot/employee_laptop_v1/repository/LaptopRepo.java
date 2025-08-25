package com.springboot.employee_laptop_v1.repository;


import com.springboot.employee_laptop_v1.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Long> {
}
