package com.bipin.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/product")
	public FakeProductDto[] getProducts() {
		FakeProductDto[] products = fss.getAllProducts();
		return products;

	}

	@PostMapping("/product")
	public FakeProductDto createProduct(@RequestBody FakeProductDto payLoad) {
		return fss.createProduct(payLoad);
	}

	@PutMapping("/product/{id}")
	public FakeProductDto updateProduct(@PathVariable("id") int id, @RequestBody FakeProductDto payLoad) {
		return fss.updateProduct(id,payLoad);
	}
	@DeleteMapping("/product/{id}")
	public Boolean  deleteProduct(@PathVariable("id") int id)
	{
		return fss.deleteProduct(id);
	}

}
