package com.project.CRMS.service;

import java.util.List;


import com.project.CRMS.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findALL();
	
	public Customer findById(int theid);
	
	public void save(Customer thecustomer);
	
	public void Delete(int theid);

	public List<Customer> searchby(String thename);
}
