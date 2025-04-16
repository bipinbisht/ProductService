package com.bipin.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bipin.ProductService.dto.FakeProductDto;
import com.bipin.ProductService.services.FakeStoreService;

@RestController
public class ProductController {

	@Autowired
	private FakeStoreService fss;

	@GetMapping("/product/{id}")
	public FakeProductDto getProduct(@PathVariable("id") int id) {
		FakeProductDto singleProduct = fss.getSingleProduct(id);
		System.out.println(singleProduct);
		return singleProduct;
	}

	@GetMapping("/products")
	public FakeProductDto[] getProducts() {
		FakeProductDto[] products = fss.getAllProducts();
		return products;
	}

}
