package com.project.CRMS.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.CRMS.Dao.CustomerRepository;
import com.project.CRMS.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository customerRepository;	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository thecustomerRepository) {
		this.customerRepository = thecustomerRepository;
	}

	
	@Override
	public List<Customer> findALL() {
	
		List<Customer> thecustomers=
				customerRepository.findAllByOrderByLastNameAsc();
		
		return  thecustomers;
	}

	@Override
	public Customer findById(int theid) {
		
		Optional<Customer> result=customerRepository.findById(theid);
		Customer tempcustomer=null;
		
		if(result.isPresent()) {
			
			tempcustomer=result.get();
			
		}
		
		else {
		
			throw new RuntimeException("Customer not found for the id: "+ theid);
		}
		
		return tempcustomer;
	}

	@Override
	public void save(Customer thecustomer) {
	
		customerRepository.save(thecustomer);

	}

	@Override
	public void Delete(int theid) {
		
		customerRepository.deleteById(theid);

	}

	@Override
	public List<Customer> searchby(String thename) {
		
		List<Customer> results = null;
		
		if (thename != null && (thename.trim().length() > 0)) {
			results = customerRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(thename, thename);
		}
		else {
			results = findALL();
		}
		
		return results;
	}

}
