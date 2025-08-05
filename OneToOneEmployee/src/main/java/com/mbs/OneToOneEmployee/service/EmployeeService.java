package com.mbs.OneToOneEmployee.service;

import com.mbs.OneToOneEmployee.model.Employee;
import com.mbs.OneToOneEmployee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo empRepo;

    public String saveEmployee(Employee emp) {

        empRepo.save(emp);
        return "Registered Succesfully";

    }

    public List<Employee> findAllEmployee() {
        return (List<Employee>) empRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return empRepo.findById(id);

    }

    public String deleteEmployeeById(long id) {
        empRepo.deleteById(id);
        return "successfully Deleted";

    }

    public String updateEmployee(long id, Employee emp) {
        Optional<Employee> e = empRepo.findById(id);

        if (e.isPresent()) {
            Employee upEmp = e.get();


            upEmp.setName(emp.getName());
            upEmp.setAge(emp.getAge());
            upEmp.setGender(emp.getGender());


            if (emp.getAddress() != null) {
                upEmp.setAddress(emp.getAddress());
            }

            empRepo.save(upEmp);
            return "Employee updated successfully.";
        } else {
            return "Employee with ID " + id + " not found.";
        }
    }
}


