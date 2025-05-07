package com.bipin.ProductService.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.model.Product;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Optional<Category> findByName(String name);
	
	Optional<Category> findByProductsIn(List<Product> pr);


	
}
