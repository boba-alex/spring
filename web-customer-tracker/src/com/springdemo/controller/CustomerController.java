package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject customer service
	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from dao
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//model attr
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the Customer
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {
		
		// get the customer from db
		Customer customer = customerService.getCustomer(theId);
		
		//set customer as a model attr to prep the form
		theModel.addAttribute("customer", customer);
		
		//send over to our from
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		
		//delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
}
