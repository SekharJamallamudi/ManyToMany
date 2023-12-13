package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Customer;
import com.project.entity.Product;
import com.project.repository.CustomerRepository;
import com.project.repository.ProductRepository;

@Service
public class CustomerService {
   
	@Autowired
	private  CustomerRepository repo;
	@Autowired
	private ProductRepository product;
	
	
	public Customer saveCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	public List<Customer> fetchAll()
	{
		return repo.findAll();
	}
	public CustomerService(CustomerRepository repo, ProductRepository product) {
		super();
		this.repo = repo;
		this.product = product;
	}
	public List<Customer>customerNameContaining(String name)
	{
		return repo.findByCustomerNameContaining(name);
	}
	public List<Product> findProductpriceLessThan(double price)
	{
		return product.findByPriceLessThan(price);
	}

}
