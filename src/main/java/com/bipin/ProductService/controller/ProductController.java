package com.bipin.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bipin.ProductService.dto.ProductProjection;
import com.bipin.ProductService.dto.ProductResponseDTO;
import com.bipin.ProductService.model.Product;
import com.bipin.ProductService.services.FakeStoreService;
import com.bipin.ProductService.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private FakeStoreService fss;
	@Autowired
	private ProductService ps;

	@GetMapping("product/category/{id}")
	public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable("id") int id) {
		List<Product> productByCategory = ps.getProductByCategory(id);

		List<ProductResponseDTO> resposne = productByCategory.stream().map(product -> {
			ProductResponseDTO pr = new ProductResponseDTO(product.getName(), product.getDescription(),
					product.getPrice(), product.getRating());
			return pr;

		}).toList();

		return ResponseEntity.ok(resposne);
	}

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product resposne = ps.addProduct(product);

		return ResponseEntity.ok(resposne);

	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product product = ps.getProduct(id);

		return ResponseEntity.ok(product);
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> allProduct = ps.getAllProduct();

		return ResponseEntity.ok(allProduct);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product payLoad, @PathVariable("id") int id) {
		Product updatedProduct = ps.updateProduct(payLoad, id);

		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Boolean> updateProduct(@PathVariable("id") int id) {
		boolean deleteProduct = ps.deleteProduct(id);

		return ResponseEntity.ok(deleteProduct);
	}

	@GetMapping("/product/type/{name}")
	public ResponseEntity<List<Product>> findProductByName(@PathVariable("name") String name) {
		List<Product> findProductByName = ps.findProductByName(name);

		return ResponseEntity.ok(findProductByName);
	}

	// projection api
	@GetMapping("/product/projection/{name}")
	public ResponseEntity<ProductProjection> getProductByName(@PathVariable("name") String pname) {

		ProductProjection productByProjection = ps.getProductByProjection(pname);
		return ResponseEntity.ok(productByProjection);
	}

	@PutMapping("/product/{id}/remove-category")
	public ResponseEntity<ProductResponseDTO> removeCategoryFromProduct(@PathVariable("id") int productId) {
		Product productwihoutCategory = ps.removeCategoryFromProduct(productId);
		ProductResponseDTO response = new ProductResponseDTO();
		response.setProductDescription(productwihoutCategory.getDescription());
		response.setProductName(productwihoutCategory.getName());
		response.setProductPrice(productwihoutCategory.getPrice());
		response.setRating(productwihoutCategory.getRating());

		return ResponseEntity.ok(response);
	}

//	@GetMapping("/product/{id}")
//	public FakeProductDto getProduct(@PathVariable("id") int id) {
//		FakeProductDto singleProduct = fss.getSingleProduct(id);
//		System.out.println(singleProduct);
//		return singleProduct;
//	}
//
//	@GetMapping("/product")
//	public FakeProductDto[] getProducts() {
//		FakeProductDto[] products = fss.getAllProducts();
//		return products;
//
//	}
//
//	@PostMapping("/product")
//	public FakeProductDto createProduct(@RequestBody FakeProductDto payLoad) {
//		return fss.createProduct(payLoad);
//	}
//
//	@PutMapping("/product/{id}")
//	public FakeProductDto updateProduct(@PathVariable("id") int id, @RequestBody FakeProductDto payLoad) {
//		return fss.updateProduct(id,payLoad);
//	}
//	@DeleteMapping("/product/{id}")
//	public Boolean  deleteProduct(@PathVariable("id") int id)
//	{
//		return fss.deleteProduct(id);
//	}

}
