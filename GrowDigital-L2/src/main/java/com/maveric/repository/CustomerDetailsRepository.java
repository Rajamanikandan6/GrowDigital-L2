package com.maveric.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maveric.model.customerDetails;

public interface CustomerDetailsRepository extends JpaRepository<customerDetails, Integer>{

}
