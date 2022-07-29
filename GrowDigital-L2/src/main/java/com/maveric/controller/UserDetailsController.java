package com.maveric.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.maveric.model.UserRegistration;
import com.maveric.model.customerDetails;
import com.maveric.service.UserDetailsService;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailsService userDetailsService ;

	@GetMapping("/signup")
	public String Signup() {
		
		return "singup.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login.jsp";
	}
	
	@PostMapping("/addUserDetails")
	public ResponseEntity<customerDetails> RegisterUser(UserRegistration user) { 
		
		HttpHeaders header = new HttpHeaders();
		
		customerDetails cus_data = userDetailsService.findCustomerDetailsById(user.getCustomer_id());
		
		if(cus_data != null) 
		{
			List<UserRegistration> oldUser = userDetailsService.findRegisterUserById(user.getCustomer_id(),user.getEmail());
			if(oldUser.isEmpty()) {
				UserRegistration addedCustomerDetails = userDetailsService.registerUser(user);
				}
			else {
				header.add("description","failure");
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).headers(header).body(null);
			}
		
		header.add("description","success");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(cus_data);
		
		}
		else {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(null);
			
		}
		
		
	}
	
	@PostMapping("/login")
	public ModelAndView Login(@RequestParam String email , @RequestParam String password) {
		
		ModelAndView mav = new ModelAndView();
		
		UserRegistration userDetails = userDetailsService.getUserDetails(email,password);
		
		if(userDetails != null) {
			
			customerDetails customer_data = userDetailsService.findCustomerDetailsById(userDetails.getCustomer_id());
			mav.addObject("userRegiterDetails", userDetails);
			mav.addObject("CustomerDetails", customer_data);
			mav.setViewName("welcome.jsp");
			
		return mav; 
		}
		
		mav.setViewName("login.jsp");
		mav.addObject("userRegisterDetails", null);
		mav.addObject("CustomerDetails",null);
		return mav;
	}
	
}
