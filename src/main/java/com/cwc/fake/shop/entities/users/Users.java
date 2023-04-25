package com.cwc.fake.shop.entities.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Document
public class Users {
	@Id
	
	private String userId;
	
	private Address address;

	private String email;
	
	private String username;
	
	private String password;
	
	private Name name;

	private String phone;
	
	private int __v;
}
