package com.bipin.ProductService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipin.ProductService.exception.ProductNotFoundException;
import com.bipin.ProductService.model.Product;
import com.bipin.ProductService.repo.ProductRepo;

@Service
public class ProductLookupService {
	
	 @Autowired
	    private ProductRepo productRepo;

	    public Product getProductById(int id) {
	        return productRepo.findById(id)
	                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found !! 404"));
	    }

}
