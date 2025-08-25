package com.example.Employee_Address.controller;


import com.example.Employee_Address.model.Address;
import com.example.Employee_Address.model.Employee;
import com.example.Employee_Address.service.AddService;
import com.example.Employee_Address.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressApi")
public class AddressController {

    @Autowired
    private AddService addService;

    @PostMapping("/addAddress")
    public String addEmployeeAddress(@RequestBody Address a){
        return addService.addAddress(a);
    }
    @GetMapping("/findAllAddress")
    public List<Address> findAllAddress(){
        return addService.getAllAddress();
    }
    @GetMapping("/findAddress/{id}")
    public Address getAddress(@PathVariable Long id){
        return addService.getAddressById(id);
    }
    @DeleteMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addService.deleteAddress(id);
    }
    @PutMapping("/updateAddress/{id}")
    public String updateAddress(@PathVariable Long id, @RequestBody Address add){
        return addService.updateAddress(id,add);
    }

}
