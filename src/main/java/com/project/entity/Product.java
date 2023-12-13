package com.project.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	private String productName;
	private String dept;
	private double price;
	 @ManyToMany(cascade=CascadeType.ALL, fetch =FetchType.LAZY,mappedBy="products")
	@JsonBackReference     //it is child class so we can define this mehtod
	private Set<Customer> customer;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
	public Product(Long productId, String productName, String dept, double price, Set<Customer> customer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.dept = dept;
		this.price = price;
		this.customer = customer;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", dept=" + dept + ", price="
				+ price + ", customer=" + customer + ", getProductId()=" + getProductId() + ", getProductName()="
				+ getProductName() + ", getDept()=" + getDept() + ", getPrice()=" + getPrice() + ", getCustomer()="
				+ getCustomer() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
