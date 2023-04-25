package com.cwc.fake.shop.entities.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cwc.fake.shop.entities.category.Category;
import com.cwc.fake.shop.entities.rating.Rating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@Builder
@Document
public class Product {

	@Id
	private String productId;

	private String title;

	private double price;

	private String description;

	private Category category;

	private String image;

	private List<Rating> rating = new ArrayList<>();
}
