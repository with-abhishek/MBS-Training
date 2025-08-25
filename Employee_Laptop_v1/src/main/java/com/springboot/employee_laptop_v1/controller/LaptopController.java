package com.springboot.employee_laptop_v1.controller;


import com.springboot.employee_laptop_v1.model.Laptop;
import com.springboot.employee_laptop_v1.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;
    @PostMapping("/addLaptop")
    public String laptopSave(@RequestBody Laptop lap){
        return laptopService.addLaptop(lap);
    }
    @GetMapping("/findAllLaptop")
    public List<Laptop> findAll(){
        return laptopService.getAllLaptop();
    }
    @GetMapping("/findLaptop/{id}")
    public Laptop getLaptop(@PathVariable Long id){
        return laptopService.getLaptopByid(id);
    }
    @DeleteMapping("/deleteLaptop/{id}")
    public String deleteLaptop(@PathVariable Long id){
        return laptopService.deleteLaptop(id);
    }

    @PutMapping("/updateLaptop/{id}")
    public String updateLaptop(@PathVariable Long id, @RequestBody Laptop lap){
        return laptopService.updateLaptop(id,lap);
    }
}
