package com.project.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER_TABLE")
public class Customer {
     @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long customerId;
	private String customerName;
	private String email;
	 @ManyToMany(cascade=CascadeType.ALL, fetch =FetchType.LAZY,targetEntity=Product.class)
	    @JoinTable(name = "CUSTOMER_PRODUCT_TABLE",
	        joinColumns = @JoinColumn(name = "customer_id"),
	        inverseJoinColumns = @JoinColumn(name = "prooduct_id"))
	private Set<Product> products;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Customer(Long customerId, String customerName, String email, Set<Product> products) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.products = products;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", products=" + products + ", getCustomerId()=" + getCustomerId() + ", getCustomerName()="
				+ getCustomerName() + ", getEmail()=" + getEmail() + ", getProducts()=" + getProducts()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
