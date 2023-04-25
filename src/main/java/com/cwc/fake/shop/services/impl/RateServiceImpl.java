package com.cwc.fake.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.cwc.fake.shop.config.ConfigurationManager;
import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.rating.Rating;
import com.cwc.fake.shop.entities.users.Users;
import com.cwc.fake.shop.exceptions.ResourceNotFoundException;
import com.cwc.fake.shop.repository.ProductRepository;
import com.cwc.fake.shop.repository.RateRepository;
import com.cwc.fake.shop.repository.UserRepository;
import com.cwc.fake.shop.services.RateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private RateRepository rateRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public Rating addNewRating(Rating rating,String productId) {
		// get UserId
//		Users users = this.userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this User  Id {} " + userId));
		// get productId
		Product product = this.productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Product  Id {} " + productId));

		// set random rateId
		String rateId = ConfigurationManager.generateRandomId();

		// Now set data
		//rating.setUsers(users);
		rating.setProduct(product);
		rating.setRateId(rateId);
		// Now Save Rating
		Rating savedRating = this.rateRepository.save(rating);
		return savedRating;
	}

	@Override
	public Rating updateRating(Rating rating, String rateId) {
		Rating rate = this.rateRepository.findById(rateId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this Rate  Id {} " + rateId));
		rate.setRateDescription(rating.getRateDescription());
		rate.setCount(rating.getCount());
		rate.setRate(rating.getRate());
		//rate.setProduct(rating.getProduct());
		//rate.setUsers(rating.getUsers());
		Rating updatedRate = this.rateRepository.save(rate);
		return updatedRate;
	}

	@Override
	public Rating patchUpdateRating(Rating rating, String rateId) {
		Rating rate = this.rateRepository.findById(rateId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this Rate  Id {} " + rateId));
		rate.setRateDescription(rating.getRateDescription());
		rate.setCount(rating.getCount());
		rate.setRate(rating.getRate());
		//rate.setProduct(rating.getProduct());
		//rate.setUsers(rating.getUsers());
		Rating updatedRate = this.rateRepository.save(rate);
		return updatedRate;
	}

	@Override
	public Rating singleRating(String rateId) {
		Rating rating = this.rateRepository.findById(rateId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this Rate  Id {} " + rateId));
		return rating;
	}

	@Override
	public List<Rating> getAllRating() {
		List<Rating> rateList = this.rateRepository.findAll();
		return rateList;
	}

	@Override
	public Rating deleteRating(String rateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> getAllRatingByLimit(int limit) {
		Query query = new Query().limit(limit);
		List<Rating> limits = mongoOperations.find(query, Rating.class);
		return limits;
	}

	@Override
	public List<Rating> getAllRatingBySorting(String sort) {
		Query query = new Query();
		if (sort != null) {
			query.with(Sort.by(sort));
		}
		List<Rating> productSortList = mongoOperations.find(query, Rating.class);
		return productSortList;
	}

//	@Override
//	public List<Rating> getRatingByUserId(String userId) {
//		System.out.println( "----------------in service------------------" + userId);
//		log.info("In Service {} " + userId);
//		Users users = this.userRepository.findById(userId).get();
//				//.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this User  Id {} " + userId));
//		
//		List<Rating> list = this.rateRepository.findByUsers(users);
//		return list;
//	}
//
	@Override
	public List<Rating> getRatingByProductId(String productId) {
		Product product = this.productRepository.findById(productId).orElseThrow(
				() -> new ResourceNotFoundException("Resource not found with this Product  Id {} " + productId));
		List<Rating> list = this.rateRepository.findByProduct(product);
		return list;
	}

}
