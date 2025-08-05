package com.mbs.OneToOneEmployee.controller;


import com.mbs.OneToOneEmployee.model.Employee;
import com.mbs.OneToOneEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @RequestMapping("/")
    public String msg(){
        return "Hello Java ";
    }

    @PostMapping("registerEmp")
    public String registerEmp(@RequestBody Employee emp){
        return empService.saveEmployee(emp);
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployee(){
        return empService.findAllEmployee();
    }

    @GetMapping("/findByEmployeeId")
    public Optional<Employee> getEmployee(@RequestParam long id){
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
