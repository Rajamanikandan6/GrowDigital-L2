package com.maveric.service;

import com.maveric.model.customerDetails;
import com.maveric.repository.CustomerDetailsRepository;
import com.maveric.repository.UserRegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maveric.model.UserRegistration;

@Service
public class UserDetailsService {
	
	@Autowired
	CustomerDetailsRepository CustomerDetailsRepo;
	
	@Autowired
	UserRegisterRepository userRegisterRepo;
	
	
	public UserRegistration registerUser(UserRegistration user) {
		
		return userRegisterRepo.save(user);
		
	}
	
	public customerDetails findCustomerDetailsById(int cus_id) {
		
		return CustomerDetailsRepo.findById(cus_id).orElse(null);
			
	}
}
