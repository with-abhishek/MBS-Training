package com.example.Employee_Address.service;


import com.example.Employee_Address.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddService {

    String addAddress(Address a);
    List<Address> getAllAddress();
    Address getAddressById(Long id);
    String updateAddress(Long id, Address a);
    String deleteAddress(Long id);

}
