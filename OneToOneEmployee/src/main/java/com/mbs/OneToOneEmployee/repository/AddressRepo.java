package com.mbs.OneToOneEmployee.repository;

import com.mbs.OneToOneEmployee.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
