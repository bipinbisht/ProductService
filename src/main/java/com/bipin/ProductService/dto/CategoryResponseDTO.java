package com.bipin.ProductService.dto;

public class CategoryResponseDTO {

	private String categoryName;
	private String categoryDescription;

	public CategoryResponseDTO() {

	}

	public CategoryResponseDTO(String categoryName, String categoryDescription) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;

	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

}
