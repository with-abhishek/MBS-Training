package com.springboot.employee_laptop.service;

import com.springboot.employee_laptop.model.Employee;
import com.springboot.employee_laptop.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpRepo empRepo;
    @Override
    public String addEmployee(Employee e) {
        if(e == null) {
            return "successfully Register>>>";
        }
        empRepo.save(e);
        return "successfully Register>>>";
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all = empRepo.findAll();
        if (all.isEmpty()){
            return null;
        }
        return all;
    }

    @Override
    public Employee getEmpByid(Long id) {
        return empRepo.findById(id).orElse(null);
    }

    @Override
    public String updateEmployee(Long id,Employee e) {
        Optional<Employee> upId = empRepo.findById(id);
        if(!upId.isPresent()){
            return "No records on the database;";
        }
       e.setId(upId.get().getId());
        empRepo.save(e);
        return "Update Successfully ";
    }

    @Override
    public String deleteEmployee(Long id) {
        Optional<Employee> byId = empRepo.findById(id);
        if(!byId.isPresent()){
            return "No records on the database;";
        }
        empRepo.deleteById(id);
        return "Delete Successfully ";
    }

}
