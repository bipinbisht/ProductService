package com.bipin.ProductService.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bipin.ProductService.dto.FakeProductDto;

@Component
public class FakeStoreClient {

	@Autowired
	private RestTemplate rest;

	public FakeProductDto getSingleProduct(int id) {
		String url = "https://fakestoreapi.com/products/" + id;
		FakeProductDto response = requestForObject(url, HttpMethod.GET, null, FakeProductDto.class);
		return response;
	}

	public FakeProductDto[] getAllProducts() {
		String url = "https://fakestoreapi.com/products/";
//		FakeProductDto[] forObject = rest.getForObject(url, FakeProductDto[].class);

		FakeProductDto[] response = requestForObject(url, HttpMethod.GET, null, FakeProductDto[].class);
		return response;
	}

	public FakeProductDto createProduct(FakeProductDto payLoad) {
		String url = "https://fakestoreapi.com/products/";
		FakeProductDto response = requestForObject(url, HttpMethod.POST, payLoad, FakeProductDto.class);
		return response;
	}

	private <T> T requestForObject(String url, HttpMethod httpmethod, @Nullable Object request, Class<T> responseType,
			Object... uriVariables) throws RestClientException {

		RequestCallback requestCallback = rest.httpEntityCallback(request, responseType);
		HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor<>(responseType,
				rest.getMessageConverters());
		return rest.execute(url, httpmethod, requestCallback, responseExtractor, uriVariables);
	}

	public FakeProductDto updateProduct(int id, FakeProductDto payLoad) {
		String url = "https://fakestoreapi.com/products/" + id;
		FakeProductDto response = requestForObject(url, HttpMethod.PUT, payLoad, FakeProductDto.class);
		return response;

	}

	public Boolean deleteProduct(int id) {
		String url = "https://fakestoreapi.com/products/" + id;
		try {
			requestForObject(url, HttpMethod.DELETE, null, FakeProductDto.class);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;

		}
	}

}
