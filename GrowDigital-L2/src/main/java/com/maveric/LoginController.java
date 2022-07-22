package com.maveric;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.model.UserRegistration;

@RestController
public class LoginController {
		@GetMapping("/login") 	
		public String login() {
//			System.out.println("Project Strated");
			return "Project Started";
		}
		
}
