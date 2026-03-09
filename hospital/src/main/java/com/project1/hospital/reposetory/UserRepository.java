package com.project1.hospital.reposetory;


import com.project1.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Login ke waqt kaam aayega
    Optional<User> findByEmail(String email);
    
    // Check karne ke liye ki email pehle se exists toh nahi karta
    Boolean existsByEmail(String email);
}