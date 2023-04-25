package com.cwc.fake.shop.services;

import java.util.List;

import com.cwc.fake.shop.entities.category.Category;

public interface CategoryService {

	// Add : - New Category
	Category addNew(Category category);

	// Update : - Update Category
	Category updateCategory(Category category, String catId);

	// Patch : - Update Patch Category
	Category patchUpdateCategory(Category category, String catId);

	// Get : - Get Single Category
	Category singleCategory(String catId);

	// Get : - Get All Category
	List<Category> retriveAllCategory();

	// Delete: - Delete Category
	Category deleteCategory(String catId);
}
