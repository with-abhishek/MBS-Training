package com.example.Employee_Address.service;


import com.example.Employee_Address.model.Address;
import com.example.Employee_Address.model.Employee;
import com.example.Employee_Address.repository.AddRepo;
import com.example.Employee_Address.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private AddRepo addRepo;

    public String addEmployee(Employee employee) {
        if (employee == null || employee.getAddress() == null || employee.getAddress().isEmpty()) {
            return "Employee registration failed ";
        }

        List<Address> newAdd = new ArrayList<>();
        for (Address addr : employee.getAddress()) {
            if (addr.getId() != null && addRepo.existsById(addr.getId())) {
                newAdd.add(addRepo.findById(addr.getId()).orElse(null));
            } else {
                newAdd.add(addr);
            }
        }

        employee.setAddress(newAdd);
        empRepo.save(employee);
        return "Employee registered successfully.";
    }

    @Override
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmpByid(Long id) {
        Optional<Employee> empOpt = empRepo.findById(id);
        return empOpt.orElse(null);
    }

    @Override
    public String updateEmployee(Long id, Employee e) {
        Optional<Employee> empOpt = empRepo.findById(id);
        if (empOpt.isPresent()) {
            Employee existing = empOpt.get();
            existing.setName(e.getName());
            existing.setEmail(e.getEmail());
            existing.setGender(e.getGender());
            existing.setAddress(e.getAddress());
            empRepo.save(existing);
            return "Employee updated successfully.";
        } else {
            return "Employee not found.";
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        if (empRepo.existsById(id)) {
            empRepo.deleteById(id);
            return "Employee deleted successfully.";
        } else {
            return "Employee not found.";
        }
    }
}
