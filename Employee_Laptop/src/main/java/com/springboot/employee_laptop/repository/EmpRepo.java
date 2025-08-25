package com.springboot.employee_laptop.repository;

import com.springboot.employee_laptop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
}
