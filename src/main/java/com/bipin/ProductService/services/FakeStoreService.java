package com.bipin.ProductService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipin.ProductService.client.FakeStroeClient;
import com.bipin.ProductService.dto.FakeProductDto;

@Service
public class FakeStoreService {

	@Autowired
	private FakeStroeClient fsc;

	public FakeProductDto getSingleProduct(int id) {
		FakeProductDto singleProduct = fsc.getSingleProduct(id);
		return singleProduct;
	}

	public FakeProductDto[] getAllProducts() {
		FakeProductDto[] products = fsc.getAllProducts();
		return products;
	}

}
