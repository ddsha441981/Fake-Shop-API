package com.cwc.fake.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cwc.fake.shop.entities.category.Category;
import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.rating.Rating;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(Category category);

	@Query("select title from product where title like=%title%")
	List<Product> findProductByKeyword(String title);

	@Query("select * from rating where productId=rating")
	List<Rating> findByRating(Rating rating);
}
