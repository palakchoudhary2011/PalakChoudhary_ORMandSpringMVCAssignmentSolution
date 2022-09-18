package com.greatlearning.customer.service;

import java.util.List;

import com.greatlearning.customer.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomerList();
	
	public void createUpdateCustomer(Customer customer);
	
	public Customer getCustomerById(int id);
	
	public void deleteCustomer(int id);
	
	
}
