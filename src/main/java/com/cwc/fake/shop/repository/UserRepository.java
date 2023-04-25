package com.cwc.fake.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cwc.fake.shop.entities.users.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {


	

}
