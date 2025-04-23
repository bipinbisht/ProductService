package com.bipin.ProductService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipin.ProductService.client.FakeStoreClient;
import com.bipin.ProductService.dto.FakeProductDto;

@Service
public class FakeStoreService {

	@Autowired
	private FakeStoreClient fsc;

	public FakeProductDto getSingleProduct(int id) {
		FakeProductDto singleProduct = fsc.getSingleProduct(id);
		return singleProduct;
	}

	public FakeProductDto[] getAllProducts() {
		FakeProductDto[] products = fsc.getAllProducts();
		return products;
	}

	public  FakeProductDto createProduct(FakeProductDto payLoad) {

		return fsc.createProduct(payLoad);
	}

	public FakeProductDto updateProduct(int id ,FakeProductDto payLoad) {
		
		return fsc.updateProduct(id,payLoad);
	}

	public Boolean deleteProduct(int id) {
		
		return fsc.deleteProduct(id);
	}

}
