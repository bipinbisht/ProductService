package com.bipin.ProductService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Category extends BaseModel {
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
