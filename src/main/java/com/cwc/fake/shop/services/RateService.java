package com.cwc.fake.shop.services;

import java.util.List;

import com.cwc.fake.shop.entities.rating.Rating;

public interface RateService {
	
	//Post : - Create New Rating
	Rating addNewRating(Rating rating,String productId);

	//Put : - Update Rating
	Rating updateRating(Rating rating,String rateId);
	//Patch : -  Update Rating
	Rating patchUpdateRating(Rating rating,String rateId);
	//Get : - Get Rating
	Rating singleRating(String rateId);
	//Get : - Get All Rating
	List<Rating> getAllRating();
	//Delete : - Delete Rating
	Rating deleteRating(String rateId);
	//Get : - Rating Limit
	List<Rating> getAllRatingByLimit(int limit);
	//Get : - Sort Rating
	List<Rating> getAllRatingBySorting(String sort);
	
	//Business Methods
	//Get : - Get Rating By User
//	List<Rating> getRatingByUserId(String userId);
	//Get : - Get Rating By Product
	List<Rating> getRatingByProductId(String productId);
}
