package com.cwc.fake.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cwc.fake.shop.entities.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{

}
