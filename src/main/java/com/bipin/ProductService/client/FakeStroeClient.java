package com.bipin.ProductService.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bipin.ProductService.dto.FakeProductDto;

@Component
public class FakeStroeClient {

	@Autowired
	private RestTemplate rest;

	public FakeProductDto getSingleProduct(int id) {
		String url = "https://fakestoreapi.com/products/";
		FakeProductDto forObject = rest.getForObject(url + id, FakeProductDto.class);
		return forObject;
	}
	
	
	
	public FakeProductDto[] getAllProducts() {
		String url = "https://fakestoreapi.com/products/";
		FakeProductDto[] forObject = rest.getForObject(url , FakeProductDto[].class);
		return forObject;
	}

}
