package com.springboot.employee_laptop.controller;

import com.springboot.employee_laptop.model.Employee;
import com.springboot.employee_laptop.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/msg")
    public String msg(){
        return "Welcome , This is our home page";
    }
    @PostMapping("/register")
    public String employeeRegister(@RequestBody Employee e){
        return empService.addEmployee(e);
    }
    @GetMapping("/findAll")
    public List<Employee> findAll(){
        return empService.getAllEmployee();
    }
    @GetMapping("/find/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return empService.getEmpByid(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return empService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee emp){
        return empService.updateEmployee(id,emp);
    }

}
