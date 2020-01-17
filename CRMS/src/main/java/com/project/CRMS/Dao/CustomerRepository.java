package com.project.CRMS.Dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.CRMS.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public List<Customer> findAllByOrderByLastNameAsc();

	public List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
