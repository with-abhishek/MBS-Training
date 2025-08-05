package com.spring.OneToManyMapping.service;

import com.spring.OneToManyMapping.model.Employee;
import com.spring.OneToManyMapping.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    public String saveEmployee(Employee emp) {
        employeeRepo.save(emp);
        return "Register Successfully";
    }

    public String deleteEmployeeById(long id) {
        Optional<Employee> upemp = employeeRepo.findById(id);
        if (upemp.isPresent()) {
            Employee e = upemp.get();
            employeeRepo.delete(e);
            return "Delete Successfully";
        }
        return "Employee is not present ";
    }
    public String updateEmployee(long id, Employee emp) {
        Optional<Employee> upemp = employeeRepo.findById(id);
        if (upemp.isPresent()) {
            Employee e = upemp.get();
            e.setName(emp.getName());
            e.setAge(emp.getAge());
            e.setGender(emp.getGender());
            e.setAddress(emp.getAddress());
            employeeRepo.save(e);
            return "update Successfully";
        }
        return "Employee is not present";
    }

    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(long id) {

        return employeeRepo.findById(id).orElse(null);
    }
}
