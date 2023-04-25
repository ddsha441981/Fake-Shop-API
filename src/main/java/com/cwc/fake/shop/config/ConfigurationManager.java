package com.cwc.fake.shop.config;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationManager {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static String generateRandomId() {
		return UUID.randomUUID().toString();
	}
}
