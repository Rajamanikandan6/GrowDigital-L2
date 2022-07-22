package com.maveric.controller;


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
	public ResponseEntity<customerDetails> RegisterUser(UserRegistration user) { 
		
		customerDetails cus_data = userDetailsService.findCustomerDetailsById(user.getCustomer_id());
		
		if(cus_data != null) 
		{
			if(cus_data.getEmail().equalsIgnoreCase(user.getEmail())) {
				UserRegistration addedCustomerDetails = userDetailsService.registerUser(user);
				}
			else {
				return new ResponseEntity(null,HttpStatus.NO_CONTENT);
			}
		
		return new ResponseEntity(cus_data,HttpStatus.OK);
		
		}else {
			
			return new ResponseEntity(cus_data,HttpStatus.NO_CONTENT);
			
		}
		
		
	}
	
}
