package com.second.service_second_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CartRepository extends JpaRepository< Cart , Long >{
    
}
