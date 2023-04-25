package com.cwc.fake.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwc.fake.shop.config.ConfigurationManager;
import com.cwc.fake.shop.entities.category.Category;
import com.cwc.fake.shop.exceptions.ResourceNotFoundException;
import com.cwc.fake.shop.repository.CategoryRepository;
import com.cwc.fake.shop.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addNew(Category category) {
		String catId = ConfigurationManager.generateRandomId();
		category.setCatId(catId);
		Category savedCategory = this.categoryRepository.save(category);
		return savedCategory;
	}

	@Override
	public Category updateCategory(Category category, String catId) {
		Category cat = this.categoryRepository.findById(catId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Category Id {} " + catId));
		cat.setCategoryName(category.getCategoryName());
		cat.setCatDescription(category.getCatDescription());
		Category updatedCategory = this.categoryRepository.save(cat);
		return updatedCategory;
	}

	@Override
	public Category patchUpdateCategory(Category category, String catId) {
		Category cat = this.categoryRepository.findById(catId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Category  Id {} " + catId));
		;
		cat.setCategoryName(category.getCategoryName());
		cat.setCatDescription(category.getCatDescription());
		Category updatedCategory = this.categoryRepository.save(cat);
		return updatedCategory;

	}

	@Override
	public Category singleCategory(String catId) {
		return this.categoryRepository.findById(catId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Category  Id {} " + catId));
	}

	@Override
	public List<Category> retriveAllCategory() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category deleteCategory(String catId) {

		return null;
	}

}
