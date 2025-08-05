package com.spring.OneToManyMapping.repository;

import com.spring.OneToManyMapping.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
}
