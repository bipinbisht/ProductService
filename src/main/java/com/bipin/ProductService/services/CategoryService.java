package com.bipin.ProductService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bipin.ProductService.dto.CategoryRequestDTO;
import com.bipin.ProductService.exception.CategoryNotFoundException;
import com.bipin.ProductService.exception.DublicateCategoryNameException;
import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.model.Product;
import com.bipin.ProductService.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo crepo;
//	@Autowired
//	private ProductService pr;
	@Autowired
	private ProductLookupService productLookupService;


	public Category addCategory(CategoryRequestDTO cat) {
		// before adding category we need to check if that exists or not
		Optional<Category> categoryExists = crepo.findByName(cat.getCategoryName());

		if (categoryExists.isEmpty()) {
			Category category = new Category();
			category.setName(cat.getCategoryName());
			category.setDescription(cat.getCategoryDescription());

			return crepo.save(category);
		}
		throw new DublicateCategoryNameException("Category name already exists!!!");

	}

	public List<Category> getAllCategory() {
		return crepo.findAll();
	}

	public Category getCategoryById(int id) {

		Category categoryExistWithId = crepo.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("No category found with id " + id));

		return categoryExistWithId;

	}

	public List<Product> getProductsByCategory(int id) {
		Category categoryById = getCategoryById(id);
		// when we are getting list of products in category no need to get products
		// again by calling findProductBycategory method
		return categoryById.getProducts();

		// this is my way of doing
//		List<Product> findProductsByCategory = pr.findProductsByCategory(categoryById);
//		return findProductsByCategory;
	}

	public Category getCategoryByProduct(int id) {
		Product product = productLookupService.getProductById(id);

		Category category = crepo.findByProductsIn(List.of(product)).orElseThrow(()->
		new CategoryNotFoundException("Not category found for productId " + product.getId())
		);
		return category;
	}

}
