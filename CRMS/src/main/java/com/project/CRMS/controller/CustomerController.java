package com.project.CRMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.CRMS.entity.Customer;
import com.project.CRMS.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	
	@Autowired
	public CustomerController(CustomerService thecustomerService) {
		this.customerService = thecustomerService;
	}



	@GetMapping("/list")
	public String getList(Model themodel){
		
		List<Customer> thecustomer =customerService.findALL();
		
		themodel.addAttribute("customers", thecustomer);
		
		return "Dashboard";
	}

	@GetMapping("/showform")
	public String showRegForm(Model themodel) {
		
		Customer thecustomer= new Customer();
		
		themodel.addAttribute("customer", thecustomer);		
		
		return "Registration-form";
	}
	
	
	@PostMapping("/save")
	public String SaveCustomer(@ModelAttribute Customer thecustomer) {
		
		customerService.save(thecustomer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/Update")
	public String updateCustomer(@RequestParam("customerId") 
					int theid, Model themodel ) {
		
		Customer thecustomer= customerService.findById(theid);
		
		themodel.addAttribute("customer", thecustomer);		
		
		
		return "Registration-form";
	}
	
	@GetMapping("/Delete")
	public String deleteCustomer(@RequestParam("customerId") int theid, 
							Model themodel) {
		
		customerService.Delete(theid);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String ShowCustomer(@RequestParam("searchname") String thename, 
							Model themodel ) {
								
		List<Customer> thecustomer=customerService.searchby(thename); 
		
		themodel.addAttribute("customers", thecustomer);
		
		return "Dashboard";
		
		
	}
	
	
	
}
