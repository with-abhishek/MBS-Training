package com.example.Employee_Address.service;


import com.example.Employee_Address.model.Employee;
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
