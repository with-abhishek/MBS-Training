package com.springboot.employee_laptop_v1.service;

import com.springboot.employee_laptop_v1.model.Employee;
import com.springboot.employee_laptop_v1.model.Laptop;
import com.springboot.employee_laptop_v1.repository.EmpRepo;
import com.springboot.employee_laptop_v1.repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {


    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private EmpRepo empRepo;

    @Override
    public String addLaptop(Laptop lap) {
        if(lap == null) {
            return "Failed >>>>";
        }
        laptopRepo.save(lap);
        return "save successfully >>>";
    }

    @Override
    public List<Laptop> getAllLaptop() {
        List<Laptop> all = laptopRepo.findAll();
        if (all.isEmpty()){
            return null;
        }
        return all;
    }

    @Override
    public Laptop getLaptopByid(Long id) {
        return laptopRepo.findById(id).orElse(null);
    }

    @Override
    public String updateLaptop(Long id,Laptop lap) {
        Optional<Laptop> upId = laptopRepo.findById(id);
        if(!upId.isPresent()){
            return "No records on the database;";
        }
        lap.setId(upId.get().getId());
        laptopRepo.save(lap);
        return "Update Successfully ";
    }

    @Override
    public String deleteLaptop(Long id) {
        Optional<Laptop> byId = laptopRepo.findById(id);
        if(!byId.isPresent()){
            return "No records on the database;";
        }
        Optional<Employee> employeeByLaptopId = empRepo.findEmployeeByLaptopId(byId.get().getId());
        Employee e= employeeByLaptopId.get();
        e.setLaptop(null);
        empRepo.save(e);
        laptopRepo.deleteById(id);
        return "Delete Successfully ";
    }
}
