package com.greatlearning.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customer.entity.Customer;
import com.greatlearning.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	private String customerList(Model model) {
		List<Customer> customer = customerService.getCustomerList();
		model.addAttribute("Customers",customer);
		return "customer-list";
	}
	
	
	@RequestMapping("/createCustomer")
	private String createCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("Customers", customer);
		return "customer-edit";
	}
	
	@RequestMapping("/updateCustomer")
	private String updateCustomer(@RequestParam("id") int id, Model model) {
		Customer customer = new Customer();
		customer = customerService.getCustomerById(id);
		model.addAttribute("Customers", customer);
		return "customer-edit";
	}
	
	@RequestMapping("/delete")
	private String deleteCustomer(@RequestParam("id") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/";
	}
	
	@PostMapping("/save")
	private String saveData(@RequestParam("id") int id, @RequestParam("f_name") String f_name, @RequestParam("l_name") String l_name, @RequestParam("email") String email) {
		Customer customer;
		if(id != 0) {
			customer = customerService.getCustomerById(id);
			customer.setF_name(f_name);
			customer.setL_name(l_name);
			customer.setEmail(email);
		}else {
			customer = new Customer(f_name, l_name, email);
		}
		customerService.createUpdateCustomer(customer);
		return "redirect:/";
	}
}
