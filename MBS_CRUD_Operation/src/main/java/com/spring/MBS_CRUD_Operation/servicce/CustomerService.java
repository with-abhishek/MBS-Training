package com.spring.MBS_CRUD_Operation.servicce;

import com.spring.MBS_CRUD_Operation.model.Customer;
import com.spring.MBS_CRUD_Operation.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Response registerCustomer(Customer cust);
    Response getAllCustomer();
    Response getByCustomerId(Long id);
    Response updateCustomer(Customer cust , Long id);
    Response deleteCustomer(Long id);

}
