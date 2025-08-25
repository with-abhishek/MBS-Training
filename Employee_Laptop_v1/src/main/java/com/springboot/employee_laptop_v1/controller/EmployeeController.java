package com.springboot.employee_laptop_v1.controller;


import com.springboot.employee_laptop_v1.model.Employee;
import com.springboot.employee_laptop_v1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @PostMapping("/registerEmp")
    public String employeeRegister(@RequestBody Employee e){
        return empService.addEmployee(e);
    }
    @GetMapping("/findAllEmp")
    public List<Employee> findAllEmployee(){
        return empService.getAllEmployee();
    }
    @GetMapping("/findEmp/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return empService.getEmpByid(id);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return empService.deleteEmployee(id);
    }

    @PutMapping("/updateEmp/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee emp){
        return empService.updateEmployee(id,emp);
    }

}
