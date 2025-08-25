package com.spring.OCR_Project.repository;

import com.spring.OCR_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
