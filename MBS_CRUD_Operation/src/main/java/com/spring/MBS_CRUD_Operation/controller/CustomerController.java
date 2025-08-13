package com.spring.MBS_CRUD_Operation.controller;

import com.spring.MBS_CRUD_Operation.model.Customer;
import com.spring.MBS_CRUD_Operation.model.Response;
import com.spring.MBS_CRUD_Operation.servicce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String msg(){
        return "Welcome , Here I'm using for creating this web application using the spring boot>>>>>>> ";
    }
    @PostMapping("/register")
    public Response registerCustomer(@RequestBody Customer cust){
        return customerService.registerCustomer(cust);
    }
    @GetMapping("/getAll")
    public Response getCustomer(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/fetch/{id}")
    public Response getCustomerById(@PathVariable Long id){
        return customerService.getByCustomerId(id);
    } @DeleteMapping("/delete/{id}")
    public Response deleteCustomerById(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("/update/{id}")
    public Response updateCustomer(@RequestBody Customer cust, @PathVariable Long id ){
        return customerService.updateCustomer(cust,id);
    }




}
