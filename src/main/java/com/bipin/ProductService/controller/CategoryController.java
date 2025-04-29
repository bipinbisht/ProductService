package com.bipin.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cs;

	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat) {
		Category addedCategory = cs.addCategory(cat);

		return ResponseEntity.ok(addedCategory);

	}

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllProduct() {
		List<Category> allCategory = cs.getAllCategory();

		return ResponseEntity.ok(allCategory);
	}
}
