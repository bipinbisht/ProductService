package com.bipin.ProductService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bipin.ProductService.dto.ProductProjection;
import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findProductByName(String name);

	ProductProjection findFirstByName(String name);

	ProductProjection findByNameAndDescription(String name, String description);
//	List<Product> findAllByCategory(Category c);
//	List<Product> findProductsByCategory(Category c);

}
