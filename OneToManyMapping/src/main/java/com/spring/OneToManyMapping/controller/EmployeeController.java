package com.spring.OneToManyMapping.controller;


import com.spring.OneToManyMapping.model.Employee;
import com.spring.OneToManyMapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {



    @Autowired
    private EmployeeService empService;

//    @RequestMapping("/")
//    public String msg(){
//        return "Hello Java ";
//    }

    @PostMapping("/registerEmp")
    public String registerEmp(@RequestBody Employee emp){
        return empService.saveEmployee(emp);
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployee(){
        return empService.findAllEmployee();
    }

    @GetMapping("/findByEmpId")
    public Employee getEmployee(@RequestParam long id){
        return empService.getEmployeeById(id);
    }

    @DeleteMapping("/deleteByEmpId")
    public String deleteEmployee(@RequestParam long id){

        return empService.deleteEmployeeById(id);
    }
    @PutMapping("/updateEmployee")
    public String updateEmployeeDetails(@RequestParam long id , @RequestBody Employee emp){
        return empService.updateEmployee(id,emp);
    }
}
