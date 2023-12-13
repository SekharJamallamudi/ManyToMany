package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
   public List<Product> findByPriceLessThan(double price);
}
