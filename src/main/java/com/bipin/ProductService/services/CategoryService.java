package com.bipin.ProductService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo crepo;

	public Category addCategory(Category cat) {
		return crepo.save(cat);
	}

	public List<Category> getAllCategory() {
		return crepo.findAll();
	}

}
