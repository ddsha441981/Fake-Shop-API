package com.cwc.fake.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.fake.shop.entities.rating.Rating;
import com.cwc.fake.shop.services.RateService;

@RestController
@RequestMapping("/api/v1/rating")
public class RateController {

	@Autowired
	private RateService rateService;

	@PostMapping("/product/{productId}")//product/{productId}/user/{userId}
	public ResponseEntity<Rating> createRate(
			@RequestBody Rating rating, 
			@PathVariable("productId") String productId
//			@PathVariable("userId") String userId
			) {
		Rating addedRating = this.rateService.addNewRating(rating,productId);
		return new ResponseEntity<Rating>(addedRating, HttpStatus.CREATED);

	}
	
	@GetMapping("/{rateId}")
	public ResponseEntity<Rating> getSingleRate(@PathVariable("rateId") String rateId) {
		Rating singleRating = this.rateService.singleRating(rateId);
		return new ResponseEntity<Rating>(singleRating, HttpStatus.CREATED);

	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRate() {
		List<Rating> listRating = this.rateService.getAllRating();
		return new ResponseEntity<List<Rating>>(listRating, HttpStatus.CREATED);
	}

//	@GetMapping("/users/{userId}")
//	public ResponseEntity<List<Rating>> getRatingUsers(@PathVariable("userId") String userId) {
//		System.out.println( "----------------------------------" + userId);
//		 List<Rating> ratingByUserId = this.rateService.getRatingByUserId(userId);
//		return new ResponseEntity<List<Rating>>(ratingByUserId, HttpStatus.CREATED);
//	}
//	
	@GetMapping("/product/{productId}")
	public ResponseEntity<List<Rating>> getProductsById(@PathVariable("productId") String productId) {
	List<Rating> ratingByProductId = this.rateService.getRatingByProductId(productId);
		return new ResponseEntity<List<Rating>>(ratingByProductId, HttpStatus.CREATED);

	}
}
