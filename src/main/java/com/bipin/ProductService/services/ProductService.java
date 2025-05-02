package com.bipin.ProductService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipin.ProductService.dto.ProductProjection;
import com.bipin.ProductService.exception.ProductNotFoundException;
import com.bipin.ProductService.model.Product;
import com.bipin.ProductService.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public Product addProduct(Product product) {
		System.out.println(product);
		Product response = repo.save(product);
		return response;
	}

	public Product getProduct(int id) {
		Optional<Product> product = repo.findById(id);

		if (product.isEmpty()) {
			throw new ProductNotFoundException("Product with id " + id + " not found !! 404");
		} else {
			return product.get();
		}
	}

	public List<Product> getAllProduct() {

		List<Product> products = repo.findAll();
		return products;
	}

	public Product updateProduct(Product payLoad, int id) {

		Product product = getProduct(id);
		payLoad.setId(id);
		Product save = repo.save(payLoad);
		return save;

	}

	public boolean deleteProduct(int id) {

		repo.deleteById(id);

		return true;
	}

	public List<Product> findProductByName(String name) {

		return repo.findProductByName(name);

	}

	public ProductProjection getProductByProjection(String productName) {
		return repo.findFirstByName(productName);
	}

}
