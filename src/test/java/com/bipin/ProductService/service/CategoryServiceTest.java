package com.bipin.ProductService.service;

//import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bipin.ProductService.dto.CategoryRequestDTO;
import com.bipin.ProductService.exception.DublicateCategoryNameException;
import com.bipin.ProductService.model.Category;
import com.bipin.ProductService.model.Product;
import com.bipin.ProductService.repo.CategoryRepo;
import com.bipin.ProductService.services.CategoryService;
import com.bipin.ProductService.services.ProductLookupService;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

	@Mock
	private CategoryRepo crepo;

	@Mock
	private ProductLookupService productLookupService;

	@InjectMocks
	private CategoryService categoryService;
	Category category = new Category();
	Product product1 = new Product();
	Product product2 = new Product();

	@BeforeEach // this method will run before each test case
	void setUp() {
		category = new Category();
		category.setId(1);
		category.setName("Electronics");
		category.setDescription("This is Electronics category");
		product1 = new Product();
		product1.setId(1);
		product1.setName("Laptop");

		product2 = new Product();
		product2.setId(2);
		product2.setName("Mobile");

		ArrayList<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		category.setProducts(products);
	}

	@Test
	void addCategory_Success() {
		// setup and input creation
		CategoryRequestDTO catdto = new CategoryRequestDTO("Electronics", "This is Electronics category");
		// mocking
		when(crepo.findByName("Electronics")).thenReturn(Optional.empty());
		// object required for creation
		Category savedCategory = new Category();
		savedCategory.setId(1);
		savedCategory.setName("Electronics");
		savedCategory.setDescription("This is Electronics category");
		// mocking
		when(crepo.save(any(Category.class))).thenReturn(savedCategory);

		// call the actual method to be tested
		Category createdCategory = categoryService.addCategory(catdto);
		// verification
		Assertions.assertNotNull(createdCategory);
		Assertions.assertEquals(savedCategory.getId(), createdCategory.getId());
		Assertions.assertEquals(savedCategory.getName(), createdCategory.getName());
		Assertions.assertEquals(savedCategory.getDescription(), createdCategory.getDescription());
		verify(crepo).findByName("Electronics");
		verify(crepo).save(any(Category.class));

	}
	
	@Test
	void addAddCategory_DublicateName_ThrowsException() {
		// setup and input creation
		CategoryRequestDTO catdto = new CategoryRequestDTO("Electronics", "This is Electronics category");
		Category savedCategory = new Category();
		savedCategory.setId(1);
		savedCategory.setName("Electronics");
		savedCategory.setDescription("This is Electronics category");
		// mocking
		when(crepo.findByName("Electronics")).thenReturn(Optional.of(savedCategory));

		// call the actual method to be tested
		Assertions.assertThrows(DublicateCategoryNameException.class, () -> {
			categoryService.addCategory(catdto);
		});
		verify(crepo).findByName("Electronics");
		verify(crepo, never()).save(any(Category.class));

	}

	@Test
	void getAllCategory_ReturnsList() {
		// Arrange
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Books");
		category2.setDescription("This is Books category");
		when(crepo.findAll()).thenReturn(java.util.Arrays.asList(category, category2));

		// Act
		java.util.List<Category> categories = categoryService.getAllCategory();

		// Assert
		Assertions.assertNotNull(categories);
		Assertions.assertEquals(2, categories.size());
		Assertions.assertEquals("Electronics", categories.get(0).getName());
		Assertions.assertEquals("Books", categories.get(1).getName());
		verify(crepo).findAll();
	}

}