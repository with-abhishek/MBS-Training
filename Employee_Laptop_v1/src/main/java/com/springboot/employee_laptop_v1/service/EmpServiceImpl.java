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
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private LaptopRepo laptopRepo;

    @Override
    public String addEmployee(Employee e) {
        Laptop existlp =laptopRepo.findById(e.getLaptop().getId()).orElseGet(null);
        if(existlp==null){
            return "register failed ";
        }

        e.setLaptop(existlp);
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
    public String deleteEmployee(Long id) {
        Optional<Employee> byId = empRepo.findById(id);
        if(!byId.isPresent()){
            return "No records on the database;";
        }
        empRepo.deleteById(id);
        return "Delete Successfully ";
    }

    @Override
    public String updateEmployee(Long id, Employee updatedEmp) {
        return empRepo.findById(id).map(existingEmp -> {
            Laptop newLaptop = updatedEmp.getLaptop();
            if (newLaptop != null && newLaptop.getId() != null) {
                Optional<Laptop> laptopFromDb = laptopRepo.findById(newLaptop.getId());
                if (!laptopFromDb.isPresent()) {
                    return "Laptop with ID " + newLaptop.getId() + " does not exist.";
                }

                // Check if the laptop is already assigned to another employee
                Optional<Employee> laptopOwner = empRepo.findEmployeeByLaptopId(newLaptop.getId());
                if (laptopOwner.isPresent() && !laptopOwner.get().getId().equals(id)) {
                    return "Laptop is already assigned to another employee.";
                }

                existingEmp.setLaptop(laptopFromDb.get());
            } else {
                existingEmp.setLaptop(null); // Clear laptop assignment if null
            }

            // Update other employee fields
            existingEmp.setName(updatedEmp.getName());
            existingEmp.setAge(updatedEmp.getAge());
            existingEmp.setGender(updatedEmp.getGender());
            existingEmp.setNumber(updatedEmp.getNumber());

            empRepo.save(existingEmp);
            return "Update Successfully";
        }).orElse("No employee found with ID: " + id);
    }



}
