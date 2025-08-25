package com.spring.MBS_CRUD_Operation.servicce;

import com.spring.MBS_CRUD_Operation.constant.Constant;
import com.spring.MBS_CRUD_Operation.model.Customer;
import com.spring.MBS_CRUD_Operation.model.Response;
import com.spring.MBS_CRUD_Operation.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Response registerCustomer(Customer cust) {
        Customer cust1 = customerRepo.save(cust);
        if(cust1 ==null){
            return  new Response(HttpStatus.NO_CONTENT.value(),Constant.CUSTOMER_CREATION_FAILED,cust1);
        }
        return new Response(HttpStatus.OK.value(), Constant.CUSTOMER_CREATION_SUCCESSFULL,cust1);
    }

    @Override
    public Response getAllCustomer() {
        List<Customer> cust1=customerRepo.findAll();
        if(cust1.isEmpty()){
            return  new Response(HttpStatus.SERVICE_UNAVAILABLE.value(),Constant.CUSTOMERS_FETCHING_FAILED,null);
        }
        return new Response(HttpStatus.OK.value(), Constant.CUSTOMERS_FETCHING_SUCCESS,cust1);
    }

    @Override
    public Response getByCustomerId(Long id) {
        Optional<Customer> cust1 = customerRepo.findById(id);
        return cust1.map(customer -> new Response(HttpStatus.OK.value(), Constant.CUSTOMER_FETCHING_SUCCESS, customer)).orElseGet(() -> new Response(HttpStatus.BAD_REQUEST.value(), Constant.CUSTOMER_FETCHING_FAILED, cust1));
    }

    @Override
    public Response updateCustomer(Customer cust, Long id) {
        Optional<Customer> existingCust = customerRepo.findById(id);
        if(!existingCust.isPresent()){
            return  new Response(HttpStatus.BAD_REQUEST.value(), Constant.CUSTOMER_UPDATION_FAILED,existingCust);
        }
        cust.setId(existingCust.get().getId());
        Customer upCust= customerRepo.save(cust);
        return new Response(HttpStatus.OK.value(), Constant.CUSTOMER_UPDATION_SUCCESS,upCust);

    }

    @Override
    public Response deleteCustomer(Long id) {
        Optional<Customer> cust1 = customerRepo.findById(id);
        return cust1.map(customer -> {
            customerRepo.deleteById(customer.getId());
            return new Response(HttpStatus.OK.value(),Constant.CUSTOMER_DELETION_SUCCESS,null);}).orElseGet(()->new Response(HttpStatus.BAD_REQUEST.value(), Constant.CUSTOMER_DELETION_FAILED,cust1));
//        if(!cust1.isPresent()){
//            return  new Response(HttpStatus.BAD_REQUEST.value(), Constant.CUSTOMER_DELETION_FAILED,cust1);
//        }
//        return new Response(HttpStatus.OK.value(), Constant.CUSTOMER_DELETION_SUCCESS,null);
    }
}
