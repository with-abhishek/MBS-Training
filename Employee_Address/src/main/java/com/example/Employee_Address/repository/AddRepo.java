package com.example.Employee_Address.repository;


import com.example.Employee_Address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRepo extends JpaRepository<Address,Long> {
}
