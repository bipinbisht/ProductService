package com.bipin.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bipin.ProductService.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
