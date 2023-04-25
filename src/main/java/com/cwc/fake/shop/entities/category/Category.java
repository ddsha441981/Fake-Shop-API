package com.cwc.fake.shop.entities.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class Category {

	@Id
	private String catId;
    private String categoryName;
    private String catDescription;
    private boolean catEnable;
   
}
