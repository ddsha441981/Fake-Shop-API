package com.cwc.fake.shop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.rating.Rating;
import com.cwc.fake.shop.entities.users.Users;

@Repository
public interface RateRepository extends MongoRepository<Rating, String>{

//	  @Query("{product : ?0}")      
//	List<Rating> findByRate(Product product);

//	
//	List<Rating> findByUsers(Users users);
//
	@Query("select * from rating where productId=product")
	List<Rating> findByProduct(Product product);

}
