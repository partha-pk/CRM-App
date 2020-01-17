package com.project.CRMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerSecurityController {

	
	@GetMapping("/showlogin")
	public String loginAccess() {
		
		return "login";
		
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		
		return "access-denied";
		
	}
}
