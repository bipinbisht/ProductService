package com.bipin.ProductService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipin.ProductService.dto.CategoryRequestDTO;
import com.bipin.ProductService.dto.CategoryResponseDTO;
import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cs;

	@PostMapping("/category")
	public ResponseEntity<CategoryResponseDTO> addCategory(@RequestBody CategoryRequestDTO cat) {
		Category addedCategory = cs.addCategory(cat);
		// conversion to dto
		CategoryResponseDTO cr = new CategoryResponseDTO(addedCategory.getName(), addedCategory.getDescription());

		return ResponseEntity.ok(cr);

	}

	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") int id) {
		Category categoryById = cs.getCategoryById(id);
		CategoryResponseDTO response = new CategoryResponseDTO();
		response.setCategoryName(categoryById.getName());
		response.setCategoryDescription(categoryById.getDescription());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/category")
	public ResponseEntity<List<CategoryResponseDTO>> getAllCategory() {
		List<Category> allCategory = cs.getAllCategory();
		List<CategoryResponseDTO> responseList = new ArrayList<>();
		allCategory.stream().forEach((cat) -> {
			CategoryResponseDTO cr = new CategoryResponseDTO();
			cr.setCategoryName(cat.getName());
			cr.setCategoryDescription(cat.getDescription());
			responseList.add(cr);
		});
		return ResponseEntity.ok(responseList);
	}

	@GetMapping("/category/product/{id}")
	public ResponseEntity<CategoryResponseDTO> getCategoryByProduct(@PathVariable("id") int productId) {

		Category categoryByProduct = cs.getCategoryByProduct(productId);

		CategoryResponseDTO response = new CategoryResponseDTO();
		response.setCategoryName(categoryByProduct.getName());
		response.setCategoryDescription(categoryByProduct.getDescription());

		return ResponseEntity.ok(response);

	}
//	@GetMapping("/category")
//	public ResponseEntity<List<CategoryResponseDTO>> getAllProduct1() {
//		List<Category> allCategory = cs.getAllCategory();
//		List<CategoryResponseDTO> responseList = new ArrayList<>();
//		allCategory.stream().map((cat) -> {
//			CategoryResponseDTO cr = new CategoryResponseDTO();
//			cr.setCategoryName(cat.getName());
//			cr.setCategoryDescription(cat.getDescription());
//			return cr;
//		}).toList();
//		return ResponseEntity.ok(responseList);
//	}
}
