package com.bipin.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bipin.ProductService.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
