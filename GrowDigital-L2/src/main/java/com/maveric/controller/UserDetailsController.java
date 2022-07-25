package com.maveric.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.model.UserRegistration;
import com.maveric.model.customerDetails;
import com.maveric.service.UserDetailsService;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService ;

	public String Signup() {
		
		return "singup.jsp";
	}
	
	@PostMapping("/addUserDetails")
	public customerDetails RegisterUser(UserRegistration user) { 
		
		customerDetails cus_data = userDetailsService.findCustomerDetailsById(user.getCustomer_id());
		
		if(cus_data != null) 
		{
			List<UserRegistration> oldUser = userDetailsService.findRegisterUserById(user.getCustomer_id(),user.getEmail());
			if(oldUser.isEmpty()) {
				UserRegistration addedCustomerDetails = userDetailsService.registerUser(user);
				}
			else {
				return null;
			}
		
		return cus_data;
		
		}
		else {
			
			return null;
			
		}
		
		
	}
	
}
