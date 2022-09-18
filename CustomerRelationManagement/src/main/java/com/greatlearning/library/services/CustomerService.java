package com.greatlearning.library.services;

import java.util.List;
import com.greatlearning.library.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);

	public List<Customer> searchBy(String name, String email);
	
	
}
