package com.example.Employee_Address.service;

import com.example.Employee_Address.model.Address;
import com.example.Employee_Address.model.Employee;
import com.example.Employee_Address.repository.AddRepo;
import com.example.Employee_Address.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private AddRepo addRepo;
    @Autowired
    private EmpRepo empRepo;

    @Override
    public String addAddress(Address a) {
        if(a==null){
            return "Address added failed.";
        }
        addRepo.save(a);
        return "Address added successfully.";
    }


    @Override
    public List<Address> getAllAddress() {
        return addRepo.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        Optional<Address> optAdd = addRepo.findById(id);
        return optAdd.orElse(null);
    }

    @Override
    public String updateAddress(Long id, Address a) {
        Optional<Address> opAdd = addRepo.findById(id);
        if (opAdd.isPresent()) {
            Address existingAddress = opAdd.get();
            existingAddress.setLocation(a.getLocation());
            addRepo.save(existingAddress);
            return "Address updated successfully.";
        } else {
            return "Address not found.";
        }
    }

    @Override
    public String deleteAddress(Long id) {
        if (addRepo.existsById(id)) {
            for (Employee employee : empRepo.findByAddressId(id)) {
                employee.setAddress(null);
                empRepo.save(employee);
            }
            addRepo.deleteById(id);
            return "Address deleted successfully.";
        } else {
            return "Address not found.";
        }
    }
}
