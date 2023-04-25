package com.cwc.fake.shop.entities.rating;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cwc.fake.shop.entities.product.Product;
import com.cwc.fake.shop.entities.users.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Document
public class Rating {

	@Id
	private String rateId;
//	private String email;
	private String rateDescription;
//	private Users users;
	private Product product;
	private double rate;
	private int count;
}
