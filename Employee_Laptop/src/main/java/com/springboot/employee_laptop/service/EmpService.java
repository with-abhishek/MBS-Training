package com.springboot.employee_laptop.service;


import com.springboot.employee_laptop.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    String addEmployee(Employee e);
    List<Employee> getAllEmployee();
    Employee getEmpByid(Long id);
    String updateEmployee(Long id, Employee e);
    String deleteEmployee(Long id);
}
