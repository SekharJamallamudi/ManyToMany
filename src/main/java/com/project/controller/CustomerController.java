package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.entity.Product;
import com.project.service.CustomerService;



@RestController
@RequestMapping("/manyTomany")
public class CustomerController {
	   @Autowired
	   private CustomerService service;
	   
	   
	   @PostMapping("/save")
	   public Customer saveCustomer(@RequestBody Customer customer)
	   {
		   return service.saveCustomer(customer);
	   }
	   
	   @GetMapping("/fetchAll")
	   public List<Customer> fetchAll()
	   {
		   return service.fetchAll();
	   }
	   @GetMapping("/fetchContaining/{name}")
	   public List<Customer> fetchNameContainingString(@PathVariable String name)
	   {
		   return service.customerNameContaining(name);
	   }
	   @GetMapping("/fetchProducrPrice/{price}")
	   public List<Product> fetchProductBasedOnPrice(@PathVariable double price)
	   {
		   return service.findProductpriceLessThan(price);
	   }
	   
}
  