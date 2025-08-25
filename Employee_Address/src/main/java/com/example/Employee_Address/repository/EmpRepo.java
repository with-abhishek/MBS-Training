package com.example.Employee_Address.repository;

import com.example.Employee_Address.model.Address;
import com.example.Employee_Address.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByAddressId(Long id);

    List<Employee> findAllByAddressId(Long id);
}
