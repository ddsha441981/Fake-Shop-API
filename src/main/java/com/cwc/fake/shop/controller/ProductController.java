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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.rating.Rating;
import com.cwc.fake.shop.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/category/{catId}/product")
	public ResponseEntity<Product> addNewProducts(@RequestBody Product product, @PathVariable("catId") String catId){
		Product aAddedProduct = this.productService.addNewProduct(product,catId);
		return new ResponseEntity<Product>(aAddedProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") String productId){
		Product uUpdatedProduct = this.productService.updateProduct(product, productId);
		return new ResponseEntity<Product>(uUpdatedProduct,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/{productId}")
	public ResponseEntity<Product> updatePatchProduct(@RequestBody Product product, @PathVariable("productId") String productId){
		Product uPatchUpdatedProduct = this.productService.patchUpdateProduct(product, productId);
		return new ResponseEntity<Product>(uPatchUpdatedProduct,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") String productId){
		Product sSingleProduct = this.productService.singleProduct(productId);
		return new ResponseEntity<Product>(sSingleProduct,HttpStatus.FOUND);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> fetchAllProducts(){
		List<Product> aAllProducts = this.productService.retriveAllProduct();
		return new ResponseEntity<List<Product>>(aAllProducts,HttpStatus.FOUND);
	}
	
	@GetMapping("/category/{catId}/product")
	public ResponseEntity<List<Product>> retriveProductByCategory(@PathVariable("catId") String catId){
		 List<Product> cCategoryByProduct = this.productService.getCategoryByProduct(catId);
		return new ResponseEntity<List<Product>>(cCategoryByProduct,HttpStatus.FOUND);
	}
	
	@GetMapping("/rating/{productId}/product")
	public ResponseEntity<List<Rating>> retriveProductByRating(@PathVariable("productId") String productId){
		List<Rating> ratingList = this.productService.getProductByRatings(productId);
		return new ResponseEntity<List<Rating>>(ratingList,HttpStatus.FOUND);
	}
	
	@GetMapping("/limit")
	public ResponseEntity<List<Product>> getProductByLimit(@RequestParam("limit") int limit){
		List<Product> checkingProductWithLimit = this.productService.checkingProductWithLimit(limit);
		return new ResponseEntity<List<Product>>(checkingProductWithLimit,HttpStatus.FOUND);
	}
	
	@GetMapping("/sort")
	public ResponseEntity<List<Product>> getProductBySorting(@RequestParam("sort") String sort){
		List<Product> sortingProduct = this.productService.sortingProduct(sort);
		return new ResponseEntity<List<Product>>(sortingProduct,HttpStatus.FOUND);
	}
	
	@GetMapping("/title")
	public ResponseEntity<List<Product>> searchByProductName(@RequestParam("title") String title){
		 List<Product> sortingProduct = this.productService.sortingProduct(title);
		return new ResponseEntity<List<Product>>(sortingProduct,HttpStatus.FOUND);
	}

}
