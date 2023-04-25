package com.cwc.fake.shop.services;

import java.util.List;

import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.rating.Rating;

public interface ProductService {

	// Post : - New Product
	Product addNewProduct(Product product, String catId);

	// Update : - Update Product
	Product updateProduct(Product product, String productId);

	// Patch : - Update Patch Product
	Product patchUpdateProduct(Product product, String productId);

	// Get : - Get Single Product
	Product singleProduct(String productId);

	// Get : - Get All Product
	List<Product> retriveAllProduct();

	// Delete: - Delete Product
	Product deleteProduct(String productId);

	// Get : - Limit Product
	List<Product> checkingProductWithLimit(int limit);

	// Get : - Sort Product
	List<Product> sortingProduct(String sort);

	// Business Method

	// Get : - Get Category Product
	List<Product> getCategoryByProduct(String catId);

	// Get : - Get Product Rating List
	List<Rating> getProductByRatings(String productId);
	
	//Get : - Search Product
	List<Product> searchProductUsingProductName(String keyword);

}
