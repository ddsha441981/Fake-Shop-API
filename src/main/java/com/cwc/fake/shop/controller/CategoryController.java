package com.cwc.fake.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.fake.shop.entities.category.Category;
import com.cwc.fake.shop.services.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<List<Category>> createCategory(@RequestBody Category category){
		Category aCategory = this.categoryService.addNew(category);
		return new ResponseEntity<List<Category>>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("catId")String catId){
		Category upCategory = this.categoryService.updateCategory(category,catId);
		return new ResponseEntity<Category>(upCategory,HttpStatus.CREATED);
	}
	
	@PatchMapping("/{catId}")
	public ResponseEntity<Category> patchUpdateCategory(@RequestBody Category category, @PathVariable("catId")String catId){
		Category uCategory = this.categoryService.updateCategory(category,catId);
		return new ResponseEntity<Category>(uCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategory(@PathVariable String catId){
		Category sCategory = this.categoryService.singleCategory(catId);
		return new ResponseEntity<Category>(sCategory,HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> eCategoryList = this.categoryService.retriveAllCategory();
		return new ResponseEntity<List<Category>>(eCategoryList,HttpStatus.FOUND);
	}

}
