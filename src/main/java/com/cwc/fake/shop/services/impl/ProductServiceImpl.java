package com.cwc.fake.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cwc.fake.shop.config.ConfigurationManager;
import com.cwc.fake.shop.entities.category.Category;
import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.rating.Rating;
import com.cwc.fake.shop.exceptions.ResourceNotFoundException;
import com.cwc.fake.shop.repository.CategoryRepository;
import com.cwc.fake.shop.repository.ProductRepository;
import com.cwc.fake.shop.repository.RateRepository;
import com.cwc.fake.shop.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RateRepository rateRepository;

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product addNewProduct(Product product, String catId) {
		Category category = categoryRepository.findById(catId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Category  Id {} " + catId));
		// Generate Random Product Id
		String productId = ConfigurationManager.generateRandomId();
		product.setProductId(productId);
		// Now Set Category Here
		product.setCategory(category);
		
		Product savedProduct = this.productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product updateProduct(Product product, String productId) {
		Product products = this.productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Product  Id {} " + productId));
		products.setCategory(product.getCategory());
//		products.setRating(product.getRating());
		products.setTitle(product.getTitle());
		products.setPrice(product.getPrice());
		products.setImage(product.getImage());
		products.setDescription(product.getDescription());
		Product updatedProduct = this.productRepository.save(products);
		return updatedProduct;
	}

	@Override
	public Product patchUpdateProduct(Product product, String productId) {
		Product products = this.productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Product  Id {} " + productId));
		products.setCategory(product.getCategory());
//		products.setRating(product.getRating());
		products.setTitle(product.getTitle());
		products.setPrice(product.getPrice());
		products.setImage(product.getImage());
		products.setDescription(product.getDescription());
		Product updatedProduct = this.productRepository.save(products);
		return updatedProduct;
	}

	@Override
	public Product singleProduct(String productId) {
		return this.productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Product  Id {} " + productId));
	}

	@Override
	public List<Product> retriveAllProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Product deleteProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getCategoryByProduct(String catId) {
		Category category = this.categoryRepository.findById(catId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Category  Id {} " + catId));
		List<Product> productListByCategory = this.productRepository.findByCategory(category);
		return productListByCategory;
	}

	@Override
	public List<Rating> getProductByRatings(String productId) {
		Product product = this.productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Resource not found with this Product  Id {} " + productId));
		List<Rating> byProduct = this.rateRepository.findByProduct(product);
		return byProduct;
	}



	@Override
	public List<Product> checkingProductWithLimit(int limit) {
		Query query = new Query().limit(limit);
		List<Product> productLimitList = mongoOperations.find(query, Product.class);
		return productLimitList;
	}

	@Override
	public List<Product> sortingProduct(String sort) {
		Query query = new Query();
		if (sort != null) {
			query.with(Sort.by(sort));
		}
		List<Product> productSortList = mongoOperations.find(query, Product.class);
		return productSortList;
	}

	@Override
	public List<Product> searchProductUsingProductName(String title) {
		List<Product> findProductByKeyword = this.productRepository.findProductByKeyword(title);
		return findProductByKeyword;
	}

}
