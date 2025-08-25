package com.springboot.employee_laptop_v1.service;


import com.springboot.employee_laptop_v1.model.Employee;
import com.springboot.employee_laptop_v1.model.Laptop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LaptopService {

    String addLaptop(Laptop e);
    List<Laptop> getAllLaptop();
    Laptop getLaptopByid(Long id);
    String updateLaptop(Long id, Laptop e);
    String deleteLaptop(Long id);

}
