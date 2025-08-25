package com.springboot.employee_laptop_v1.repository;


import com.springboot.employee_laptop_v1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmployeeByLaptopId(Long id);

}
